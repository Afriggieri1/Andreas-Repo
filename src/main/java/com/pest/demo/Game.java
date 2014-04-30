/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class Game {

    int SizeOfMap;
    int NumOfPlayers;
    Map DefaultMap;
    ArrayList<Player> players = new ArrayList(); // Array list hoding all the players
    //ArrayList<Map> maps = new ArrayList<>(); //Array list holding all the maps
    ArrayList<Player> winners = new ArrayList();
    boolean won = false;

    public Game(int size, int players) {
        this.SizeOfMap = size;
        this.NumOfPlayers = players;
        this.players = CreatePlayers();
        this.DefaultMap = CreateMap();
    }

    private ArrayList<Player> CreatePlayers() {
        for (int i = 0; i < NumOfPlayers; i++) {
            Player p = new Player(i + 1);
            players.add(p);
        }
        return players;
    }

    private Map CreateMap() {

        Tile[][] MapTemplate = new Tile[SizeOfMap][SizeOfMap];
        int TotalTiles = SizeOfMap * SizeOfMap;

        //assign grass
        for (int j = 0; j < SizeOfMap; j++) {
            for (int k = 0; k < SizeOfMap; k++) {

                MapTemplate[j][k] = new Tile();

            }
        }

        //assign water
        int WaterTiles = TotalTiles / 4;

        int count = 0;
        do {
            int xwater = (int) (Math.random() * SizeOfMap);
            int ywater = (int) (Math.random() * SizeOfMap);
            if (MapTemplate[ywater][xwater].getType() != 'T' && MapTemplate[ywater][ywater].getType() != 'W') {
                MapTemplate[ywater][xwater].setType('W');
                count++;
            }
        } while (count <= WaterTiles);

        //assign treasure
        int TreasureX = (int) (Math.random() * SizeOfMap);
        int TreasureY = (int) (Math.random() * SizeOfMap);

        System.out.println(TreasureX);
        System.out.println(TreasureY);

        MapTemplate[TreasureY][TreasureX].setType('T');

        Map newMap = new Map(MapTemplate);

        //for (int i = 0; i < NumOfPlayers; i++) {
        // players.get(i).setMap(new Map(MapTemplate.clone()));
        //maps.add(players.get(i).getMap());
        // }
        for (int i = 0; i < SizeOfMap; i++) {
            for (int j = 0; j < SizeOfMap; j++) {
                System.out.print(MapTemplate[i][j].getType() + "  ");
            }
            System.out.println("");
        }
        return newMap;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        //set starting positions for all players
        for (int i = 0; i < players.size(); i++) {
            Player AlterPlayer = players.get(i);

            Position startPos = this.DefaultMap.startPosition();
            AlterPlayer.setPosition(startPos);
            GenerateHTMLFile(AlterPlayer);
        }

        do {
            //start the transitions
            for (int i = 0; i < players.size(); i++) {
                //each player chooses where to move
                if (isWater(players.get(i).getPosition()) == true) {
                    //check for water
                    Position startPos = players.get(i).getTrail().get(0);
                    players.get(i).ResetTrail();
                    players.get(i).setPosition(startPos);

                    System.out.println("You've ran out of land! Return to starting position (Refresh)");
                    GenerateHTMLFile(players.get(i));
                }

                System.out.println("Player " + players.get(i).getPlayerid() + ", please choose your next move ([U]p, [D]own, [L]eft or [R]ight)");

                players.get(i).move(sc.next().charAt(0), this.DefaultMap);
                GenerateHTMLFile(players.get(i));

                if (isTreasure(players.get(i).getPosition()) == true) {
                    winners.add(players.get(i));
                    won = true;
                }

            }
        } while (won == false);

        int TotalWinners = winners.size();
        do {
            if (TotalWinners == 1) {
                System.out.println("Player " + winners.get(0).getPlayerid() + " has won the game!");
                TotalWinners--;
            } else if (TotalWinners == 2) {
                System.out.println("Player " + winners.get(0).getPlayerid() + " and Player " + players.get(1).getPlayerid() + " have won the game!");
                TotalWinners -= 2;
            } else {
                for (int player = 0; player < winners.size() - 2; player++) {
                    System.out.print("Player " + winners.get(player).getPlayerid() + ", ");
                    winners.remove(player);
                    TotalWinners--;
                }
            }
        } while (TotalWinners > 0);
        //for (Player winner : winners) {
        //    System.out.print("Player " + winner.getPlayerid() + " ");
        //}
        // System.out.println("won the game!");
    }

    public boolean isWater(Position pos) {
        return pos.getTile().getType() == 'W';
    }

    private boolean isTreasure(Position pos) {
        return pos.getTile().getType() == 'T';
    }

    private void GenerateHTMLFile(Player CurrentPlayer) {

        for (int i = 0; i < CurrentPlayer.getTrail().size(); i++) {
            Position CurrentTile = CurrentPlayer.getTrail().get(i);
            CurrentTile.getTile().setVisibility(true);
        }

        String code = "";
        code += "<!DOCTYPE><html><head><style>table,th,td{border:1px solid black;border-collapse:collapse;}th,td</style></head>\n";
        code += "<body><h1>Player " + CurrentPlayer.getPlayerid() + " Map</h1>\n";
        //code += "<table class=\"fixed\" border=1 width=300 bgcolor=\"A8A8A8\">\n";
        code += "<table class=\"fixed\" border=1 bgcolor=\"A8A8A8\">\n";

        for (int i = 0; i < SizeOfMap; i++) {
            code += "<tr>";
            for (int j = 0; j < SizeOfMap; j++) {
                if (this.DefaultMap.getTile(i, j).getVisibility() == false) {
                    code += "<td width='50' height='50'> </td>\n";
                } else {
                    if (this.DefaultMap.getTile(i, j).getType() == 'T') {
                        //tile contains treasure
                        code += "<TD BGCOLOR=\"#ffff00\" width='50' height='50'align=\"center\">\n";
                        if (this.DefaultMap.getTile(i, j) == CurrentPlayer.getPosition().getTile()) {
                            code += "<img src=\"Happy_smiley_face.png\" height='30' width='30'></img>";
                        }
                    }
                    if (this.DefaultMap.getTile(i, j).getType() == 'G') {
                        //tile contains grass
                        code += "<TD BGCOLOR=\"#00ff00\" width='50' height='50' align=\"center\">\n";
                        if (this.DefaultMap.getTile(i, j) == CurrentPlayer.getPosition().getTile()) {
                            code += "<img src=\"smiley.png\" height='30' width='30'></img>";
                        }
                    }
                    if (this.DefaultMap.getTile(i, j).getType() == 'W') {
                        //tile contains water
                        code += "<TD BGCOLOR=\"#0000ff\" width='50' height='50'align=\"center\">\n";
                        if (this.DefaultMap.getTile(i, j) == CurrentPlayer.getPosition().getTile()) {
                            code += "<img src=\"sad.png\" height='30' width='30'></img>";
                        }
                    }

                }
            }
            code += "</tr>";
        }

        code += "</table></body></html>";

        try {
            File map = new File("map_player_" + CurrentPlayer.getPlayerid() + ".html");
            map.createNewFile();
            map.delete();
            map.createNewFile();
            FileWriter writehtml = new FileWriter(map);
            //try (FileWriter writehtml = new FileWriter(map)) {

                writehtml.write(code);
                //writehtml.flush();
                writehtml.close();
            //} catch (Exception e) {
             //   System.out.println("Cannot write to existing HTML file");
            //}

        } catch (IOException ioe) {
            System.out.println("Cannot create HTML file: " + ioe);
        }
        for (int i = 0; i < CurrentPlayer.getTrail().size(); i++) {
            Position CurrentTile = CurrentPlayer.getTrail().get(i);
            CurrentTile.getTile().setVisibility(false);
        }
    }
}

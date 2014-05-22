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
	int NumOfTeams;
	int difficulty;
	Map DefaultMap;
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<Player> winners = new ArrayList<Player>();
	boolean won = false;

	// Tile[][] MapTemplate;

	public Game(int size, int players, int d, int t) {
		this.SizeOfMap = size;
		this.NumOfPlayers = players;
		this.NumOfTeams = t;
		this.players = CreatePlayers();
		this.teams = CreateTeams();
		// this.DefaultMap = CreateMap();
		this.difficulty = d;

	}

	public ArrayList<Player> CreatePlayers() {
		for (int i = 0; i < NumOfPlayers; i++) {
			Player p = new Player(i + 1);
			players.add(p);
		}
		return players;
	}

	public ArrayList<Team> CreateTeams() {
		for (int i = 0; i < NumOfTeams; i++) {
			Team t = new Team();
			teams.add(t);
		}
		return teams;
	}

	/*
	 * public Map CreateMap() {
	 * 
	 * MapTemplate= new Tile[SizeOfMap][SizeOfMap];
	 * 
	 * 
	 * //assign grass for (int j = 0; j < SizeOfMap; j++) { for (int k = 0; k <
	 * SizeOfMap; k++) {
	 * 
	 * MapTemplate[j][k] = new Tile();
	 * 
	 * } } int TreasureX = (int) (Math.random() * SizeOfMap); int TreasureY =
	 * (int) (Math.random() * SizeOfMap);
	 * MapTemplate[TreasureY][TreasureX].setType('T');
	 * 
	 * AssignWater();
	 * 
	 * //System.out.println(TreasureX); //System.out.println(TreasureY);
	 * 
	 * 
	 * 
	 * Map newMap = new Map(MapTemplate);
	 * 
	 * //for (int i = 0; i < NumOfPlayers; i++) { // players.get(i).setMap(new
	 * Map(MapTemplate.clone())); //maps.add(players.get(i).getMap()); // }
	 * //Din kolla trid titlaq thawn taht for (int i = 0; i < SizeOfMap; i++) {
	 * for (int j = 0; j < SizeOfMap; j++) {
	 * System.out.print(MapTemplate[i][j].getType() + "  "); }
	 * System.out.println(""); } return newMap; }
	 * 
	 * //assign water public int AssignWater(){ int TotalTiles =
	 * assignDificulty();
	 * 
	 * System.out.println("TotalTiles= "+TotalTiles); int count = 0; do { int
	 * xwater = (int) (Math.random() * SizeOfMap); int ywater = (int)
	 * (Math.random() * SizeOfMap); if (MapTemplate[ywater][xwater].getType() !=
	 * 'T' && MapTemplate[ywater][ywater].getType() != 'W') {
	 * MapTemplate[ywater][xwater].setType('W'); count++; } } while (count <=
	 * TotalTiles); System.out.println("Water are set"); return TotalTiles; }
	 * public int assignDificulty(){ int TotalTiles = SizeOfMap * SizeOfMap;
	 * 
	 * if(difficulty == 1){ int WaterTiles = TotalTiles / 4; return WaterTiles;
	 * } else{ double WaterTiles1 = TotalTiles /4 ; double WaterTiles2=
	 * TotalTiles *0.35 ;
	 * 
	 * int WaterTiles=(int)(WaterTiles1 + (Math.random() * (WaterTiles2 -
	 * WaterTiles1))); return WaterTiles; } //return 1; }
	 */

	public void startGame() {

		// set starting positions for all players
		if (NumOfTeams == 0) {
			System.out.println("Individual Play");
			IndividualPlay();
		} else {
			System.out.println("Team Play");
			TeamPlay();
		}

		DisplayWinners();

		// for (Player winner : winners) {
		// System.out.print("Player " + winner.getPlayerid() + " ");
		// }
		// System.out.println("won the game!");
	}

	public void AssignPlayersInTeams() {
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			int team_num = (int) (Math.random() * (NumOfTeams));
			teams.get(team_num).AttachPlayer(p);

		}
	}

	public void TeamPlay() {
		boolean valid_teams = false;
	
		//makes sure that there are no teams with zero players
		for (int i = 0; i < teams.size(); i++) {
			do {
				valid_teams = true;
				if (teams.get(i).getPlayers().size() == 0) {
					for (int j = 0; j < teams.size(); j++) {
						teams.get(j).ClearPlayers();
					}
					AssignPlayersInTeams();
					i=0;
					valid_teams = false;
				}
			} while (valid_teams == false);
		}

		for (int i = 0; i < teams.size(); i++) {

			System.out.println("Team: "+(i+1));
			MapCreator creator = new MapCreator();
			creator.createMap(difficulty, SizeOfMap);
			
			//for (int j = 0;j<teams.get(i).getPlayers().size();j++){
				//System.out.println("\nPlayer "+teams.get(i).getPlayers().get(j).getPlayerid());
				//Position startPos = Map.startPosition();
				//teams.get(i).getPlayers().get(j).setPosition(startPos);
				
			//	teams.get(i).AddPosition(startPos);
			//}
			Position startPos = Map.startPosition();

			teams.get(i).setPosition(startPos);
			teams.get(i).NotifyPlayers();
			System.out.println("Number of players in team: "
					+ teams.get(i).getPlayers().size());
		}

		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			GenerateHTMLFile(p);
		}

		Scanner sc = new Scanner(System.in);

		do {
			// start the transitions
			for (int i = 0; i < teams.size(); i++) {
				// each player chooses where to move
				Player ToPlay = teams.get(i).SelectPlayer();
				int trail_size = ToPlay.getTrail().size();
				if (checkTileForWater(ToPlay.getPlayerid() - 1) < trail_size) {
					System.out.println("WATER PROCEDURE");
					teams.get(i).setTrail(ToPlay.getTrail());
					teams.get(i).NotifyPlayers();

					for (int j = 0; j < teams.get(i).getPlayers().size(); j++) {
						GenerateHTMLFile(teams.get(i).getPlayers().get(j));
					}
				}

				System.out
						.println("Player "
								+ ToPlay.getPlayerid()
								+ " (Team "
								+ (i + 1)
								+ "), please choose your next move ([U]p, [D]own, [L]eft or [R]ight)");
				String turn = sc.next();
				// int r=turn.compareTo("u");
				// System.out.println(r);
				boolean valid_move = false;
				do {
					if (turn.compareTo("u") == 0 || turn.compareTo("U") == 0
							|| turn.compareTo("d") == 0
							|| turn.compareTo("D") == 0
							|| turn.compareTo("l") == 0
							|| turn.compareTo("L") == 0
							|| turn.compareTo("r") == 0
							|| turn.compareTo("R") == 0) {
						valid_move = true;
					} else {
						System.out
								.print("Enter correct choice ([U]p, [D]own, [L]eft or [R]ight) : ");
						turn = sc.next();
						valid_move = false;
					}
				} while (valid_move == false);
				ToPlay.move(turn.charAt(0), this.DefaultMap);
				teams.get(i).setPosition(ToPlay.getPosition());
				// update all player trails and current pos
				teams.get(i).NotifyPlayers();

				// generate html file for each play in the team
				for (int j = 0; j < teams.get(i).getPlayers().size(); j++) {
					GenerateHTMLFile(teams.get(i).getPlayers().get(j));
				}

				// if won, store winners
				if (isTreasure(ToPlay.getPosition()) == true) {
					
						winners=teams.get(i).getPlayers();
					
					won = true;
				}

			}
		} while (won == false);
	}

	public void IndividualPlay() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < players.size(); i++) {
			Player AlterPlayer = players.get(i);
			MapCreator creator = new MapCreator();
			creator.createMap(difficulty, SizeOfMap);
			Position startPos = Map.startPosition();
			AlterPlayer.setPosition(startPos);
			GenerateHTMLFile(AlterPlayer);
		}

		do {
			// start the transitions
			for (int i = 0; i < players.size(); i++) {
				// each player chooses where to move
				checkTileForWater(i);

				System.out
						.println("Player "
								+ players.get(i).getPlayerid()
								+ ", please choose your next move ([U]p, [D]own, [L]eft or [R]ight)");
				String turn = sc.next();
				// int r=turn.compareTo("u");
				// System.out.println(r);
				boolean valid_move = false;
				do {
					if (turn.compareTo("u") == 0 || turn.compareTo("U") == 0
							|| turn.compareTo("d") == 0
							|| turn.compareTo("D") == 0
							|| turn.compareTo("l") == 0
							|| turn.compareTo("L") == 0
							|| turn.compareTo("r") == 0
							|| turn.compareTo("R") == 0) {
						valid_move = true;
					} else {
						System.out
								.print("Enter correct choice ([U]p, [D]own, [L]eft or [R]ight) : ");
						turn = sc.next();
						valid_move = false;
					}
				} while (valid_move == false);
				players.get(i).move(turn.charAt(0), this.DefaultMap);
				GenerateHTMLFile(players.get(i));

				if (isTreasure(players.get(i).getPosition()) == true) {
					winners.add(players.get(i));
					won = true;
				}

			}
		} while (won == false);
	}

	public int checkTileForWater(int i) {
		if (isWater(players.get(i).getPosition()) == true) {
			// check for water
			System.out.println("Water tile detected");
			Position startPos = players.get(i).getTrail().get(0);
			players.get(i).ResetTrail();
			players.get(i).setPosition(startPos);

			System.out
					.println("You've ran out of land! Return to starting position (Refresh)");
			GenerateHTMLFile(players.get(i));
		}
		int ret = players.get(i).getTrail().size();
		System.out.println(ret);
		return ret;
	}

	public int DisplayWinners() {
		int TotalWinners = winners.size();
		do {
			if (TotalWinners == 1) {
				System.out.println("Player " + winners.get(0).getPlayerid()
						+ " has won the game!");
				TotalWinners--;
			} else if (TotalWinners == 2) {
				System.out.println("Player " + winners.get(0).getPlayerid()
						+ " and Player " + players.get(1).getPlayerid()
						+ " have won the game!");
				TotalWinners -= 2;
			} else {
				for (int player = 0; player < winners.size() - 2; player++) {
					System.out.print("Player "
							+ winners.get(player).getPlayerid() + ", ");
					winners.remove(player);
					TotalWinners--;
				}
			}
		} while (TotalWinners > 0);
		return TotalWinners;
	}

	public boolean isWater(Position pos) {
		return pos.getTile().getType() == 'W';
	}

	public boolean isTreasure(Position pos) {
		return pos.getTile().getType() == 'T';
	}

	public File GenerateHTMLFile(Player CurrentPlayer) {

		for (int i = 0; i < CurrentPlayer.getTrail().size(); i++) {
			Position CurrentTile = CurrentPlayer.getTrail().get(i);
			CurrentTile.getTile().setVisibility(true);
		}

		String code = "";
		code += "<!DOCTYPE><html><head><style>table,th,td{border:1px solid black;border-collapse:collapse;}th,td</style></head>\n";
		code += "<body><h1>Player " + CurrentPlayer.getPlayerid()
				+ " Map</h1>\n";
		// code +=
		// "<table class=\"fixed\" border=1 width=300 bgcolor=\"A8A8A8\">\n";
		code += "<table class=\"fixed\" border=1 bgcolor=\"A8A8A8\">\n";

		for (int i = 0; i < SizeOfMap; i++) {
			code += "<tr>";
			for (int j = 0; j < SizeOfMap; j++) {
				if (Map.getTile(i, j).getVisibility() == false) {
					code += "<td width='50' height='50'> </td>\n";
				} else {
					if (Map.getTile(i, j).getType() == 'T') {
						// tile contains treasure
						code += "<TD BGCOLOR=\"#ffff00\" width='50' height='50'align=\"center\">\n";
						if (Map.getTile(i, j) == CurrentPlayer.getPosition()
								.getTile()) {
							code += "<img src=\"Happy_smiley_face.png\" height='30' width='30'></img>";
						}
					}
					if (Map.getTile(i, j).getType() == 'G') {
						// tile contains grass
						code += "<TD BGCOLOR=\"#00ff00\" width='50' height='50' align=\"center\">\n";
						if (Map.getTile(i, j) == CurrentPlayer.getPosition()
								.getTile()) {
							code += "<img src=\"smiley.png\" height='30' width='30'></img>";
						}
					}
					if (Map.getTile(i, j).getType() == 'W') {
						// tile contains water
						code += "<TD BGCOLOR=\"#0000ff\" width='50' height='50'align=\"center\">\n";
						if (Map.getTile(i, j) == CurrentPlayer.getPosition()
								.getTile()) {
							code += "<img src=\"sad.png\" height='30' width='30'></img>";
						}
					}

				}
			}
			code += "</tr>";
		}

		code += "</table></body></html>";
		File map = new File("map_player_" + CurrentPlayer.getPlayerid()
				+ ".html");
		try {

			map.createNewFile();
			map.delete();
			map.createNewFile();
			FileWriter writehtml = new FileWriter(map);
			// try (FileWriter writehtml = new FileWriter(map)) {

			writehtml.write(code);
			// writehtml.flush();
			writehtml.close();
			// } catch (Exception e) {
			// System.out.println("Cannot write to existing HTML file");
			// }

		} catch (IOException ioe) {
			System.out.println("Cannot create HTML file: " + ioe);
		}
		for (int i = 0; i < CurrentPlayer.getTrail().size(); i++) {
			Position CurrentTile = CurrentPlayer.getTrail().get(i);
			CurrentTile.getTile().setVisibility(false);
		}
		return map;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.engineering;

import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class Launcher {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int noplayers;
      int size;
      Scanner sc=new Scanner(System.in);
        do {
            System.out.print("Enter number of players (min:2 max:8): ");
            noplayers = sc.nextInt();
        } while (InputPlayers(noplayers)!=true);
        do {
            System.out.print("Enter the map size nxn(max:50): ");
            size = sc.nextInt();
        }while(InputMapsize(noplayers,size)!=true);
        
        
        

        Game game = new Game(size, noplayers);
        game.startGame();
    }

    public static Boolean InputPlayers(int players) {
        if(players>1&&players<9){
            return true;
        }
        return false;
    }

    public static Boolean InputMapsize(int players,int mapsize) {
        
        
           if ((mapsize > 50) || (mapsize <= 0)) {
                System.out.println("Invalid Map Size");
                return false;
            } else {
                if (players >= 2 && players <= 4) {
                    if (mapsize < 5) {
                        System.out.println("Minimum size of map for the number of players is 5");
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    if (mapsize < 8) {
                        System.out.println("Minimum size of the map for this number of players is 8 ");
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        
        
    }

}

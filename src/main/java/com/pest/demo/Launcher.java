/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.demo;

import java.util.*;

/**
 *
 * @author Andreas
 */
public class Launcher {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int noplayers=getPlayers();     
      int size=getMapsize(noplayers);
      
        
        
        

        Game game = new Game(size, noplayers);
        game.startGame();
        
    }
    
    public static int getPlayers(){
        Scanner sc=new Scanner(System.in);
        int noplayers;
        do {
            System.out.print("Enter number of players (min:2 max:8): ");
            try {
                noplayers = sc.nextInt();
            } catch (InputMismatchException iomismatch) {
                System.out.println("Invalid input!");
                noplayers = 100;
                sc.next();

            }
            do {

                if (noplayers> 8) {
                    System.out.print("Please Re-enter your choice between 2 & 8: ");
                    try {
                        noplayers = sc.nextInt();

                    } catch (InputMismatchException iomismatch) {
                        System.out.println("Invalid input!");
                        noplayers = 100;
                        sc.next();
                    }
                }
            } while (noplayers > 8);
           
                //System.out.print("please re enter correct number: ");
            // noplayers=sc.nextInt();
        } while (InputPlayers(noplayers) != true);
        return noplayers;
    }
    
    public static int getMapsize(int noplayers){
        Scanner sc=new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter the map size nxn(max:50): ");
            try{
                size = sc.nextInt();
            }
            catch(InputMismatchException iomismatch){
                System.out.println("invalid input");
                size=100;
                sc.next();
            }
            do {

                if (size > 50) {
                    System.out.print("Please Re-enter your choice: ");
                    try {
                        size = sc.nextInt();

                    } catch (InputMismatchException iomismatch) {
                        System.out.println("Invalid input!");
                        size = 100;
                        sc.next();
                    }
                }
            } while (size > 50);
        }while(InputMapsize(noplayers,size)!=true);
        return size;
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

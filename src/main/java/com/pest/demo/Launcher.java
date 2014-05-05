/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.demo;

import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * 
 * @author Andreas
 */
public class Launcher {
    static int noplayers;
    static int size;
    static int dificulty;
	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		
		
		ReadInputs();            
				Game game = new Game(size, noplayers,dificulty);
				game.startGame();
			
                        
		

	}

	public static boolean CheckPlayers(int noplayers) {
		if ((noplayers >= 2) && (noplayers <= 8))
			return true;
		else
			return false;

	}

	public static void ReadInputs() {
		Scanner sc = new Scanner(System.in);
		int players = 0;
		boolean valid = false;
                do{
                    do {
			try {
				System.out.print("Enter Number of Players, between 2 and 8: ");
				players = sc.nextInt();
				valid = true;
			} catch (InputMismatchException iomismatch) {
				System.out.println("Invalid input!");
				valid = false;
			}
                    } while (valid == false);
                }while(CheckPlayers(players) == false);
                
                noplayers=players;
                
                
                boolean valid1 = true;
		do {
			do{
			//System.out.print("Enter the map size nxn(max:50): ");
			try {
				System.out.print("Enter the map size nxn(max:50): ");
				size = sc.nextInt();
			 
			} catch (InputMismatchException iomismatch) {
				System.out.println("invalid input");
				valid1 = false;
				//sc.next();
			}
			}while(valid1==false);
		} while (CheckMapsize(noplayers, size) != true);
                
                
		 dificulty=1;
		boolean valid2 = false;
		do {
			try {
				System.out.print("Enter dificulty of the game 1 for safe and 2 for Hazardous : ");
				dificulty = sc.nextInt();
				valid2 = true;
			} catch (InputMismatchException iomismatch) {
				System.out.println("Invalid input!");
				valid2 = false;
			}
		} while (valid2 == false);
	}
        

	

	public static Boolean CheckMapsize(int players, int mapsize) {

		if ((mapsize > 50) || (mapsize <= 0)) {
			System.out.println("Invalid Map Size");
			return false;
		} else {
			if (players >= 2 && players <= 4) {
				if (mapsize < 5) {
					System.out
							.println("Minimum size of map for the number of players is 5");
					return false;
				} else {
					return true;
				}
			} else {
				if (mapsize < 8) {
					System.out
							.println("Minimum size of the map for this number of players is 8 ");
					return false;
				} else {
					return true;
				}
			}
		}

	}

}

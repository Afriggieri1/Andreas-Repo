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

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		int noplayers = ReadPlayers();
		do {
			if (CheckPlayers(noplayers)) {
				int size = getMapsize(noplayers);
                                int dificulty=ReadDificulty();
                                System.out.println(dificulty);
				Game game = new Game(size, noplayers,dificulty);
				game.startGame();
			}
		} while (CheckPlayers(noplayers) == false);

	}

	public static boolean CheckPlayers(int noplayers) {
		if ((noplayers > 0) && (noplayers <= 8))
			return true;
		else
			return false;

	}

	public static int ReadPlayers() {
		Scanner sc = new Scanner(System.in);
		int players = 0;
		boolean valid = false;
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
		//sc.close();
		return players;
	}
        public static int ReadDificulty() {
		Scanner sc = new Scanner(System.in);
		int dif=1;
		boolean valid = false;
		do {
			try {
				System.out.print("Enter dificulty of the game 1 for safe and 2 for Hazardous : ");
				dif = sc.nextInt();
				valid = true;
			} catch (InputMismatchException iomismatch) {
				System.out.println("Invalid input!");
				valid = false;
			}
		} while (valid == false);
		//sc.close();
		return dif;
	}

	public static int getMapsize(int noplayers) {
		Scanner sc = new Scanner(System.in);
		//sc.useDelimiter("\n");
		int size = 0;
		boolean valid = true;
		do {
			do{
			//System.out.print("Enter the map size nxn(max:50): ");
			try {
				System.out.print("Enter the map size nxn(max:50): ");
				size = sc.nextInt();
			 
			} catch (InputMismatchException iomismatch) {
				System.out.println("invalid input");
				valid = false;
				//sc.next();
			}
			}while(valid==false);
		} while (CheckMapsize(noplayers, size) != true);
		//sc.close();
		return size; 
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

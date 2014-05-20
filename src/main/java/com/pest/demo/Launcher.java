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
	//number of players
	static int noplayers;
	//length of one side of map
	static int size;
	//hazardous of safe mode
	static int difficulty;
	//teams or individual
	static int mode;
	//amount of teams
	static int teams_amount = 0;

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {

		ReadInputs();
		Game game = new Game(size, noplayers, difficulty);
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
		boolean valid_players = false;
		do {
			do {
				try {
					System.out
							.print("Enter Number of Players, between 2 and 8: ");
					players = sc.nextInt();
					valid_players = true;
				} catch (InputMismatchException iomismatch) {
					System.out.println("Invalid input!");
					valid_players = false;
				}
			} while (valid_players == false);
		} while (CheckPlayers(players) == false);

		noplayers = players;

		boolean valid_map = true;
		do {
			do {
				// System.out.print("Enter the map size nxn(max:50): ");
				try {
					System.out
							.print("Enter the length of one side of the map (max: 50): ");
					size = sc.nextInt();
					valid_map = true;

				} catch (InputMismatchException iomismatch) {
					System.out.println("invalid input!");
					valid_map = false;
					// sc.next();
				}
			} while (valid_map == false);
		} while (CheckMapsize(noplayers, size) != true);

		difficulty = 0;
		boolean valid_difficulty = false;
		do {
			try {
				System.out
						.print("Enter the game difficulty: (1) for Safe or (2) for Hazardous: ");
				difficulty = sc.nextInt();
				if (difficulty < 1 || difficulty > 2){
					valid_difficulty = false;
				}
				else valid_difficulty = true;
			} catch (InputMismatchException iomismatch) {
				System.out.println("Invalid input!");
				valid_difficulty = false;
			}
		} while (valid_difficulty == false);

		boolean valid_mode = false;

		do {
			try {
				System.out
						.print("Enter (1) for playing in teams or (2) for playing individually: ");
				mode = sc.nextInt();
				if (mode < 1 || mode > 2){
					valid_mode = false;
				}
				else valid_mode = true;
			} catch (InputMismatchException iomismatch) {
				System.out.println("Invalid input!");
				valid_mode = false;
			}
		} while (valid_mode == false);
		if (mode == 1) {
			boolean valid_teams = false;

			do {
				try {
					System.out.print("Enter number of teams: ");
					teams_amount = sc.nextInt();
					if (teams_amount > noplayers) {
						System.out
								.println("\nCannot have more teams than players!");
						valid_teams = false;
					} else {
						if (teams_amount <= 0) {
							System.out
									.println("\nPlease enter number of teams greater than 0");
							valid_teams = false;
						} else {
							valid_teams = true;
						}
					}

				} catch (InputMismatchException iomismatch) {
					System.out.println("Invalid input!");
					valid_teams = false;
				}
			} while (valid_teams == false);
		}
		else {
			
		}
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

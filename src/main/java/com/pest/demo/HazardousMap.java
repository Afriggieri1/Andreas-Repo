/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.demo;

//import static com.pest.demo.Map.instance;

/**
 * 
 * @author Alastair
 */
public class HazardousMap extends Map {
	// Tile[][] MapTemplate;
	// private int size;
	private HazardousMap(int size) {
		super(size);
		// this.size=size;
	}

	public static Map getInstance(int size) {
		if (Map.instance == null||!(Map.instance instanceof HazardousMap)) {
			instance = new HazardousMap(size);
		}
		return Map.instance;
	}

	public void generate() {
		MapArray = new Tile[size][size];

		// System.out.println("passed ");
		// assign grass
		for (int j = 0; j < size; j++) {
			for (int k = 0; k < size; k++) {

				MapArray[j][k] = new Tile();

			}
		}
		// System.out.println("passed 1 ");

		int TreasureX = (int) (Math.random() * size);
		int TreasureY = (int) (Math.random() * size);
		System.out
				.println(TreasureX + "," + TreasureY + " and size is:" + size);
		MapArray[TreasureY][TreasureX].setType('T');
		System.out.println("passed 2");
		double WaterTiles1 = (size * size) / 4;
		double WaterTiles2 = (size * size) * 0.35;

		int WaterTiles = (int) (WaterTiles1 + (Math.random() * (WaterTiles2 - WaterTiles1)));
		//int WaterTiles = WaterTiles;

		System.out.println("WaterTiles= " + WaterTiles);
		int count = 0;
		do {
			int xwater = (int) (Math.random() * size);
			int ywater = (int) (Math.random() * size);
			if (MapArray[ywater][xwater].getType() != 'T'
					&& MapArray[ywater][xwater].getType() != 'W') {
				MapArray[ywater][xwater].setType('W');
				count++;
			}
		} while (count <= WaterTiles);

		// System.out.println(TreasureX);
		// System.out.println(TreasureY);

		// for (int i = 0; i < NumOfPlayers; i++) {
		// players.get(i).setMap(new Map(MapTemplate.clone()));
		// maps.add(players.get(i).getMap());
		// }
		// Din kolla trid titlaq thawn taht
		System.out.println("passed final");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(MapArray[i][j].getType() + "  ");
			}
			System.out.println("");
		}

	}

}

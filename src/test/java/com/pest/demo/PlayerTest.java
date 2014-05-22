/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.demo;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 * @author Andreas
 */
public class PlayerTest {

	Player p;
	//Map map;
        Map map=null;
	public PlayerTest() {
	}

	@Before
	public void setUp() {
		p = new Player(1);
		
		Tile[][] MapTemplate = new Tile[5][5];
		// int TotalTiles = SizeOfMap * SizeOfMap;

		// assign grass
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {

				MapTemplate[j][k] = new Tile();

			}
		}
                 map = SafeMap.getInstance(5);
		map.MapArray=MapTemplate;
	}

	/**
	 * Test of getPlayerid method, of class Player.
	 */
	@Test
	public void testGetPlayerid() {
		System.out.println("getPlayerid");
		int expResult = 1;
		int result = p.getPlayerid();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getPosition method, of class Player.
	 */
	@Test
	public void testGetPosition() {
		System.out.println("getPosition");
		Position expResult = null;
		Position result = p.getPosition();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setPosition method, of class Player.
	 */
	@Test
	public void testSetPosition() {
		System.out.println("setPosition");
		Position currentpos = new Position(1, 1, new Tile());
		p.setPosition(currentpos);
		// Position expResult = new Position(1, 1, new Tile());
		assertEquals(currentpos, p.getPosition());
	}

	/**
	 * Test of getTrail method, of class Player.
	 */
	@Test
	public void testGetTrail() {
		System.out.println("getTrail");
		int expResult = 0;
		int result = p.getTrail().size();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setTrail method, of class Player.
	 */
	/*@Test
	public void testSetTrail() {
		System.out.println("setTrail");
		ArrayList<Position> newTrail = new ArrayList<Position>();
		Position newPos = new Position(1, 2, new Tile());
		newTrail.add(newPos);
		p.setTrail(newTrail);
		assertEquals(newTrail, p.getTrail());
	}*/

	/**
	 * Test of ResetTrail method, of class Player.
	 */
	@Test
	public void testResetTrail() {
		System.out.println("ResetTrail");
		int expResult = 0;
		p.ResetTrail();
		assertEquals(expResult, p.getTrail().size());
	}

	/**
	 * Test of move method, of class Player.
	 */
	@Test
	public void testMoveUp() {
		// Map map = new Map(5);

		System.out.println("moveup");

		Position position = new Position(2, 2, new Tile());
		p.setPosition(position);

		//char direction = 'U';
		//position.setY(0);
		p.move('U', map);
		assertEquals(1, p.getPosition().getY());
	}

	@Test
	public void TestMoveDown() {
		System.out.println("movedown");

		Position position = new Position(2, 2, new Tile());
		p.setPosition(position);

		//char direction = 'D';
		//position.setY(4);
		p.move('D', map);
		assertEquals(3, p.getPosition().getY());
	}
	
	@Test
	public void TestMoveLeft() {
		System.out.println("moveleft");

		Position position = new Position(2, 2, new Tile());
		p.setPosition(position);

		//char direction = 'L';
		//position.setX(0);
		p.move('L', map);
		assertEquals(1, p.getPosition().getX());
	}
	
	@Test
	public void TestMoveRight() {
		System.out.println("moveright");

		Position position = new Position(2, 2, new Tile());
		p.setPosition(position);

		//char direction = 'R';
		//position.setX(4);
		p.move('R', map);
		assertEquals(3, p.getPosition().getX());
	}

}

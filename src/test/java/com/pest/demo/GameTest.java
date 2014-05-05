package com.pest.demo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
	Game game;

	@Before
	public void setUp() {
		game = new Game(2, 5);

	}

	@Test
	public void testWatertype() {
		Tile t = new Tile();
		Position p = new Position(3, 3, t);
		p.getTile().setType('W');
		// Game game=new Game(0,0);
		assertEquals(true, game.isWater(p));

		p.getTile().setType('G');
		assertEquals(false, game.isWater(p));
	}

	@Test
	public void testTreasuretype() {
		Tile t = new Tile();
		Position p = new Position(3, 3, t);
		p.getTile().setType('T');
		// Game game=new Game(0,0);
		assertEquals(true, game.isTreasure(p));

		p.getTile().setType('G');
		assertEquals(false, game.isTreasure(p));
	}

	@Test
	public void testCreatePlayers() {
		int expresult = 12;
		Game newgame = new Game(2, 6);
		int result = newgame.CreatePlayers().size();
		assertEquals(expresult, result);
	}
        
        @Test
	public void testAssignWater() {
		int expresult = (16*16)/4;
		Game newgame = new Game(16, 6);
                game.CreateMap();
		int result = newgame.AssignWater();
		assertEquals(expresult, result);
	}
}


package com.pest.demo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
//import java.util.*;

public class GameTest {
	Game game;
Map map=null;
	@Before
	public void setUp() {
		game = new Game(2, 5,1,0);
                map = SafeMap.getInstance(5);
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
		Game newgame = new Game(2, 6,1,0);
		int result = newgame.CreatePlayers().size();
		assertEquals(expresult, result);
	}
	
	@Test
	public void testcheckTileForWater(){	
            //Game game=new Game(16,2,1);
           //Game g=new Game(7,2,1,0);
           Tile t=new Tile();
           t.setType('W');
           Position p=new Position(1,2,t);
           game.players.get(0).setPosition(p);
           /*SafemapCreator sm=new SafemapCreator();
           sm.createMap(5);*/
           int result=game.checkTileForWater(0);
           assertEquals(1,result);
            
        }
        
        
         
        
        
        @Test
	public void testGenerateHtmlFile(){	
            //Game game=new Game(16,2,1);
            Player p=new Player(1);
            
            File f1=game.GenerateHTMLFile(p);
            assertTrue(f1.exists());
        }
        
         @Test
	public void testtotalWinners(){	
            Game game=new Game(16,2,1,0);
            Player p1=new Player(1);
            Player p2=new Player(2);
            game.winners.add(p1);
            game.winners.add(p2);
            
            assertEquals(0,game.DisplayWinners());
        }
        
       /*   @Test
	public void testcheckTileForWater(){
            Scanner k=new Scanner(System.in);
            Game game1=new Game(16,1);
            Player p1=new Player(1);
            Player p2=new Player(2);
            Tile t=new Tile();
            Position pos1=new Position(3,3,t);
            Position pos2=new Position(3,4,t);
            
           // p1.setTrail(positions);
            game1.players.get(0).setPosition(pos1);
            game1.players.get(0).setPosition(pos2);
            System.out.println(game1.players.get(0).getTrail().size());
            int x=game.checkTileForWater(2);
            System.out.println("output"+game1.players.size());
            k.next();
            
            assertEquals(0,game1.checkTileForWater(0));
        }*/
}



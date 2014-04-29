package com.pest.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class GameTest{
    Game game;
     
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUp(){
        game=new Game(2,5);
         
        
    }
    
    @Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
       
        //Position p=new Position(3,3,t);
        
        @Test
        public void testWatertype(){
            Tile t=new Tile();
            Position p=new Position(3,3,t);
            p.getTile().setType('W');
            //Game game=new Game(0,0);
            assertEquals(true,game.isWater(p));
        }
        
}
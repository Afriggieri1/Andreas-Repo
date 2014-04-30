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

    public PlayerTest() {
    }

    @Before
    public void setUp() {
        p = new Player(1);
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
        //Position expResult = new Position(1, 1, new Tile());
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
    @Test
    public void testSetTrail() {
        System.out.println("setTrail");
        ArrayList<Position> newTrail = new ArrayList();
        Position newPos = new Position(1,2,new Tile());
        newTrail.add(newPos);
        p.setTrail(newTrail);
        assertEquals(newTrail,p.getTrail());
    }

    /**
     * Test of ResetTrail method, of class Player.
     */
    @Test
    public void testResetTrail() {
        System.out.println("ResetTrail");
        int expResult = 0;
        p.ResetTrail();
        assertEquals(expResult,p.getTrail().size());
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        Map map= new Map(5);
        
        System.out.println("move");
        Position position = new Position(2,2,new Tile());
        p.setPosition(position);
        char direction = 'U';
        position.setY(1);
        p.move(direction, map);
        assertEquals(position,p.getPosition());
        
        //p.setPosition(new Position(2,2,new Tile()));
        direction = 'D';
        position.setY(2);
        p.move(direction, map);
        assertEquals(position,p.getPosition());
        
        direction = 'L';
        position.setX(1);
        p.move(direction, map);
        assertEquals(position,p.getPosition());
        
        direction = 'R';
        p.move(direction, map);
        position.setX(2);
        assertEquals(position,p.getPosition());
    }

}
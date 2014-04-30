/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.demo;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alastair
 */
public class PositionTest {
    
    

    /**
     * Test of setX method, of class Position.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int xcoord=4;
        Position instance = new Position(3,3,new Tile());
        instance.setX(xcoord);
       assertEquals(xcoord,instance.getX());
    }

    /**
     * Test of setY method, of class Position.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int ycoord = 4;
        Position instance = new Position(3,3,new Tile());
        instance.setY(ycoord);
        assertEquals(ycoord,instance.getY());
    }

    /**
     * Test of setTile method, of class Position.
     */
    @Test
    public void testSetTile() {
        System.out.println("setTile");
        Tile TileToOccupy = new Tile();
        Position instance =new Position(3,3,new Tile());
        instance.setTile(TileToOccupy);
        assertEquals(TileToOccupy,instance.getTile());
    }

    /**
     * Test of getX method, of class Position.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Position instance = new Position(3,3,new Tile());
        int expResult = 3;
        int result = instance.getX();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getY method, of class Position.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Position instance = new Position(3,3,new Tile());
        int expResult = 3;
        int result = instance.getY();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getTile method, of class Position.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        Tile t=new Tile();
        Position instance = new Position(3,3,t);;
        Tile expResult = t;
        Tile result = instance.getTile();
        assertEquals(expResult, result);
        
    }
    
}

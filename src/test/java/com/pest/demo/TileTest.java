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
 * @author Andreas
 */
public class TileTest {

    /**
     * Test of setVisibility method, of class Tile.
     */
    @Test
    public void testSetVisibility() {
        System.out.println("setVisibility");
        boolean ChangeVisibility = true;

        Tile newTile = new Tile();
        newTile.setVisibility(ChangeVisibility);
        assertEquals(true, newTile.getVisibility());
    }

    /**
     * Test of getVisibility method, of class Tile.
     */
    @Test
    public void testGetVisibility() {
        System.out.println("getVisibility");
        Tile newTile = new Tile();
        boolean expResult = false;
        boolean result = newTile.getVisibility();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Tile.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Tile newTile = new Tile();
        char expResult = 'G';
        char result = newTile.getType();
        assertEquals(expResult, result);

        Tile newTileWithType = new Tile('W');
        expResult = 'W';
        result = newTileWithType.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Tile.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        char type = 'T';
        Tile instance = new Tile();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

}

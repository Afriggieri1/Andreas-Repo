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
public class MapTest {
    
    

    /**
     * Test of setMapSize method, of class Map.
     */
    @Test
    public void testSetMapSize() {
        System.out.println("setMapSize");
        int size = 0;
        Map instance =new Map(5);
        instance.setMapSize(6);
        assertEquals(6,instance.getSize());
    }

    /**
     * Test of getSize method, of class Map.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Map instance = new Map(5);
        int expResult = 5;
        int result = instance.getSize();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getTile method, of class Map.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        int x = 1;
        int y = 1;
        Tile newtile=new Tile();
        Tile[][] store=new Tile[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                store[i][j]=newtile;
            }
        }
        Map instance = new Map(store);
        Tile expResult = newtile;
        Tile result = instance.getTile(x, y);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAllTiles method, of class Map.
     */
    @Test
    public void testGetAllTiles() {
        System.out.println("getAllTiles");
        Tile newtile=new Tile();
        Tile[][] store=new Tile[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                store[i][j]=newtile;
            }
        }
        Map instance = new Map(store);
        Tile[][] expResult = store;
        Tile[][] result = instance.getAllTiles();
        assertArrayEquals(expResult, result);
        
    }

    
}

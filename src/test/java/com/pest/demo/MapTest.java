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
    
    Map map=null;
    public void before(){
        System.out.println(" dahal1");
      map = SafeMap.getInstance(5);
}

    /**
     * Test of setMapSize method, of class Map.
     */
    @Test
    public void testSetMapSize() {
        System.out.println("setMapSize");
        //int size = 0;
       map.setMapSize(6);
       int x=map.size;
        assertEquals(6,x);
    }

    /**
     * Test of getSize method, of class Map.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        map.setMapSize(5);
        int expResult = 5;
        int result = map.getSize();
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
        map.MapArray=store;
        Tile expResult = newtile;
        Tile result = map.getTile(x, y);
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
        map.MapArray=store;
        Tile[][] expResult = store;
        Tile[][] result = map.getAllTiles();
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testStartPosition() {
    	System.out.println("testStartPosition");
    	
    	Tile[][] MapTemplate = new Tile[5][5];

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				MapTemplate[j][k] = new Tile('W');
			}
		}

		map.MapArray=MapTemplate;
		
		MapTemplate[2][2].setType('G');
		
		Position startPos = map.startPosition();
		
		assertEquals(2,startPos.getX());
		assertEquals(2,startPos.getY());
		
    	
    }
    
}

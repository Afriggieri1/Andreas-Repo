/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.demo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alastair
 */
public class TeamTest {
    
    public TeamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of AttachPlayer method, of class Team.
     */
    @Test
    public void testAttachPlayer() {
        System.out.println("AttachPlayer");
        Player p = new Player(1);
        Team instance = new Team();
        instance.AttachPlayer(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        Player p1=instance.getPlayers().get(0);
        assertEquals(1,p1.getPlayerid());
    }

    /**
     * Test of DetachPlayer method, of class Team.
     */
    @Test
    public void testDetachPlayer() {
        System.out.println("DetachPlayer");
        Player p = new Player(1);
        Player p1 = new Player(2);
        Team instance = new Team();
        instance.AttachPlayer(p);
        instance.AttachPlayer(p);
        instance.DetachPlayer(p);
        int result=instance.getPlayers().size();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(1,result);
    }

    /**
     * Test of NotifyPlayers method, of class Team.
     */
    @Test
    public void testNotifyPlayers() {
        System.out.println("NotifyPlayers");
         Player p = new Player(1);
        Team instance = new Team();
        instance.AttachPlayer(p);
        ArrayList<Position> t=new ArrayList<Position>();
        Tile tile=new Tile();
        Position pos=new Position(1,2,tile);
        t.add(pos);
        instance.setTrail(t);
        instance.NotifyPlayers();
        int result=p.getTrail().get(0).getX();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1,result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class Team.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Player p = new Player(1);
        Team instance = new Team();
        instance.AttachPlayer(p);
        int result=instance.getPlayers().get(0).getPlayerid();
        assertEquals(1, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTrail method, of class Team.
     */
    @Test
    public void testGetTrail() {
        System.out.println("getTrail");
        Team instance = new Team();
        ArrayList<Position> t=new ArrayList<Position>();
        Tile tile=new Tile();
        Position pos=new Position(1,2,tile);
        t.add(pos);
        instance.setTrail(t);
        int result = instance.getTrail().get(0).getY();
        assertEquals(2, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ClearPlayers method, of class Team.
     */
    @Test
    public void testClearPlayers() {
        System.out.println("ClearPlayers");
        Player p = new Player(1);
        Team instance = new Team();
        instance.AttachPlayer(p);
        instance.ClearPlayers();
        int result=instance.getPlayers().size();
        assertEquals(0,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTrail method, of class Team.
     */
    /*/@Test
    public void testSetTrail() {
        System.out.println("setTrail");
        ArrayList<Position> newTrail = null;
        Team instance = new Team();
        instance.setTrail(newTrail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of AddPosition method, of class Team.
     */
    @Test
    public void testAddPosition() {
        System.out.println("AddPosition");
        Tile t=new Tile();
        Position p = new Position(1,3,t);
        Team instance = new Team();
        instance.AddPosition(p);
        int result=instance.getTrail().get(0).getX();
        assertEquals(1,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SelectPlayer method, of class Team.
     */
    @Test
    public void testSelectPlayer() {
        System.out.println("SelectPlayer");
        Player p = new Player(1);
        Team instance = new Team();
        instance.AttachPlayer(p);
        int result = instance.SelectPlayer().getPlayerid();
        assertEquals(1, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.demo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
//import com.pest.demo.Launcher.InputMapsize;
//import com.pest.demo.Launcher.InputPlayers;

/**
 *
 * @author Alastair
 */
public class LauncherTest {
    
    static Launcher launcher;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUp(){
        launcher=new Launcher();
    }
    
    @Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
    
    
    @Test
    public void testiputplayers(){
        assertEquals(true,launcher.CheckPlayers(4));
        assertEquals(false,launcher.CheckPlayers(9));
        assertEquals(false,launcher.CheckPlayers(-1));
    }
    @Test
    public void testmapsize(){
        assertEquals(true,launcher.CheckMapsize(2,5));
        assertEquals(false,launcher.CheckMapsize(2,4));
        assertEquals(false,launcher.CheckMapsize(8,5));
        assertEquals(true,launcher.CheckMapsize(8,9));
        assertEquals(false,launcher.CheckMapsize(8,0));
        assertEquals(false,launcher.CheckMapsize(8,51));
    }
    
}

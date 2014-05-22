/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
/**
 *
 * @author Alastair
 */
public class MapCreatorTest {
          Map m=null;
          Map m1=null;
          
          MapCreator creator;
          MapCreator creator1;
          @Test
          
	/*public void creatorTestWithHazardousmap() {
            //Map.instance=null;
		creator1 = new MapCreator();
		m1 = creator1.createMap(2, 9);
                int expresult=Map.size;
		
		assertEquals(expresult, m1.size);
		// assertEquals(true, g.generate());
	}*/
          @Before
	public void setup() {
		creator = new MapCreator();
		m = creator.createMap(2, 5);
		
		//m.size = 5;
                assertEquals(Map.size, m.size);
		//assertEquals(true, g.setMapSize(5));
		// assertEquals(true, g.generate());
	}
        
        @Test
	public void generate() {
		m.size = 5;
		m = creator.createMap(2,5);
		// assertEquals(true, m.generate());
	}
        /*@Test
	public void creatorTestWithSafemap() {
		creator = new MapCreator();
		m = creator.createMap(1, 9);
                int expresult=Map.size;
		//Map.instance=null;
		assertEquals(expresult, m.size);
		// assertEquals(true, g.generate());
	}*/
        
	/*Game game = null;
	Map map = null;

	@Before
	public void before() throws NoSuchFieldException, IllegalAccessException { 
		//game = new Game(2,2,1);
		

		Field field = Map.class.getDeclaredField("map");
		field.setAccessible(true);
		field.set(map, null);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void createMapTest() {

		MapCreator creator = new MapCreator();
		map = creator.createMap(1, 5);

		Class mapClass = map.getClass();
		String className = mapClass.getSimpleName();

		assertEquals(className, "SafeMap");

		map = creator.createMap(1, 5);

		mapClass = map.getClass();
		className = mapClass.getSimpleName();

		// check that 2nd instance of Map, wasn't created
		//assertEquals(className, "SafeMap");

		map = creator.createMap(1, 5);

		// check that 2nd instance of Map, wasn't created
		//assertNull(map);

	}*/	
}

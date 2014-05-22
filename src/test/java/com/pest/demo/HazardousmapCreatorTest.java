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

/**
 *
 * @author Alastair
 */
public class HazardousmapCreatorTest {
    
        
         Map m1=null;
          
          
          MapCreator creator1;
         HazardousmapCreator hmap;
         
        @Test
	public void creatorTestWithHazardousmap() {
             //Map.instance=null;
		hmap = new HazardousmapCreator();
		m1 = hmap.createMap(2, 9);
                int expresult=Map.size;
		Map.startPosition();
		assertEquals(expresult, m1.size);
		// assertEquals(true, g.generate());
	}
    
}

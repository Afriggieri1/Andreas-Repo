/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */
public class TestTest {
    
    public TestTest() {
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
     * Test of Fibonacci method, of class Test.
     */
    @Test
    public void testFibonacci() {
        System.out.println("Fibonacci");
        int num = 5;
        int expResult = 8;
        int result = testproject.Test.Fibonacci(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Fact method, of class Test.
     */
    @Test
    public void testFact() {
        System.out.println("Fact");
        int num = 2;
        int expResult = 2;
        int result = testproject.Test.Fact(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Test.
     */
   /* @Test
    public void testMultiply() {
        System.out.println("multiply");
        int a = 2;
        int b = 3;
        int expResult = 6;
        int result = testproject.Test.multiply(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of OutputText method, of class Test.
     */
   /* @Test
    public void testOutputText() {
        System.out.println("OutputText");
        String expResult = "Testing";
        String result = testproject.Test.OutputText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/
    
}

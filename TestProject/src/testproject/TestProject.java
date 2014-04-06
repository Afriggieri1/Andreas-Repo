/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testproject;
import static org.junit.Assert.*;
/**
 *
 * @author Andreas
 */
public class TestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World Test");
        
        AddTest();
    }
    
    public static void AddTest(){
        assertEquals(Test.Fibonacci(5),8);
    }
    
}

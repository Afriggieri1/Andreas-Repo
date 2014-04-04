/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unittesting;

import static org.junit.Assert.*;
/**
 *
 * @author Andreas
 */
public class UnitTesting {
    
    public static void addTest(){
        Calculator calc = new Calculator();
        //assertEquals(calc.divide(4, 0),1);
        assertEquals(calc.getMessage(1),"Hello World!! ");
    }
    
    public static void main(String[] args) {
        /*Calculator calc = new Calculator();
        System.out.println(calc.add(1,0));
        System.out.println(calc.subtract(3, 2));
        System.out.println(calc.multiply(2, 2));
        System.out.println(calc.divide(2, 2));*/
        addTest();
        
    }
    
}

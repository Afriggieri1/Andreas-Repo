/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testproject;

/**
 *
 * @author Andreas
 */
public class Test {
    public static int Fibonacci(int num){
        if ((num==0)||(num==1)){
            return 1;
        }
        else return Fibonacci(num-1)+Fibonacci(num-2);
    }
}

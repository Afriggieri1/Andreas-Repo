/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.demo;

/**
 *
 * @author Alastair
 */
public class SafemapCreator extends MapCreator {
    public Map createMap(int size){
        Map map=SafeMap.getInstance(size);
        return map;
    }
}

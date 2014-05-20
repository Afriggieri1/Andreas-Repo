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
public class HazardousmapCreator extends MapCreator {
	public Map createMap(int size) {
		Map map = HazardousMap.getInstance(size);
		return map;
	}
}

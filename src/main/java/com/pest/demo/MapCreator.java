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
public class MapCreator {
	public Map createMap(int difficulty, int size) {
		// Determine which creator to use
		MapCreator creator = findCreatorForType(difficulty);

		if (creator != null)
			return creator.createMap(size);
		else
			return null;
	}

	public Map createMap(int size) {
		return null; // create safe map
	}

	public MapCreator findCreatorForType(int difficulty) {
		if (difficulty == 1)
			return new SafemapCreator();
		else if (difficulty == 2)
			return new HazardousmapCreator();
		else
			return null;
	}
}

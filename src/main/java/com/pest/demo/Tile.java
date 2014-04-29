/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.demo;

/**
 *
 * @author Andreas
 */
public class Tile {

    boolean Visible;//this variable indicates whether a particular tile has been passed from or not
    char TileType;//this variable indicates the type of the tile that ie either grass,water or treasure

    public Tile() {//parameterless constructor for class Tile
        this.Visible = false;
        this.TileType = 'G';
    }

    public Tile(char type) {// constructor with parameters for this class
        this.Visible = false;
        this.TileType = type;
    }

    /*
     *   this method sets the visibility of the tile
     *   @param background
     */
    public void setVisibility(boolean ChangeVisibility) {
        this.Visible = ChangeVisibility;
    }

    /*
     *   this method returns the visibility of the tile
     *   @return boolean
     */
    public boolean getVisibility() {
        return Visible;
    }
    /*
     *   this method returns the type of the tile
     *   @return type
     */

    public char getType() {
        return TileType;
    }

    public void setType(char type) {
        this.TileType = type;
    }
}

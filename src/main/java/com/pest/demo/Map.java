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
public abstract class Map {
    //updates done for part 3
    protected static Map instance=null;
    
   static int size;
    protected static Tile[][] MapArray;

    public Map(int size) {
        this.size = size;
        generate();
        //this.MapArray = null;//create the array
    }

    public Map(Tile[][] array) {
        this.size = array[0].length;
        this.MapArray = array;
    }

    public static void setMapSize(int s) {
        size = s;
    }

    public static  int getSize() {
        return size;
    }

    public static Tile getTile(int x, int y) {
        return MapArray[x][y];
    }

    public static Tile[][] getAllTiles() {
        return MapArray;
    }

    public static Position startPosition() {
        int x;
        int y;
        System.out.println("finding start");

        boolean start = false;
        do {
            x = (int) (Math.random() * size);
            y = (int) (Math.random() * size);

            if ((MapArray[y][x].getType() == 'G') && (MapArray[y][x].getVisibility() == false)) {

                start = true;

                System.out.println(x);
                System.out.println(y);
                //System.out.println(Playermap.getTile(x, y).getVisibility());
            }
        } while (start == false);
        return new Position(x, y, MapArray[y][x]);
    }
    public abstract void generate();

}

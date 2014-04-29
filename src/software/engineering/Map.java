/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.engineering;

/**
 *
 * @author Andreas
 */
public class Map {

    int MapSize;
    Tile[][] MapArray;

    public Map(int size) {
        this.MapSize = size;
        this.MapArray = null;//create the array
    }

    public Map(Tile[][] array) {
        this.MapSize = array[0].length;
        this.MapArray = array;
    }

    public void setMapSize(int size) {
        this.MapSize = size;
    }

    public int getSize() {
        return MapSize;
    }

    public Tile getTile(int x, int y) {
        return MapArray[x][y];
    }

    public Tile[][] getAllTiles() {
        return MapArray;
    }

    public Position startPosition() {
        int x;
        int y;
        System.out.println("finding start");

        boolean start = false;
        do {
            x = (int) (Math.random() * MapSize);
            y = (int) (Math.random() * MapSize);

            if ((MapArray[y][x].getType() == 'G') && (MapArray[y][x].getVisibility() == false)) {

                start = true;

                System.out.println(x);
                System.out.println(y);
                //System.out.println(Playermap.getTile(x, y).getVisibility());
            }
        } while (start == false);
        return new Position(x, y, MapArray[y][x]);
    }

}

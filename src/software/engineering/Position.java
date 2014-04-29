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
public class Position {

    int x;
    int y;
    Tile AssignedTile;

    public Position(int xcoord, int ycoord, Tile TileToOccupy) {
        this.x = xcoord;
        this.y = ycoord;
        this.AssignedTile = TileToOccupy;
    }

    public void setX(int xcoord) {
        this.x = xcoord;
    }

    public void setY(int ycoord) {
        this.y = ycoord;
    }

    public void setTile(Tile TileToOccupy) {
        this.AssignedTile = TileToOccupy;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Tile getTile() {
        return this.AssignedTile;
    }
}

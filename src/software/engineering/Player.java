/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.engineering;

import java.util.ArrayList;

/**
 *
 * @author Andreas
 */
public class Player {

    public final int PlayerID;//varaiable to hold the player id
    public Position CurrentPosition;// new instance of object position
    //public Map PlayerMap;// variable to store the player's map
    public ArrayList<Position> trail;

    public Player(int ID) {//constructor with parameters for this class
        this.PlayerID = ID;
        //this.PlayerMap = null;
        this.CurrentPosition = null;
        trail = new ArrayList<>();
    }

    public int getPlayerid() {
        return this.PlayerID;
    }

    /*
     *   this method set the position of a particular player
     *   @param int x,int y
     *   @return boolean
     */
    public void setPosition(Position currentpos) {
        this.CurrentPosition = currentpos;
        trail.add(currentpos);
    }

    public ArrayList<Position> getTrail() {
        return trail;
    }

    public void setTrail(ArrayList<Position> newTrail) {
        this.trail = newTrail;
    }

    public Position getPosition() {
        return this.CurrentPosition;
    }

    public void ResetTrail() {
        this.trail.clear();
    }

    public void move(char direction, Map PlayerMap) {
        int x = CurrentPosition.getX();
        int y = CurrentPosition.getY();

        try {
            switch (direction) {
                case 'U':
                case 'u':
                    setPosition(new Position(x, y - 1, PlayerMap.getTile(y - 1, x)));
                    break;

                case 'D':
                case 'd':
                    setPosition(new Position(x, y + 1, PlayerMap.getTile(y + 1, x)));
                    break;

                case 'L':
                case 'l':
                    setPosition(new Position(x - 1, y, PlayerMap.getTile(y, x - 1)));
                    break;

                case 'R':
                case 'r':
                    setPosition(new Position(x + 1, y, PlayerMap.getTile(y, x + 1)));
                    break;
            }

        } catch (Exception e) {
            System.out.println("You cannot move there!");
        }
    }
}

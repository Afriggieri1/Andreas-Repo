package com.pest.demo;

import java.util.ArrayList;

//added for part 3 task 3
public class Team implements SubjectInterface {
	private ArrayList<Player> players;
	public ArrayList<Position> trail;
	int NextPlayerToPlay;

	public Team() {
		this.players = new ArrayList<Player>();
		this.trail = new ArrayList<Position>();
		this.NextPlayerToPlay = 0;
	}
	
	public void AttachPlayer(Player p) {
		players.add(p);
	}

	public void DetachPlayer(Player p) {
		players.remove(p);
	}

	public void NotifyPlayers() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).Update(trail);
		}
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void setPosition(Position currentpos) {
		// this.CurrentPosition = currentpos;
		trail.add(currentpos);
	}
	
	public void ClearPlayers(){
		this.players.clear();
	}
	
	public void setTrail(ArrayList<Position> newTrail) {
        this.trail = newTrail;
    }
	
	public Player SelectPlayer(){
		if (NextPlayerToPlay > players.size()-1)
			NextPlayerToPlay = 0;
		Player p = players.get(NextPlayerToPlay);
		this.NextPlayerToPlay++;
		return p;
	}
}

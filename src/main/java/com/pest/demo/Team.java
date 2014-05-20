package com.pest.demo;

import java.util.ArrayList;

//added for part 3 task 3
public class Team implements SubjectInterface{
	private ArrayList<Player> players;
	
	public Team(){
		this.players = new ArrayList<Player>();
	}
	
	public void AttachPlayer(Player p){
		players.add(p);
	}
	
	public void DetachPlayer(Player p){
		players.remove(p);
	}
	
	public void NotifyPlayers(){
		for (int i = 0;i<players.size();i++){
			players.get(i).Update();
		}
	}
}

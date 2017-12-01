package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private boolean started;
	private List<Player> spelers;
	
	public Game(){
		spelers = new ArrayList<>();
		this.setStarted(false);
	}
	
	public void addSpeler(Player speler){
		if(spelers.contains(speler)){
			throw new IllegalArgumentException("Player already exists");
		}
		spelers.add(speler);
	}
	
	public List<Player> getSpelers(){
		return spelers;
	}
	
	public void startGame(){
		this.setStarted(true);
	}
	
	public boolean isStarted(){
		return this.started;
	}
	
	public void setStarted(boolean started){
		this.started = started;
	}
}

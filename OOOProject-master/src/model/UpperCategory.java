package model;

import java.util.ArrayList;

public class UpperCategory implements CategoryInterface{
	private int welke;
	
	public UpperCategory(int welke){
		this.welke = welke;
	}
	
	
	@Override
	public int calculateScore(DiceRoll diceRoll) {
		int score = 0;
		ArrayList<Dice> dices =diceRoll.getAllDices();
		for(Dice dice:dices){
			if(dice.getEyes()==welke){
				score+=welke;
			}
		}
		return score;
		
	}
	
	
}

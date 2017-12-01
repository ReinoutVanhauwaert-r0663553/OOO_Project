package model;

import java.util.ArrayList;

public class FullHouse implements CategoryInterface {

	@Override
	public int calculateScore(DiceRoll diceRoll) {
		int score = 0;
		int big = 0;
		int small = 0;
		
		ArrayList<Dice> dices = diceRoll.getAllDices();
		
		for(Dice dice: dices){
			
		}
		
		
		return score;
		
	}

	
}

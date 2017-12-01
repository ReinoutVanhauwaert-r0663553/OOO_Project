package model;

import java.util.ArrayList;

public class LowerKindCategory implements CategoryInterface {

	private int welke;

	public LowerKindCategory(int welke) {
		setWelke(welke);
	}

	@Override
	public int calculateScore(DiceRoll diceRoll) {
		int score = 0;
		ArrayList<Dice> dices = diceRoll.getAllDices();
		//int aantalSame = 0;
		
		for(Dice d: dices){
			int aantalSame = 0;
			int diceEyes = d.getEyes();
			for(Dice d2:dices){
				if(diceEyes == d2.getEyes()){
					aantalSame++;
					dices.remove(d2);
				}
			}
			if(aantalSame == welke){
				score += this.getTotalEyes(diceRoll);
			}
			
		}
		
		
		
		return score;

	}
	
	
	public int getTotalEyes(DiceRoll diceRoll){
		int total = 0;
		ArrayList<Dice> dices = diceRoll.getAllDices();

		for(Dice dice: dices){
			total+= dice.getEyes();
		}
		return total;
	}

	public void setWelke(int welke) {
		if (welke == 3 || welke == 4) {
			this.welke = welke;
		}else{
			throw new IllegalArgumentException("Je kunt alleen maar 3 of a kind hebben en 4 of a kind");
		}
//		this.eyevalue = welke;
	}
}
 
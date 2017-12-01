package model;

public class GameField {

	private DiceRoll diceroll = new DiceRoll();
	
	public GameField(){
		
	}
	
	public DiceRoll getDiceRoll(){
		return this.diceroll;
	}
}

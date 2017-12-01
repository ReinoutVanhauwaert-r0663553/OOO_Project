package model;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
	private List<Dice> diceNotToRoll = new ArrayList<>();
	private List<Dice> diceToRoll = new ArrayList<>();
	
	public DiceRoll () {
		for (int i = 0; i < 5; i++)
			diceToRoll.add(new Dice());
	}
	
	public List<Dice> getDiceToRoll() {
		return this.diceToRoll;
	}
	
	public List<Dice> getDiceNotToRoll() {
		return this.diceNotToRoll;
	}
	
	public void moveToDiceToRoll(Dice d) {
		if (d == null)
			throw new IllegalArgumentException("Not a dice.");
		if (diceToRoll.contains(d))
			throw new IllegalArgumentException("This dice is already in set to be rolled.");
		diceNotToRoll.remove(d);
		diceToRoll.add(d);
	}
	
	public void moveToDiceNotToRoll(Dice d) {
		if (d == null)
			throw new IllegalArgumentException("Not a dice.");
		if (diceNotToRoll.contains(d))
			throw new IllegalArgumentException("This dice is already in set to be rolled.");
		diceToRoll.remove(d);
		diceNotToRoll.add(d);
	}
	
	public void rollDice() {
		if (this.diceToRoll.size() == 0)
			throw new IllegalArgumentException("No dice to roll.");
		for (int i = 0; i < this.diceToRoll.size(); i++)
			this.diceToRoll.get(i).roll();
	}
	
	public ArrayList<Dice> getAllDices(){
		ArrayList<Dice> allDices = new ArrayList<>();
		allDices.addAll(diceNotToRoll);
		allDices.addAll(diceToRoll);
		return allDices;
	}
	
	
	public String toString() {
		return "Dice to roll: " + this.diceToRoll + "\nDice not to roll: " + this.diceNotToRoll + "\n\n";
	}
}

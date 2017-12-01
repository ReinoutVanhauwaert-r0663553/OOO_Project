package model;

import java.util.Random;

public class Dice {
	private int eyes = 1;
	
	public Dice() {
//		roll();
	}
	
	public void roll() {
		Random rand = new Random();
		eyes = rand.nextInt(6) + 1;
//		return eyes;
	}

	public int getEyes() {
		return eyes;
	}

	private void setEyes(int eyes) {
		this.eyes = eyes;
	}
	
	public String toString() {
		return String.valueOf(eyes);
	}
}

package model;

public class Player {
	private String name;
	private GameField gameField = new GameField();
	
	public Player(String name){
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.trim().isEmpty()){
			throw new IllegalArgumentException("Geef een spelersnaam.");
		}
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Player) 
			if (((Player) o).getName().equals(this.getName()))
				return true;
		return false;
	}
	
	public String toString() {
		return "Naam: " + this.name;
	}

	public GameField getGameField() {
		return gameField;
	}

	private void setGameField(GameField gameField) {
		this.gameField = gameField;
	}
}

package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DiceRoll;
import model.Game;
import model.GameField;
import model.Player;
import view.GameScreen;

public class PlayerController implements Controller, EventHandler {
	private Player player;
	private GameScreen gameScreen;
	private Game game;

	public PlayerController(String namePlayer, Game game) {
		player = new Player(namePlayer);
		gameScreen = new GameScreen(this);
		this.game = game;
		game.addSpeler(player);
		startView();
	}

	public Player getPlayer() {
		return this.player;
	}
	
	public GameField getGameField() {
		return this.getPlayer().getGameField();
	}
	
	public DiceRoll getDiceRoll() {
		return this.getGameField().getDiceRoll();
	}

	@Override
	public void startView() {
		GameScreen g = new GameScreen(this);
		Stage s = new Stage();
		Scene c = new Scene(g, 800, 400);
		s.setScene(c);
		s.show();
	}

	@Override
	public void handle(Event e) {
		System.out.println(e.getSource());
		if (e.getClass().equals(ActionEvent.class)) {
	        this.getGameField().getDiceRoll().rollDice();
	        gameScreen.updateDiceLabels();
	    } else if (e.getClass().equals(MouseEvent.class)) {
	    	if (gameScreen.getLabelsToRoll().contains(e.getSource()))
	    		this.getDiceRoll().moveToDiceNotToRoll(this.getDiceRoll().getDiceToRoll().get(gameScreen.getLabelsToRoll().indexOf(e.getSource())));
	    		gameScreen.getLabelsNotToRoll().add(gameScreen.getLabelsToRoll().remove(gameScreen.getLabelsToRoll().indexOf(e.getSource())));
			
			gameScreen.updateDiceLabels();
	    }
	}
}

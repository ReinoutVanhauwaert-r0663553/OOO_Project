package view;

import java.util.ArrayList;

import controller.Controller;
import controller.MenuController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MenuScreen extends GridPane {
	private MenuController menuController = new MenuController(this);
	private ArrayList<Label> players = new ArrayList<>();
	private Button addPlayer;
	private Button startGame;
	
	public MenuScreen() {
		addPlayer = new Button("Add player");
		startGame = new Button("Start game");
		addPlayer.setOnAction(menuController);
		startGame.setOnAction(menuController);
		add(addPlayer, 0, 0);
		add(startGame, 0, 1);
	}
	
	public Button getAddPlayer() {
		return addPlayer;
	}
	
	public Button getStartGame() {
		return startGame;
	}
	
	public ArrayList<Label> getPlayers() {
		return this.players;
	}
	
	public void updateScreen() {
		add(players.get(players.size() - 1), 0, players.size() + 1);
	}
	
}

package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Game;
import view.MenuScreen;

public class MenuController implements Controller, EventHandler<ActionEvent>{
	
	private MenuScreen menuScreen;
	private ArrayList<PlayerController> players = new ArrayList<>();
	Game game = new Game();
	
	public MenuController(MenuScreen mscreen) {
		this.menuScreen = mscreen;
	}
	
	@Override
	public void startView() {
		
	}
	
	public void createPlayerController(String namePlayer) {
		PlayerController playerController = new PlayerController(namePlayer, game);
		players.add(playerController);
		menuScreen.getPlayers().add(new Label(playerController.getPlayer().getName()));
	}
	
	public Game getGame() {
		return this.game;
	}

	@Override
	public void handle(ActionEvent event) {
		if (((Button) event.getSource()) == menuScreen.getAddPlayer()) {
			if (!this.game.isStarted()) {
				boolean userAdded = false;
	    		while (!userAdded) {
	    			String str = JOptionPane.showInputDialog("Enter name.");
	    			if (str == null) 
	    				// str = null if user clicks cancel
	    				return;
	    			try {
	    				createPlayerController(str);
	    				userAdded = true;
	    			} catch (Exception ex) {
	    				System.out.println(ex.getMessage());
	    			}
	    		}
	    		menuScreen.updateScreen();
	    	} else
	    		System.out.println("Game has already started.");
		}
		else if (((Button) event.getSource()) == menuScreen.getStartGame()) {
			game.startGame();
			menuScreen.getAddPlayer().setDisable(true);
		}
	}
	
	
	

}

package view;

import java.util.ArrayList;

import controller.PlayerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.DiceRoll;

public class GameScreen extends GridPane {
	private PlayerController playerController;
	private Label player;
	private Button rollDice;
	private ArrayList<Label> lblDiceToRoll = new ArrayList<>();
	private ArrayList<Label> lblDiceNotToRoll = new ArrayList<>();
	
	public GameScreen(PlayerController controller) {
		this.playerController = controller;
		this.player = new Label(this.playerController.getPlayer().getName() + " playing");
		this.player.setPrefWidth(800);
		this.player.setAlignment(Pos.CENTER);
		this.player.setPadding(new Insets(10, 0, 10, 0));
		this.rollDice = new Button("Roll dice");
		this.rollDice.setPrefWidth(800);
		this.rollDice.setAlignment(Pos.CENTER);
		this.rollDice.setPadding(new Insets(10, 0, 10, 0));
		this.rollDice.setOnAction((EventHandler<ActionEvent>) playerController);

		add(player, 0, 0, 5, 1);
		add(rollDice, 0, 1, 5, 1);
		
		for (int i = 0; i < 5 ; i++) {
			lblDiceToRoll.add(new Label(""));
			lblDiceToRoll.get(i).setAlignment(Pos.CENTER);
			lblDiceToRoll.get(i).setPrefWidth(160);
			lblDiceToRoll.get(i).setPadding(new Insets(20, 0, 20, 0));
			lblDiceToRoll.get(i).setOnMouseClicked((EventHandler<MouseEvent>) playerController);
			
			add(lblDiceToRoll.get(i), i, 2);
		}
		
		playerController.getPlayer().getGameField().getDiceRoll().rollDice();
		updateDiceLabels();
	}
	
	public ArrayList<Label> getLabelsToRoll() {
		return this.lblDiceToRoll;
	}
	
	public ArrayList<Label> getLabelsNotToRoll() {
		return this.lblDiceNotToRoll;
	}
	
	public void updateDiceLabels() {
		int toRoll = playerController.getDiceRoll().getDiceToRoll().size();
		for (int i = 0; i < toRoll; i++) {
			lblDiceToRoll.get(i).setText(this.playerController.getPlayer().getGameField().getDiceRoll().getDiceToRoll().get(i).toString());
			setRowIndex(lblDiceToRoll.get(i),2);
		}
		for (int i = 0; i < 5 - toRoll; i++) {
			lblDiceNotToRoll.get(i).setText(this.playerController.getPlayer().getGameField().getDiceRoll().getDiceNotToRoll().get(i).toString());
			setRowIndex(lblDiceNotToRoll.get(i),3);
		}
	}
	
	
}

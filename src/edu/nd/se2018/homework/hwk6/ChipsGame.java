package edu.nd.se2018.homework.hwk6;

import javafx.application.Application;
import java.awt.event.ActionEvent;

import edu.nd.se2018.homework.hwk6.Chip;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class ChipsGame extends Application{
	// globals
	Scene scene;
	Pane root;
	int scale = 20;
		
	// global vars
	Chip chip;
	ImageView chipImageView = new ImageView();
		
	public static void main(String [ ] args) {
		launch(args);
	}
		
	public void exitApplication(ActionEvent event) {
		Platform.exit();
	}

	@Override
	public void start(Stage chipsStage) throws Exception {
		// TODO Auto-generated method stub
		// ChipsGrid 
		root = new AnchorPane();
		ChipsMap chipsMap = new ChipsMap();
		
		// Chips Map
		scene = new Scene(root, 500, 500);
		chipsStage.setTitle("Chip's Challenge");
		chipsStage.setScene(scene);
		chipsMap = ChipsMap.getInstance();
		chipsMap.drawMap(root.getChildren(), scale);
			
		
		// Ship
		chip = new Chip(chipsMap);
		Image chipImage = new Image(getClass().getResource("/images/chipRight.png").toExternalForm(),20,20,true,true);
		chipImageView.setImage(chipImage);
	    chipImageView.setX(chip.getShipLocation().x * scale);
	    chipImageView.setY(chip.getShipLocation().y * scale);
	    root.getChildren().add(chipImageView);
		
		// Show
		chipsStage.show();
			
		this.startSailing();
	}
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) { 
				switch(ke.getCode()) {
					case RIGHT:
						chip.goEast();
						break;
					case LEFT:
						chip.goWest();
//						Image chipImageL = new Image(getClass().getResource("/images/chipLeft.png").toExternalForm(),20,20,true,true);
//						chipImageView.setImage(chipImageL);
//						root.getChildren().add(chipImageView);
						break;
					case UP:
						chip.goNorth();
						break;
					case DOWN:
						chip.goSouth();
						break;
					default:
						break;
				} 
				
				// Update image location (view)
				chipImageView.setX(chip.getShipLocation().x*scale);
				chipImageView.setY(chip.getShipLocation().y*scale);
			}
		});
	}
}

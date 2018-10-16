package edu.nd.se2018.homework.hwk6;

import javafx.application.Application;
import java.awt.event.ActionEvent;

import edu.nd.se2018.homework.hwk6.Player;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class PlayerGame extends Application{
	// globals
	Scene scene;
	Pane root;
	int scale = 20;
		
	// global vars
	Player player;
	ChipsMap chipsMap = new ChipsMap();
	Portal portal;
	TextBox text;
	int level = 1;
	Text title = new Text();
	ImageView playerImageView = new ImageView();
		
	public static void main(String [ ] args) {
		launch(args);
	}
		
	public void exitApplication(ActionEvent event) {
		Platform.exit();
	}

	/* multiThread problems??!?!?!?
	public boolean isOnPortal() {
		if((player.getPlayerLocation().x == portal.getPortalLocation().x) && (player.getPlayerLocation().y == portal.getPortalLocation().y))  {
			return true;
		} else {
			return false;
		}
	}
	*/
	
	@Override
	public void start(Stage chipsStage) throws Exception {
		// TODO Auto-generated method stub
		// ChipsGrid 
		root = new AnchorPane();
		
		// Chips Map
		scene = new Scene(root, 500, 500);
		chipsStage.setTitle("Chip's Challenge");
		chipsStage.setScene(scene);
		chipsMap = ChipsMap.getInstance();
		chipsMap.drawMap(root.getChildren(), scale);
			
		
		// Player
		player = new Player(chipsMap, root.getChildren());

		// Level Instantiation
		chipsMap.level1(root.getChildren());
		//portal = chipsMap.getPortal();
		text = new TextBox(chipsMap, root.getChildren());
		text.writeText();
		title.setText("Chips Challenge Level " + level);
		title.setX(25.3 * scale);
		title.setY(1 * scale);
		root.getChildren().add(title);
		
		// Show
		chipsStage.show();
			
		this.startGame(chipsStage);
	}
	
	private void startGame(Stage chipsStage) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) { 
				switch(ke.getCode()) {
					case RIGHT:
						player.goEast();
//						if(isOnPortal()) {
//							chipsMap.drawMap(root.getChildren(), scale);
//							player = new Player(chipsMap, root.getChildren());
//							chipsMap.level2(root.getChildren());
//							portal = chipsMap.getPortal();
//							level++;
//						} else if (isOnPortal() && level > 2) {
//							System.out.println("Congrats! You won!");
//							chipsStage.close();
//						}
						break;
					case LEFT:
						player.goWest();
//						if(isOnPortal()) {
//							chipsMap.drawMap(root.getChildren(), scale);
//							player = new Player(chipsMap, root.getChildren());
//							chipsMap.level2(root.getChildren());
//							portal = chipsMap.getPortal();
//							level++;
//						} else if (level > 2) {
//							System.out.println("Congrats! You won!");
//							chipsStage.close();
//						}
						break;
					case UP:
						player.goNorth();
//						if(isOnPortal()) {
//							chipsMap.drawMap(root.getChildren(), scale);
//							player = new Player(chipsMap, root.getChildren());
//							chipsMap.level2(root.getChildren());
//							portal = chipsMap.getPortal();
//							level++;
//						} else if (level > 2) {
//							System.out.println("Congrats! You won!");
//							chipsStage.close();
//						}
						break;
					case DOWN:
						player.goSouth();
//						if(isOnPortal()) {
//							chipsMap.drawMap(root.getChildren(), scale);
//							player = new Player(chipsMap, root.getChildren());
//							chipsMap.level2(root.getChildren());
//							portal = chipsMap.getPortal();
//							level++;
//						} else if (level > 2) {
//							System.out.println("Congrats! You won!");
//							chipsStage.close();
//						}
						break;
					case ESCAPE:
						chipsStage.close();
						break;
					default:
						break;
				}
				text.writeText();
				
				// Update image location (view)
				playerImageView.setX(player.getPlayerLocation().x*scale);
				playerImageView.setY(player.getPlayerLocation().y*scale);
			}
		});
	}
}

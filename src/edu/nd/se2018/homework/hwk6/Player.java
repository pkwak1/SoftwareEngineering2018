package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;

import edu.nd.se2018.homework.hwk6.ChipsMap;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends Observable {
	ChipsMap chipsMap;
	Point currentLocation;
	ImageView playerView = new ImageView();
	ObservableList<Node> root;
	int scale = 20;
	
	public Player(ChipsMap map, ObservableList<Node> root) {
        currentLocation = new Point(12, 12);
		this.chipsMap = map;
		this.root = root;
		Image initImage = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipDown.png").toExternalForm(),20,20,true,true);
		playerView.setImage(initImage);
		playerView.setX(currentLocation.x * scale);
		playerView.setY(currentLocation.y * scale);
		root.add(playerView);
		this.chipsMap.addPlayer(this);
    }
	
	public Point getPlayerLocation(){
		return currentLocation;
	}
	
	public void setPlayerLocation(int x, int y){
		currentLocation.x = x;
		currentLocation.y = y;
	}
	
	public void goEast() {
		if (currentLocation.x < 24) {
			boolean island = chipsMap.getMap(currentLocation.x+1,currentLocation.y);
			if (!island) {
				Image playerRight = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipRight.png").toExternalForm(),20,20,true,true);
				playerView.setImage(playerRight);
				currentLocation.x++;
			    playerView.setX(currentLocation.x * scale);
				playerView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if (currentLocation.x > 0) {
			boolean island = chipsMap.getMap(currentLocation.x-1,currentLocation.y);
			if (!island) {
				Image playerLeft = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipLeft.png").toExternalForm(),20,20,true,true);
				playerView.setImage(playerLeft);
				currentLocation.x--;
				playerView.setX(currentLocation.x * scale);
				playerView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goSouth() {
		if (currentLocation.y < 24) {
			boolean island = chipsMap.getMap(currentLocation.x,currentLocation.y+1);
			if (!island) {
				Image playerDown = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipDown.png").toExternalForm(),20,20,true,true);
				playerView.setImage(playerDown);
				currentLocation.y++;
			    playerView.setX(currentLocation.x * scale);
				playerView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
		
	}

	public void goNorth() {
		if (currentLocation.y > 0) {
			boolean island = chipsMap.getMap(currentLocation.x,currentLocation.y-1);
			if (!island) {
				Image playerUp = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipUp.png").toExternalForm(),20,20,true,true);
				playerView.setImage(playerUp);
				currentLocation.y--;
				playerView.setX(currentLocation.x * scale);
				playerView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
		
	}
}

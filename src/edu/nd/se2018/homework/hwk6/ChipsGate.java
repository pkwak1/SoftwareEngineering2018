package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipsGate extends Observable implements Observer {
	Point gateLocation = new Point(0,0);
	ChipsMap chipsMap;
	Image gateImage;
	ImageView gateView = new ImageView();
	boolean unlocked;
	Point playerLocation;
	int scale = 20;
	ObservableList<Node> root;
	
	public ChipsGate(ChipsMap chipsMap, ObservableList<Node> root) {
		this.chipsMap = chipsMap;
		this.root = root;
		unlocked = false;
		gateImage = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipGate.png").toExternalForm(),20,20,true,true);
	}
	
	public void placeGate(int x, int y) {
		gateLocation.x = x;
		gateLocation.y = y;
		gateView.setImage(gateImage);
		gateView.setX(gateLocation.x * scale);
		gateView.setY(gateLocation.y * scale);
		this.root.add(gateView);
		this.chipsMap.setMap(gateLocation.x, gateLocation.y, true);
	}

	public boolean isUnlocked() {
		return unlocked;
	}
	
	public Point getGateLocation() {
		return gateLocation;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (o instanceof Player) {
			playerLocation = ((Player)o).getPlayerLocation();
			if (chipsMap.chipCount == 1) {
				chipsMap.setMap(gateLocation.x, gateLocation.y, false);
				unlocked = true;
			}
			if (playerLocation.x == gateLocation.x && playerLocation.y == gateLocation.y) {
				if (unlocked) {
					this.root.remove(gateView);
					setChanged();
					notifyObservers();
				}
			}
		}
	}
	
}

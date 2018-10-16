package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal implements Observer {
	Point portalLocation = new Point(0,0);
	ChipsMap chipsMap;
	Image portalImage;
	ObservableList<Node> root;
	ImageView portalView = new ImageView();
	Point playerLocation;
	boolean end = false;
	int scale = 20;
	
	public Portal(ChipsMap chipsMap, ObservableList<Node> root) {
		this.chipsMap = chipsMap;
		this.root = root;
		// portalImage = new Image("edu/nd/se2018/homework/hwk6/textures/portal.png");
		portalImage = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/portal.png").toExternalForm(),20,20,true,true);
	}
	
	public void placePortal(int x, int y) {
		portalLocation.x = x;
		portalLocation.y = y;
		portalView.setImage(portalImage);
		portalView.setX(portalLocation.x * scale);
		portalView.setY(portalLocation.y * scale);
		this.root.add(portalView);
	}
	
	public void setReached() {
		end = true;
		this.root.remove(portalView);
	}
	
	public Point getPortalLocation(){
		return portalLocation;
	}
	
	public void update(Observable o, Object arg) {
		if (o instanceof Player) {
			playerLocation = ((Player)o).getPlayerLocation();
			if(playerLocation.x == portalLocation.x && playerLocation.y == portalLocation.y) {
				setReached();
				System.out.println("Level completed!");
			}
		}
	}
}

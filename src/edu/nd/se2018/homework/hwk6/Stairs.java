package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stairs implements Observer {
	Point stairsLocation = new Point(0,0);
	ChipsMap chipsMap;
	Image stairsImage;
	ObservableList<Node> root;
	ImageView stairsView = new ImageView();
	Point playerLocation;
	Player player;
	boolean end = false;
	int scale = 20;
	
	public Stairs(ChipsMap chipsMap, ObservableList<Node> root) {
		this.chipsMap = chipsMap;
		this.root = root;
		// portalImage = new Image("edu/nd/se2018/homework/hwk6/textures/portal.png");
		stairsImage = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/stairs.png").toExternalForm(),20,20,true,true);
	}
	
	public void placeStairs(int x, int y) {
		stairsLocation.x = x;
		stairsLocation.y = y;
		stairsView.setImage(stairsImage);
		stairsView.setX(stairsLocation.x * scale);
		stairsView.setY(stairsLocation.y * scale);
		this.root.add(stairsView);
	}
	
	public Point getStairLocation(){
		return stairsLocation;
	}
	
	public void transferLocation() {
		player.setPlayerLocation(12, 12);
	}
	
	public void update(Observable o, Object arg) {
		if (o instanceof Player) {
			playerLocation = ((Player)o).getPlayerLocation();
			if(playerLocation.x == stairsLocation.x && playerLocation.y == stairsLocation.y) {
				System.out.println("stairs");
				transferLocation();
			}
		}
	}
}

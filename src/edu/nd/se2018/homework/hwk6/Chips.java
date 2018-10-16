package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chips extends Observable implements Observer{
	Point chipLocation = new Point(0,0);
	ChipsMap chipsMap;
	Image chipImage;
	ObservableList<Node> root;
	ImageView chipView = new ImageView();
	boolean acquired;
	Point manLocation;
	
	int scale = 20;
	
	public Chips(ChipsMap chipsMap, ObservableList<Node> root) {
		this.chipsMap = chipsMap;
		this.root = root;
		acquired = false;
		
		chipImage = new Image(getClass().getResource("/edu/nd/se2018/homework/hwk6/textures/chipItem.png").toExternalForm(),20,20,true,true);
	}
	
	public void placeChip(int x, int y) {
		chipLocation.x = x;
		chipLocation.y = y;
		chipView.setImage(chipImage);
		chipView.setX(chipLocation.x * scale);
		chipView.setY(chipLocation.y * scale);
		this.root.add(chipView);
	}
	
	private void incrementChip() {
		this.root.remove(chipView);
		acquired = true;
		chipsMap.chipCount++;
		System.out.println("chips: " + chipsMap.chipCount);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Player){
			manLocation = ((Player)o).getPlayerLocation();
			if (manLocation.x == chipLocation.x && manLocation.y == chipLocation.y) {
				incrementChip();
			}
		}
	}
}

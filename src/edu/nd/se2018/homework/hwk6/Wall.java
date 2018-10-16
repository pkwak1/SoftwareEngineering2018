package edu.nd.se2018.homework.hwk6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall {
	
	ChipsMap map;
	ObservableList<Node> root;
	Image wallImage;
	ImageView[][] wallView = new ImageView[25][25];
	int scale = 20;
	
	public Wall(ChipsMap map, ObservableList<Node> root) {
		this.map = map;
		this.root = root;
		wallImage = new Image("edu/nd/se2018/homework/hwk6/textures/bugUp.png");
	}
	
	public void buildWall(int x, int y) {
		if(x >= 0 && x <= 24 && y >= 0 && y <= 24) {
			Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.DARKGREY);
			root.add(rect);
			map.setMap(x, y, true);
		}
	}
}

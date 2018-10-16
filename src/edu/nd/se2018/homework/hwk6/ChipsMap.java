package edu.nd.se2018.homework.hwk6;

import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ChipsMap {
	Random rand = new Random();
	public ObservableList<Node> root;
	boolean[][] chipsGrid = new boolean[25][25];
	final int dimensions = 25;
	private static ChipsMap chipsMap;
	Player player;
	public int chipCount;
	
	// level instantiations
	Portal portal;
	Wall wall;
	Stairs stairs;
	
	public static ChipsMap getInstance() {
        if (chipsMap == null) {
            chipsMap = new ChipsMap();
        }

        return chipsMap;
    }
	
	public void drawMap(ObservableList<Node> root, int scale) {
		this.root = root;
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				//rect.setFill(Color.GREY);
				Image img = new Image("edu/nd/se2018/homework/hwk6/textures/BlankTile.png");
				rect.setFill(new ImagePattern(img));
				root.add(rect);
				chipsGrid[x][y] = false;
				
//				Image shipImage = new Image(getClass().getResource("../chip/textures/BlankTile.png").toExternalForm(),25,25,true,true);
//				shipImageView.setImage(shipImage);
//			    shipImageView.setX(x * scale);
//			    shipImageView.setY(y * scale);
//			    pane.getChildren().add(shipImageView);
			}
		}
		
		
		/* possible to implement random walls and stuff
		int islandCount = 0;		
		while (islandCount < 10) {
			int n1 = rand.nextInt(24);
			int n2 = rand.nextInt(24);

			if (!oceanGrid[n1][n2]) {
				Rectangle rect = new Rectangle(n1*scale, n2*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
				oceanGrid[n1][n2] = true;
				islandCount++;
			}
		}
		*/
		
		// test for wall
		
		chipCount = 0;
	}
	
	public boolean getMap(int x, int y) {
		return chipsGrid[x][y];
	}
	
	public void setMap(int x, int y, boolean isBound) {
		chipsGrid[x][y] = isBound;
	}
	
	public void addPlayer(Player player) {
		this.player = player;
	}
	
	public int getChipCount() { 
		return chipCount;
	}
	
	public Portal getPortal() {
		return portal;
	}
	
	public void level1(ObservableList<Node> root) {
		System.out.println("level1 start!");
		wall = new Wall(this, root);
		wall.buildWall(0,0);
		wall.buildWall(24,24);
		
		// Chips
		Chips chip1 = new Chips(this, root);
		chip1.placeChip(9, 10);
		this.player.addObserver(chip1);
		
		// ChipsGate
		ChipsGate chipsGate = new ChipsGate(this, root);
		chipsGate.placeGate(23, 12);
		wall.buildWall(24,11);
		wall.buildWall(24,13);
		wall.buildWall(23,11);
		wall.buildWall(23,13);
		this.player.addObserver(chipsGate);
		
		// Stairs
		Stairs stairs = new Stairs(this, root);
		stairs.placeStairs(20, 20);
		this.player.addObserver(stairs);
		
		// Portal
		Portal portal = new Portal(this, root);
		portal.placePortal(24, 12);
		this.player.addObserver(portal);
	}
	
	public void level2(ObservableList<Node> root) {
		System.out.println("level2 start!");
		wall = new Wall(this, root);
		wall.buildWall(0,0);
		wall.buildWall(24,24);
		
		// Chips
		Chips chip1 = new Chips(this, root);
		chip1.placeChip(9, 10);
		this.player.addObserver(chip1);
		
		// ChipsGate
		ChipsGate chipsGate = new ChipsGate(this, root);
		chipsGate.placeGate(23, 12);
		wall.buildWall(24,11);
		wall.buildWall(24,13);
		wall.buildWall(23,11);
		wall.buildWall(23,13);
		this.player.addObserver(chipsGate);
		
		// Stairs
		Stairs stairs = new Stairs(this, root);
		stairs.placeStairs(1, 10);
		this.player.addObserver(stairs);
		
		// Portal
		Portal portal = new Portal(this, root);
		portal.placePortal(24, 12);
		this.player.addObserver(portal);
	}
}

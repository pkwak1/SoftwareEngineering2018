package edu.nd.se2018.homework.hwk6;

import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ChipsMap {
	Random rand = new Random();
	boolean[][] chipsGrid = new boolean[25][25];
	final int dimensions = 25;
	private static ChipsMap chipsMap;
	
	ImageView shipImageView = new ImageView(); // TODO: Get grid on screen
	
	public static ChipsMap getInstance() {
        if (chipsMap == null) {
            chipsMap = new ChipsMap();
        }

        return chipsMap;
    }
	
	public void drawMap(ObservableList<Node> root, int scale) {
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
	}
	
	public boolean getMap(int x, int y) {
		return chipsGrid[x][y];
	}
}

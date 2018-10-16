package edu.nd.se2018.homework.hwk6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class TextBox {
	ChipsMap chipsMap;
	ObservableList<Node> root;
	int scale = 20;
	Text chips;
	int chipsCount = 0;
	
	public TextBox(ChipsMap chipsMap, ObservableList<Node> root) {
		this.chipsMap = chipsMap;
		this.root = root;
	}
	
	public void writeText() {
		updateText();
		clearText();
		
		// Chips
		chips = new Text();
		chips.setText("Chip Count: " + chipsCount);
		chips.setX(25.3*scale);
		chips.setY(4*scale);
		root.add(chips);
	}
	
	private void updateText() {
		chipsCount = chipsMap.getChipCount();
	}
	
	private void clearText() {
		root.remove(chips);
	}

}

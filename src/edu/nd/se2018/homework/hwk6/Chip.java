package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;

import edu.nd.se2018.homework.hwk6.ChipsMap;

public class Chip extends Observable {
	ChipsMap chipsMap;
	Point currentLocation;
	
	public Chip(ChipsMap map) {
        currentLocation = new Point(10, 10);
        chipsMap = map;
    }
	
	public Point getShipLocation(){
		return currentLocation;
	}
	
	public void goEast() {
		if (currentLocation.x < 24) {
			boolean island = chipsMap.getMap(currentLocation.x+1,currentLocation.y);
			if (!island) {
				currentLocation.x++;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if (currentLocation.x > 0) {
			boolean island = chipsMap.getMap(currentLocation.x-1,currentLocation.y);
			if (!island) {
				currentLocation.x--;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goSouth() {
		if (currentLocation.y < 24) {
			boolean island = chipsMap.getMap(currentLocation.x,currentLocation.y+1);
			if (!island) {
				currentLocation.y++;
				setChanged();
				notifyObservers();
			}
		}
		
	}

	public void goNorth() {
		if (currentLocation.y > 0) {
			boolean island = chipsMap.getMap(currentLocation.x,currentLocation.y-1);
			if (!island) {
				currentLocation.y--;
				setChanged();
				notifyObservers();
			}
		}
		
	}
}

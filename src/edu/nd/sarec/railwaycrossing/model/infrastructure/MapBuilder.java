package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;

/**
 * Creates all infrastructure for the simulation
 * @author jane
 *
 */
public class MapBuilder {
	HashMap<String, Road> roads;
	HashMap<String, CrossingGate> gates;
	HashMap<String, RailwayTracks> tracks;
	HashMap<String, TJunction> tJunctions;
	
	public MapBuilder(){
		roads = new HashMap<String,Road>();	
		gates = new HashMap<String,CrossingGate>();
		tracks = new HashMap<String,RailwayTracks>();
		tJunctions = new HashMap<String, TJunction>();
		buildRoads();
		buildCrossingGates();
		buildTracks();
		assignGatesToRoads();
		buildCarFactories();
		buildTJunctions();
	}

	private void buildRoads(){
		roads.put("Western Highway",new Road(new Point(800,0),new Point (800,1000),Direction.SOUTH,true,false,"Western Highway"));
		roads.put("Skyway",new Road(new Point(400,0),new Point (400,1000),Direction.SOUTH,true,false,"Skyway"));		
		roads.put("EastWest",new Road(new Point(415,650),new Point (785,650),Direction.EAST,true,true,"EastWest"));	
	}
	
	private void buildCrossingGates(){
		gates.put("Gate1", new CrossingGate(780,480, "Gate1"));
		gates.put("Gate2", new CrossingGate(380,480, "Gate2"));		
	}
	
	private void buildTracks(){
		tracks.put("Royal", new RailwayTracks(new Point(0,500),new Point(1200,500)));
		tracks.put("Layor", new RailwayTracks(new Point(0,550),new Point(1200,550)));
		//tracks.put("Ankit", new RailwayTracks(new Point(0,1000),new Point(1,2)));
	}
	
	private void buildTJunctions() {
		tJunctions.put("tJunction", new TJunction());
	}
	
	private void assignGatesToRoads(){
		roads.get("Western Highway").assignGate(gates.get("Gate1"));
		roads.get("Skyway").assignGate(gates.get("Gate2"));
	}
	
	private void buildCarFactories(){
		roads.get("Western Highway").addCarFactory();
		roads.get("Skyway").addCarFactory();
	}
	
	public Collection<CrossingGate> getAllGates(){
		return gates.values();
	}
	
	public Collection<RailwayTracks> getTracks(){
		return tracks.values();
	}
	
	public Collection<Road> getRoads(){
		return roads.values();
	}
	
	public RailwayTracks getTrack(String name){
		 if(tracks.containsKey(name))
			 return tracks.get(name);
		 else return null;
	}
	
	public TJunction getTJunction(String name) {
		if(tJunctions.containsKey(name))
			return tJunctions.get(name);
		else return null;
	}
}

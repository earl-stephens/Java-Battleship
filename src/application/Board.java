package application;

import java.util.HashMap;

public class Board {
	public HashMap<String, Cell> cells = new HashMap<String, Cell>();
	
	public Board() {
		cells.put("A1", new Cell("A1"));
		cells.put("A2", new Cell("A2"));
		cells.put("A3", new Cell("A3"));
		cells.put("A4", new Cell("A4"));
		cells.put("B1", new Cell("B1"));
		cells.put("B2", new Cell("B2"));
		cells.put("B3", new Cell("B3"));
		cells.put("B4", new Cell("B4"));
		cells.put("C1", new Cell("C1"));
		cells.put("C2", new Cell("C2"));
		cells.put("C3", new Cell("C3"));
		cells.put("C4", new Cell("C4"));
		cells.put("D1", new Cell("D1"));
		cells.put("D2", new Cell("D2"));
		cells.put("D3", new Cell("D3"));
		cells.put("D4", new Cell("D4"));
	}
	
	public boolean valid_coordinate(String coordinate) {
		if(cells.containsKey(coordinate)) return true;
		return false;
	}
}

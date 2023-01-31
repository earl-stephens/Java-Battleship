package application;

public class Cell {
	public String coordinate;
	public Ship ship = null;
	
	public Cell(String coordinate) {
		this.coordinate = coordinate;
	}
	
	public boolean empty() {
		if(ship == null) return true;
		return false;
	}
	
	public void place_ship(Ship ship) {
		this.ship = ship;
	}
}

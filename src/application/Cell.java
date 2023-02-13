package application;

public class Cell {
	public String coordinate;
	public Ship ship = null;
	public boolean fired_upon = false;
	
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

	public void fire_upon() {
		fired_upon = true;
		if(!empty()) ship.hit();
	}
	
	public String render(boolean showArgument) {
		if(fired_upon && empty()) {
			return "M";
		}
		if(!fired_upon && !empty() && showArgument) {
			return "S";
		}
		if(fired_upon && !empty()) {
			if(ship.sunk()) return "X";
		}
		if(fired_upon && !empty()) {
			return "H";
		}
		return ".";
	}
}

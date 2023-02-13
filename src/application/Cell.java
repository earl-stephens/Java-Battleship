package application;

public class Cell {
	public Ship ship = null;
	private boolean fired_upon = false;
	
	public Cell(String coordinate) {
	}
	
	public boolean getFiredUpon() {
		return fired_upon;
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

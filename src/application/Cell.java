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
		if(empty() == false) {
			ship.hit();
		}
	}
	
	public String render() {
		if(fired_upon & empty() == true) {
			return "M";
		}
		return ".";
	}
}

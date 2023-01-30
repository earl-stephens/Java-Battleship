package application;

public class Cell {
	public String coordinate;
	public Cell ship = null;
	
	public Cell(String coordinate) {
		this.coordinate = coordinate;
	}
	
	public boolean empty() {
		if(ship == null) return true;
		return false;
	}
}

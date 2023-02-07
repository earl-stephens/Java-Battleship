package application;

public class Player {
	String name;
	public Board board;
	
	public Player(String name) {
		this.name = name;
		board = new Board();
	}
	
	public boolean placeShips() {
		boolean cruiser = false;
		boolean submarine = false;
		
		showPlacementMessages();
		
		if(cruiser & submarine) {
			return true;
		} else {
			return false;
		}
	}
	
	
}

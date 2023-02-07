package application;

public class Player {
	String name;
	public Board board;
	Ship cruiser;
	Ship submarine;
	
	public Player(String name) {
		this.name = name;
		board = new Board();
		cruiser = new Ship("Cruiser", 3);
		submarine = new Ship("Submarine", 2);
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
	
	public void showPlacementMessages() {
		System.out.println("I have laid out my ships on the grid.");
		System.out.println("You now need to lay out your two ships.");
		System.out.println("The cruiser is 3 spaces long and the submarine is two spaces long.");
		System.out.println("Lay out the ships horizontally (from left to right) or");
		System.out.println("Vertically (from to top to bottom).");
		
		placeCruiser(cruiser);
	}
	
	public void placeCruiser(Ship ship) {
		
	}
}

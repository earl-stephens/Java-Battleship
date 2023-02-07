package application;

public class Player {
	String name;
	public Board board;
	Ship cruiser;
	Ship submarine;
	
	public Player(String name, Ship ship1, Ship ship2) {
		this.name = name;
		board = new Board();
		cruiser = ship1;
		submarine = ship2;
	}
	
	public boolean placeShips() {
		boolean cruiserPlacement = false;
		boolean submarinePlacement = false;
		String[] cruiserCoordinates = getCoordinates(cruiser);
		String[] submarineCoordinates = getCoordinates(submarine);
		
		showPlacementMessages();
		cruiserPlacement = board.valid_placement(cruiser, cruiserCoordinates);
		board.place(cruiser, cruiserCoordinates);
		submarinePlacement = board.valid_placement(submarine, submarineCoordinates);
		
		if(cruiserPlacement & submarinePlacement) {
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
	}
	
	public String[] getCoordinates(Ship ship) {
		System.out.println("Enter the squares for the " + ship.name + " (" + ship.length + " spaces).");
		System.out.println("Enter the coordinates in the format 'A1 B2 C3'");
		System.out.println("(one space between coordinates, no commas)");
		
		//check for valid cells
		//check for valid placement
		
	}
}

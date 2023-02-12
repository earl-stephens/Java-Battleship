package application;

import java.util.Scanner;

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
	
	public void placeShips() {
		placeCruiser(cruiser);
		board.render(true);
		placeSubmarine(submarine);
	}

	private String[] getCoordinates(Ship ship) {
		System.out.println("Enter the squares for the " + ship.name + " (" + ship.length + " spaces).");
		System.out.println("Enter the coordinates in the format 'A1 B2 C3'");
		System.out.println("(one space between coordinates, no commas)");
		
		Scanner scanner = new Scanner(System.in);
		String playerInput = scanner.nextLine();
		String[] playerInputArray = playerInput.split(" ");
		
		return playerInputArray;
	}
	
	public boolean placeCruiser(Ship ship) {
		boolean placeIsValid = false;
		String[] cruiserCoordinates = getCoordinates(ship);
		
		for(String coords : cruiserCoordinates) {
			if(!board.valid_coordinate(coords)) {
				System.out.println("Those are invalid coordinates.  The coordinates are not on the grid.  Please try again.");
				placeCruiser(ship);
			}
		}
		
		placeIsValid = board.valid_placement(cruiser, cruiserCoordinates);
		if(!placeIsValid) {
			System.out.println("Those are invalid coordinates.  Please try again.");
			placeCruiser(ship);
		} else {
			board.place(cruiser, cruiserCoordinates);
		}
		return placeIsValid;
	}
	
	public boolean placeSubmarine(Ship ship) {
		boolean placeIsValid = false;
		String[] submarineCoordinates = getCoordinates(ship);
		
		for(String coords : submarineCoordinates) {
			if(!board.valid_coordinate(coords)) {
				System.out.println("Those are invalid coordinates.  The coordinates are not on the grid.  Please try again.");
				placeSubmarine(ship);
			}
		}
		
		placeIsValid = board.valid_placement(submarine, submarineCoordinates);
		if(!placeIsValid) {
			System.out.println("Those are invalid coordinates.  Please try again.");
			placeSubmarine(ship);
		} else {
			board.place(submarine, submarineCoordinates);
		}
		
		return placeIsValid;
	}
}

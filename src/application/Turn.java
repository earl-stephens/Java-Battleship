package application;

import java.util.Scanner;

public class Turn {
	public Player player;
	public Computer computer;
	public String winner;
	public boolean isThereAWinner = false;
	
	public Turn(Player player, Computer computer) {
		this.player = player;
		this.computer = computer;
	}
	
	public void takeTurn() {
		displayBoards();
		System.out.println("Enter the coordinate for your shot: ");
		String playerCoordinate = getPlayerCoordinate();
		updatePlayerShot(playerCoordinate);
		String computerCoordinate = getComputerCoordinate();
		updateComputerShot(computerCoordinate);
		displayTurnResults(playerCoordinate, computerCoordinate);
		checkForWinner();
	}
	
	public void displayBoards() {
		System.out.println("=====COMPUTER BOARD=====");
		computer.board.render(false);
		System.out.println("=====PLAYER BOARD=====");
		player.board.render(true);
	}
	
	public String getPlayerCoordinate() {
		String playerCoordinate;
		Scanner scanner = new Scanner(System.in);
		playerCoordinate = scanner.nextLine();
		if(!player.board.valid_coordinate(playerCoordinate)) {
			System.out.println("Please enter a valid coordinate: ");
			getPlayerCoordinate();
		}
		return playerCoordinate;
	}
	
	public void updatePlayerShot(String playerCoordinate) {
		computer.board.cells.get(playerCoordinate).fire_upon();
	}
	
	public String getComputerCoordinate() {
		int max = (int)Math.sqrt(computer.board.cells.size());
		char randomLetter = (char)(Math.random() * ((max + 65) - 65) + 65);
		String letter = String.valueOf(randomLetter);

		int randomNumber = (int)(Math.random() * (max - 1) + 1);
		String number = String.valueOf(randomNumber);
		
		return letter + number;
	}
	
	private void updateComputerShot(String computerCoordinate) {
		player.board.cells.get(computerCoordinate).fire_upon();
	}
	
	private void displayTurnResults(String playerCoordinate, String computerCoordinate) {
		System.out.println("Your shot on " + playerCoordinate + playerResult(playerCoordinate));
		System.out.println("My shot on " + computerCoordinate + computerResult(computerCoordinate));
		System.out.println();
	}
	
	public String playerResult(String playerCoordinate) {
		String output = null;
		String result = computer.board.cells.get(playerCoordinate).render(false);
		switch(result) {
		case "M":
			output = " was a miss.";
			break;
		case "H":
			output = " was a hit.";
			break;
		case "X":
			output = " sunk the enemy ship!";
			break;
			}
		return output;
	}
	
	private String computerResult(String computerCoordinate) {
		String output = null;
		String result = player.board.cells.get(computerCoordinate).render(false);
		switch(result) {
		case "M":
			output = " was a miss.";
			break;
		case "H":
			output = " was a hit.";
			break;
		case "X":
			output = " sunk the enemy ship!";
			break;
		}
		return output;
	}
	
	private void checkForWinner() {
		player.cruiser.sunk();
		player.submarine.sunk();
		if(player.cruiser.sunk & player.submarine.sunk) {
			isThereAWinner = true;
			winner = "Computer";
		}
		computer.ship1.sunk();
		computer.ship2.sunk();
		if(computer.ship1.sunk & computer.ship2.sunk) {
			isThereAWinner = true;
			winner = "Player";
		}
	}
}

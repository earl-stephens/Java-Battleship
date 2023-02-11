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
	}
	
	private void displayBoards() {
		System.out.println("=====COMPUTER BOARD=====");
		System.out.println(computer.board.render(false));
		System.out.println("=====PLAYER BOARD=====");
		System.out.println(player.board.render(true));
	}
	
	private String getPlayerCoordinate() {
		String playerCoordinate;
		Scanner scanner = new Scanner(System.in);
		playerCoordinate = scanner.nextLine();
		if(!player.board.valid_coordinate(playerCoordinate)) {
			System.out.println("Please enter a valid coordinate: ");
			getPlayerCoordinate();
		}
		return playerCoordinate;
	}
	
	private void updatePlayerShot(String playerCoordinate) {
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
}
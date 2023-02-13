package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Turn {
	public Player player;
	public Computer computer;
	public String winner;
	public boolean isThereAWinner = false;
	private ArrayList<String> coordinateArray = new ArrayList<>();
	private Set<String> firedOnCoordinates = new HashSet<>();
	
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
		coordinateArray.add(playerCoordinate);
		
		if(!player.board.valid_coordinate(playerCoordinate)) {
			System.out.println("Please enter a valid coordinate: ");
			getPlayerCoordinate();
		}
		
		if(firedOnCoordinates.contains(playerCoordinate)) {
			System.out.println("You have already fired on that coordinate.");
			System.out.println("Please select another coordinate.");
			getPlayerCoordinate();
		}
		
		String last = coordinateArray.get(coordinateArray.size() - 1);
		firedOnCoordinates.add(last);
		return last;
	}
	
	public String getComputerCoordinate() {
		HashMap<String, Cell> computerCells = computer.board.getCells();
		int max = (int)Math.sqrt(computerCells.size());
		char randomLetter = (char)(Math.random() * ((max + 65) - 65) + 65);
		String letter = String.valueOf(randomLetter);

		int randomNumber = (int)(Math.random() * (max - 1) + 1);
		String number = String.valueOf(randomNumber);
		
		return letter + number;
	}
	
	public void updatePlayerShot(String playerCoordinate) {
		HashMap<String, Cell> computerCells = computer.board.getCells();
		computerCells.get(playerCoordinate).fire_upon();
	}
	
	public void updateComputerShot(String computerCoordinate) {
		HashMap<String, Cell> playerCells = player.board.getCells();
		playerCells.get(computerCoordinate).fire_upon();
	}
	
	private void displayTurnResults(String playerCoordinate, String computerCoordinate) {
		System.out.println("Your shot on " + playerCoordinate + playerResult(playerCoordinate));
		System.out.println("My shot on " + computerCoordinate + computerResult(computerCoordinate));
		System.out.println();
	}
	
	public String playerResult(String playerCoordinate) {
		HashMap<String, Cell> computerCells = computer.board.getCells();
		String result = computerCells.get(playerCoordinate).render(false);
		return resultDecisionTree(result);
	}
	
	public String computerResult(String computerCoordinate) {
		HashMap<String, Cell> playerCells = player.board.getCells();
		String result = playerCells.get(computerCoordinate).render(false);
		return resultDecisionTree(result);
	}
	
	private String resultDecisionTree(String result) {
		String output = null;
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
		if(player.cruiser.sunk && player.submarine.sunk) {
			isThereAWinner = true;
			winner = "Computer";
		}
		computer.ship1.sunk();
		computer.ship2.sunk();
		if(computer.ship1.sunk && computer.ship2.sunk) {
			isThereAWinner = true;
			winner = "Player";
		}
	}
}

package application;

import java.util.Scanner;

public class Game {
	//create ship objects here and pass them to computer and player so
	//as to use dependency injection
	Ship playerCruiser = new Ship("Cruiser", 3);
	Ship playerSubmarine = new Ship("Submarine", 2);
	Ship computerCruiser = new Ship("Cruiser", 3);
	Ship computerSubmarine = new Ship("Submarine", 2);
	Scanner scanner = new Scanner(System.in);
	
	Player user = new Player("User", playerCruiser, playerSubmarine);
	Computer computer = new Computer();
	
	public void start() {
		String startOrQuit = mainMenu();
		if(startOrQuit.equals("q")) {
			exit();
		} else {
			runGame();
		}
	}
	
	public String mainMenu() {
		System.out.println("Welcome to Battleship");
		System.out.println("Enter p to play.  Enter q to quit.");
		
		String output = scanner.nextLine();
	
		return output;
	}
	
	public void runGame() {
		setUpBoards();
	}
	
	public void setUpBoards() {
		computer.placeShip(computerCruiser);
		computer.placeShip(computerSubmarine);
		showPlacementMessages();
		user.placeShips();
		user.board.render(true);
	}
	
	
	private void showPlacementMessages() {
		System.out.println("I have laid out my ships on the grid.");
		computer.board.render(true);
		System.out.println();
		System.out.println("You now need to lay out your two ships.");
		System.out.println("The cruiser is 3 spaces long and the submarine is two spaces long.");
		System.out.println("Lay out the ships horizontally (from left to right) or");
		System.out.println("Vertically (from to top to bottom).");
	}

	/*
	 * public runGame() {
	 * 		setUpBoards(boolean)
	 * 		Turn turn = new turn(computer, player)
	 * 		do{
	 * 			turn.computerGuess()
	 * 			turn.playerGuess()
	 * 		} while (!anyoneLostYet)
	 * 		
	 * 		endGame(turn.winner))
	 * }
	 * 
	 * public setUpBoards(boolean) {
	 * 		computer.board.valid_placement(computer.placeShip(ship))
	 * 		computer.board.valid_placement(comppp)
	 * 		player.placeShip(ship)
	 * 		player.board.valid_placement(player.placeShip(ship))
	 * 		player.placeShip(other Ship)
	 * 		player.board.valid_placement()
	 * }
	 * 
	 * public void endGame(String winner) {
	 * 		display winner
	 * 
	*/

	private void exit() {
		System.out.println("Thanks for playing.");	
		scanner.close();
		
	}
}

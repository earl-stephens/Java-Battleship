package application;

import java.util.Scanner;

public class Game {
	Player user = new Player("User");
	Computer computer = new Computer();
	
	public void start() {
		String startOrQuit = mainMenu();
		if(startOrQuit == "q") {
			System.out.println("Thanks for playing.");
		} else {
			//runGame()
		}
	}
	
	public String mainMenu() {
		System.out.println("Welcome to Battleship");
		System.out.println("Enter p to play.  Enter q to quit.");
		Scanner scanner = new Scanner(System.in);
		
		String output = scanner.nextLine();
		scanner.close();
	
		return output;
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
}

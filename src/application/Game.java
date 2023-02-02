package application;

import java.util.Scanner;

public class Game {
	Player player1 = new Player("User");
	Player player2 = new Player("Computer");
	
	public void start() {
		mainMenu();
	}
	
	public String mainMenu() {
		System.out.println("Welcome to Battleship");
		System.out.println("Enter p to play.  Enter q to quit.");
		Scanner scanner = new Scanner(System.in);
		
		String output = scanner.nextLine();
		scanner.close();
	
		return output;
	}
}

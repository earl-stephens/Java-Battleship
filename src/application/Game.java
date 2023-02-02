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
			//placement();
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
	public void placement() {
		Ship cruiserComputer = new Ship("Cruiser", 3);
		computer.place(cruiserComputer);
	}
	*/
}

package application;

public class Player {
	String name;
	public Board board;
	
	public Player(String name) {
		this.name = name;
		board = new Board();
	}
}

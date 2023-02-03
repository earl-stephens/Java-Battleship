package application;

public class Computer {
	public Board board;
	
	public Computer() {
		this.board = new Board();
	}
	
	public String[] placeCruiser() {
		
		return null;
	}
	
	public String pickRowOrColumn() {
		double randomNum = Math.random();
		if(randomNum >= 0.5) {
			return "R";
		} else {
			return "C";
		}
	}
	
	public int pickWhichRowOrColumn() {
		int randomNum =(int)((Math.random() * 4) +1);
		return randomNum;
	}
}

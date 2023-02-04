package application;

public class Computer {
	public Board board;
	
	public Computer() {
		this.board = new Board();
	}
	
	public String[] placeCruiser() {
		String columnStart;
		String rowStart;
		
		String rowOrColumn = pickRowOrColumn();
		
		String startRowOrColumn = pickWhichRowOrColumn();
		
		if(rowOrColumn == "C") {
			columnStart = pickColumnStartingPoint(3);
		} else {
			rowStart = pickRowStartingPoint(3);
		}
		
		
		
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
	
	public String pickWhichRowOrColumn() {
		int randomNum = (int)((Math.random() * 4) +1);
		return String.valueOf(randomNum);
	}
	
	public String pickRowStartingPoint(int size) {
		int randomNum = (int)((Math.random() * (size -1)) + 1);
		return String.valueOf(randomNum);
	}
	
	public String pickColumnStartingPoint(int size) {
		char randomNum = (char)(Math.random() * ((65 + size - 1) -65) + 65);
		return String.valueOf(randomNum);
	}
	
	public String[] buildCoordinateArray(String rowOrColumn, String startRowOrColumn, String startingPoint) {
		return null;
	}
}

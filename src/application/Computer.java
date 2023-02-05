package application;

public class Computer {
	public Board board;
	
	public Computer() {
		this.board = new Board();
	}
	
	public String[] placeShip(Ship ship) {
		String columnStart;
		String rowStart;
		
		//Will ship be placed horizontally or vertically
		String rowOrColumn = pickRowOrColumn();
		
		//Which row or column will the ship be in
		String startRowOrColumn = pickWhichRowOrColumn(ship.length);
		
		if(rowOrColumn == "C") {
			//Where in the column is the first coordinate
			columnStart = pickColumnStartingPoint(ship.length);
			return buildCoordinateArrayWithColumn(startRowOrColumn,columnStart, ship.length);
		} else {
			//Where in the row is the first coordinate
			rowStart = pickRowStartingPoint(ship.length);
			return buildCoordinateArrayWithRow(startRowOrColumn, rowStart);
		}
	}
	
	public String pickRowOrColumn() {
		double randomNum = Math.random();
		if(randomNum >= 0.5) {
			return "R";
		} else {
			return "C";
		}
	}
	
	public String pickWhichRowOrColumn(int size) {
		int max = (int)Math.sqrt(board.cells.size()) - size;
		int randomNum = (int)((Math.random() * max) +1);
		return String.valueOf(randomNum);
	}
	
	public String pickRowStartingPoint(int size) {
		int randomNum = (int)((Math.random() * (size -1)) + 1);
		return String.valueOf(randomNum);
	}
	
	public String pickColumnStartingPoint(int size) {
		int max = (int)Math.sqrt(board.cells.size()) - size;
		char randomNum = (char)(Math.random() * ((max + 65) - 65) + 65);
		return String.valueOf(randomNum);
	}
	
	public String[] buildCoordinateArrayWithColumn(String startRowOrColumn, String columnStart, int size) {		
		//Build fisrt coordinate
		String startCoord = columnStart;
		startCoord = startCoord + startRowOrColumn;
		
		//Build coordinate array and add first element
		String[] columnCoords = new String[size];
		columnCoords[0] = startCoord;
		startCoord = null;
		
		//Loop through to build remaining coordinates
		for(int i = 1; i < size; i++) {
			char nextLetter = columnStart.charAt(0);
			nextLetter = (char)(nextLetter + i);
			
			startCoord = String.valueOf(nextLetter);
			startCoord = startCoord + startRowOrColumn;
			columnCoords[i] = startCoord;
			startCoord = null;
		}
		
		return columnCoords;
	}
	
	public String[] buildCoordinateArrayWithRow(String startRowOrColumn, String rowStart) {	
		int adder = Integer.parseInt(startRowOrColumn);
		char rowLetter = (char)64;
		rowLetter = (char)(rowLetter + adder);
		
		String startCoord = String.valueOf(rowLetter);
		startCoord = startCoord + rowStart;
		
		String[] rowCoords = new String[3];
		rowCoords[0] = startCoord;
		startCoord = null;
		
		char secondLetter = rowStart.charAt(0);
		secondLetter = (char)(secondLetter + 1);
		
		startCoord = String.valueOf(rowLetter);
		startCoord = startCoord + String.valueOf(secondLetter);
		rowCoords[1] = startCoord;
		startCoord = null;
		
		char thirdLetter = rowStart.charAt(0);
		thirdLetter = (char)(thirdLetter + 2);
		
		startCoord = String.valueOf(rowLetter);
		startCoord = startCoord + String.valueOf(thirdLetter);
		rowCoords[2] = startCoord;
		
		return rowCoords;
	}
}

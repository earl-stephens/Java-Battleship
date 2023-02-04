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
			return buildCoordinateArrayWithColumn(startRowOrColumn,columnStart);
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
		int max = (int)Math.sqrt(board.cells.size()) - size;
		char randomNum = (char)(Math.random() * ((max + 65) - 65) + 65);
		return String.valueOf(randomNum);
	}
	
	public String[] buildCoordinateArrayWithColumn(String startRowOrColumn, String columnStart) {		
		String startCoord = columnStart;
		startCoord = startCoord + startRowOrColumn;
		
		String[] columnCoords = new String[3];
		columnCoords[0] = startCoord;
		startCoord = null;
		
		char secondLetter = columnStart.charAt(0);
		secondLetter = (char)(secondLetter + 1);
		
		startCoord = String.valueOf(secondLetter);
		startCoord = startCoord + startRowOrColumn;
		columnCoords[1] = startCoord;
		startCoord = null;
		
		char thirdLetter = columnStart.charAt(0);
		thirdLetter = (char)(thirdLetter + 2);
		
		startCoord = String.valueOf(thirdLetter);
		startCoord = startCoord + startRowOrColumn;
		columnCoords[2] = startCoord;
		
		return columnCoords;
	}
}

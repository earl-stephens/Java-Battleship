package application;

import java.util.HashMap;

public class Board {
	public HashMap<String, Cell> cells = new HashMap<String, Cell>();
	
	public Board() {
		cells.put("A1", new Cell("A1"));
		cells.put("A2", new Cell("A2"));
		cells.put("A3", new Cell("A3"));
		cells.put("A4", new Cell("A4"));
		cells.put("B1", new Cell("B1"));
		cells.put("B2", new Cell("B2"));
		cells.put("B3", new Cell("B3"));
		cells.put("B4", new Cell("B4"));
		cells.put("C1", new Cell("C1"));
		cells.put("C2", new Cell("C2"));
		cells.put("C3", new Cell("C3"));
		cells.put("C4", new Cell("C4"));
		cells.put("D1", new Cell("D1"));
		cells.put("D2", new Cell("D2"));
		cells.put("D3", new Cell("D3"));
		cells.put("D4", new Cell("D4"));
	}
	
	public boolean valid_coordinate(String coordinate) {
		if(cells.containsKey(coordinate)) return true;
		return false;
	}
	
	public boolean valid_placement(Ship ship, String[] coordinates) {
		boolean length = validateLength(ship, coordinates);
		boolean consecutive = validateConsecutive(ship, coordinates);
		
		if(length & consecutive) return true;
		return false;
	}
	
	private boolean validateLength(Ship ship, String[] coordinates) {
		if(ship.length == coordinates.length) return true; 
		return false;		
	}
	
	private boolean validateConsecutive(Ship ship, String[] coordinates) {
		
		return false;
	}
	
	public String[] getLetterArray(Ship ship, String[] coordinates) {
		String[] letterArray = new String[coordinates.length];
		for(int i = 0; i < coordinates.length; i++) {
			letterArray[i] = coordinates[i].split("")[0];
		}
		return letterArray;
	}
	
	public String[] getNumberArray(Ship ship, String[] coordinates) {
		String[] numberArray = new String[coordinates.length];
		for(int i = 0; i < coordinates.length; i++) {
			numberArray[i] = coordinates[i].split("")[1];
		}
		return numberArray;
	}
	
	public char[] stringToCharArray(Ship ship, String[] coordinates) {
		String[] letterArray = getLetterArray(ship, coordinates);
		char[] charArray = new char[letterArray.length];
		for(int i = 0; i < letterArray.length; i++) {
			String letter = letterArray[i];
			charArray[i] = letter.charAt(0);
		}
		return charArray;
	}
	
	public int[] charToIntArray(Ship ship, String[] coordinates) {
		char[] charArray = stringToCharArray(ship, coordinates);
		int[] unicodeNumberArray = new int[charArray.length];
		for(int i = 0; i < charArray.length; i++) {
			unicodeNumberArray[i] = (int)charArray[i];
		}
		return unicodeNumberArray;
	}
}

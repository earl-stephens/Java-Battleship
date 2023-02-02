package application;

import java.util.Arrays;
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
	
	public void place(Ship ship, String[] coordinates) {
		for(int i = 0; i < coordinates.length; i++) {
			cells.get(coordinates[i]).place_ship(ship);		}
	}
	
	public boolean valid_placement(Ship ship, String[] coordinates) {
		boolean length = validateLength(ship, coordinates);
		boolean consecutive = validateConsecutive(ship, coordinates);
		boolean overlap	= noOverlap(ship, coordinates);
		
		if(length & consecutive & overlap) return true;
		return false;
	}
	
	private boolean validateLength(Ship ship, String[] coordinates) {
		if(ship.length == coordinates.length) return true; 
		return false;		
	}
	
	private boolean validateConsecutive(Ship ship, String[] coordinates) {
		boolean numCheck = isConsecutive(getNumberArray(ship, coordinates));
		boolean letterCheck = isConsecutive(charToIntArray(ship, coordinates));
		if(numCheck ^ letterCheck) {
			return true;
		}
		return false;
	}
	
	private String[] getLetterArray(Ship ship, String[] coordinates) {
		String[] letterArray = new String[coordinates.length];
		for(int i = 0; i < coordinates.length; i++) {
			letterArray[i] = coordinates[i].split("")[0];
		}
		return letterArray;
	}
	
	private int[] getNumberArray(Ship ship, String[] coordinates) {
		int[] numberArray = new int[coordinates.length];
		for(int i = 0; i < coordinates.length; i++) {
			numberArray[i] = Integer.valueOf(coordinates[i].split("")[1]);
		}
		return numberArray;
	}
	
	private char[] stringToCharArray(Ship ship, String[] coordinates) {
		String[] letterArray = getLetterArray(ship, coordinates);
		char[] charArray = new char[letterArray.length];
		for(int i = 0; i < letterArray.length; i++) {
			String letter = letterArray[i];
			charArray[i] = letter.charAt(0);
		}
		return charArray;
	}
	
	private int[] charToIntArray(Ship ship, String[] coordinates) {
		char[] charArray = stringToCharArray(ship, coordinates);
		int[] unicodeNumberArray = new int[charArray.length];
		for(int i = 0; i < charArray.length; i++) {
			unicodeNumberArray[i] = (int)charArray[i];
		}
		return unicodeNumberArray;
	}

	private boolean isConsecutive(int[] testArray) {
		int min = Arrays.stream(testArray).min().getAsInt();
		int max = Arrays.stream(testArray).max().getAsInt();
		if((max - min) + 1 == testArray.length) {
			return true;
		}
		return false;
	}
	
	private boolean noOverlap(Ship ship, String[] coordinates) {
		boolean status = true;
		for(int i = 0; i < coordinates.length; i++) {
			Cell cell = cells.get(coordinates[i]);
			if(!cell.empty() & (cell.ship != ship)) {
				status = false;
			}
		}
		return status;
	}
	
	public void render(boolean showArgument) {
		String row1 = "  1 2 3 4";
		String row2 = "A "
				+ cells.get("A1").render(showArgument)
				+ " "
				+ cells.get("A2").render(showArgument)
				+ " "
				+ cells.get("A3").render(showArgument)
				+ " "
				+ cells.get("A4").render(showArgument);
		String row3 = "B "
				+ cells.get("B1").render(showArgument)
				+ " "
				+ cells.get("B2").render(showArgument)
				+ " "
				+ cells.get("B3").render(showArgument)
				+ " "
				+ cells.get("B4").render(showArgument);
		String row4 = "C "
				+ cells.get("C1").render(showArgument)
				+ " "
				+ cells.get("C2").render(showArgument)
				+ " "
				+ cells.get("C3").render(showArgument)
				+ " "
				+ cells.get("C4").render(showArgument);
		String row5 = "D "
				+ cells.get("D1").render(showArgument)
				+ " "
				+ cells.get("D2").render(showArgument)
				+ " "
				+ cells.get("D3").render(showArgument)
				+ " "
				+ cells.get("D4").render(showArgument);
		
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		System.out.println(row4);
		System.out.println(row5);
	}
}

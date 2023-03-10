package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Computer {
	public Board board;
	public Ship ship1;
	public Ship ship2;
	//ArrayList needed for maintaining state with recursive placeShip()
	public ArrayList<String> coordinateArray = new ArrayList<>();
	
	public Computer(Ship ship1, Ship ship2) {
		this.board = new Board();
		this.ship1 = ship1;
		this.ship2 = ship2;
	}
	
	public void placeShip(Ship ship) {
		String[] coordinates = generateCoordinates(ship);
		for(String coords : coordinates) {
			System.out.println(coords);
		}
		Collections.addAll(coordinateArray, coordinates);
		boolean placeIsValid = false;
		
		for(String coords : coordinates) {
			if(!board.valid_coordinate(coords)) {
				coordinateArray.clear();
				placeShip(ship);
			}
		}
		
		placeIsValid = board.valid_placement(ship, coordinates);
		if(!placeIsValid) {
			coordinateArray.clear();
			placeShip(ship);
		}
		
		String[] finalCoordinates = coordinateArray.toArray(new String[coordinateArray.size()]);
		board.place(ship, finalCoordinates);
		coordinateArray.clear();
	}
	
	public String[] generateCoordinates(Ship ship) {
		String columnStart;
		String rowStart;
		
		//Will ship be placed horizontally or vertically
		String rowOrColumn = pickRowOrColumn();
		
		//Which row or column will the ship be in
		String startRowOrColumn = pickWhichRowOrColumn(ship.length);
		
		if(rowOrColumn.equals("C")) {
			//Where in the column is the first coordinate
			columnStart = pickColumnStartingPoint(ship.length);
			return buildCoordinateArrayWithColumn(startRowOrColumn,columnStart, ship.length);
		} else {
			//Where in the row is the first coordinate
			rowStart = pickRowStartingPoint(ship.length);
			return buildCoordinateArrayWithRow(startRowOrColumn, rowStart, ship.length);
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
		HashMap<String, Cell> cells = board.getCells();
		int max = (int)Math.sqrt(cells.size()) - size;
		int randomNum = (int)((Math.random() * max) + 1);
		return String.valueOf(randomNum);
	}
	
	public String pickRowStartingPoint(int size) {
		int randomNum = (int)((Math.random() * (size - 1)) + 1);
		return String.valueOf(randomNum);
	}
	
	public String pickColumnStartingPoint(int size) {
		HashMap<String, Cell> cells = board.getCells();
		int max = (int)Math.sqrt(cells.size()) - size;
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
	
	public String[] buildCoordinateArrayWithRow(String startRowOrColumn, String rowStart, int size) {	
		//Convert startRowOrColumn to a char
		int adder = Integer.parseInt(startRowOrColumn);
		char rowLetter = (char)64;
		rowLetter = (char)(rowLetter + adder);
		
		//Build coordinate array and add first element
		String startCoord = String.valueOf(rowLetter);
		startCoord = startCoord + rowStart;
		
		String[] rowCoords = new String[size];
		rowCoords[0] = startCoord;
		startCoord = null;
		
		//Loop through to build remaining elements
		for(int i = 1; i < size; i++) {
			char nextLetter = rowStart.charAt(0);
			nextLetter = (char)(nextLetter + i);
			
			startCoord = String.valueOf(rowLetter);
			startCoord = startCoord + String.valueOf(nextLetter);
			rowCoords[i] = startCoord;
			startCoord = null;
		}
		
		return rowCoords;
	}
}

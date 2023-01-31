package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BoardTest {
	public Board board = new Board();
	
	@Test
	void testForBoardObject() {
		
		Assert.assertNotNull(board);
	}

	@Test
	void testForValidCoordinate() {
		
		Assert.assertTrue(board.valid_coordinate("A1"));
		Assert.assertTrue(board.valid_coordinate("D4"));
		Assert.assertFalse(board.valid_coordinate("A5"));
		Assert.assertFalse(board.valid_coordinate("E1"));
		Assert.assertFalse(board.valid_coordinate("A22"));
	}
	/*
	@Test
	void testForCorrectArrayLength() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"A1", "A2", "A3"};
		Assert.assertTrue(board.valid_placement(cruiser, cruiserCoord));
		Assert.assertFalse(board.valid_placement(submarine, subCoord));
	}
	*/
	@Test
	void testForBreakingUpCoordinateArray() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"C2", "C3"};
		
		String[] letters = {"A", "A", "A"};
		String[] letters2 = {"C", "C"};
		Assert.assertArrayEquals(letters, board.getLetterArray(cruiser, cruiserCoord));
		Assert.assertArrayEquals(letters2, board.getLetterArray(submarine, subCoord));
	}
	
	@Test
	void testForGettingNumberArray() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"C2", "C3"};
		
		String[] numbers = {"1", "2", "3"};
		String[] numbers2 = {"2", "3"};
		String[] badArray = {"2", "4"};
		Assert.assertArrayEquals(numbers, board.getNumberArray(cruiser, cruiserCoord));
		Assert.assertArrayEquals(numbers2, board.getNumberArray(submarine, subCoord));
		Assert.assertFalse(Arrays.equals(badArray, board.getNumberArray(cruiser,  cruiserCoord)));
	}
	/*
	@Test
	void testForConsecutiveCoordinates() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"A1", "A3"};
		
		Assert.assertTrue(board.valid_placement(cruiser, cruiserCoord));
		Assert.assertFalse(board.valid_placement(submarine, subCoord));
	}
	*/
}

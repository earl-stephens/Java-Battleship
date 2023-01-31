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
	void testForGettingLetterArray() {
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
		
		int[] numbers = {1, 2, 3};
		int[] numbers2 = {2, 3};
		int[] badArray = {2, 4};
		Assert.assertArrayEquals(numbers, board.getNumberArray(cruiser, cruiserCoord));
		Assert.assertArrayEquals(numbers2, board.getNumberArray(submarine, subCoord));
		Assert.assertFalse(Arrays.equals(badArray, board.getNumberArray(cruiser,  cruiserCoord)));
	}
	
	@Test
	void testForConvertingLetterArrayToCharArray() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"C2", "D2"};
		
		char[] cruiserExpected = {'A', 'A', 'A'};
		char[] submarineExpected = {'C', 'D'};
		char[] badArray = {'A', '1', 'C'};
		Assert.assertArrayEquals(cruiserExpected, board.stringToCharArray(cruiser, cruiserCoord));
		Assert.assertArrayEquals(submarineExpected, board.stringToCharArray(submarine, subCoord));
		Assert.assertFalse(Arrays.equals(badArray, board.stringToCharArray(submarine, subCoord)));
	}
	
	@Test
	void testForConvertingCharArrayToUnicodeNumbers() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"C2", "D2"};
		
		int[] cruiserExpected = {65, 65, 65};
		int[] submarineExpected = {67, 68};
		int[] badArray = {1, 53, 12};
		Assert.assertArrayEquals(cruiserExpected, board.charToIntArray(cruiser, cruiserCoord));
		Assert.assertArrayEquals(submarineExpected, board.charToIntArray(submarine, subCoord));
		Assert.assertFalse(Arrays.equals(badArray, board.charToIntArray(cruiser, cruiserCoord)));
	}
	
	@Test
	void testForConsecutiveLetters() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"C2", "D2"};
		
		Assert.assertFalse(board.areLettersConsecutive(cruiser, cruiserCoord));
		Assert.assertTrue(board.areLettersConsecutive(submarine, subCoord));
		
		Ship destroyer = new Ship("Destroyer", 3);
		String[] destroyerCoord = {"A1", "B2", "D3"};
		
		Assert.assertFalse(board.areLettersConsecutive(destroyer, destroyerCoord));
	}
	
	@Test
	void testForConsecutiveNumbers() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"C2", "D2"};
		
		Assert.assertTrue(board.areNumbersConsecutive(cruiser, cruiserCoord));
		Assert.assertFalse(board.areNumbersConsecutive(submarine, subCoord));
		
		Ship destroyer = new Ship("Destroyer", 3);
		String[] destroyerCoord = {"A1", "B2", "D4"};
		
		Assert.assertFalse(board.areNumbersConsecutive(destroyer, destroyerCoord));
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

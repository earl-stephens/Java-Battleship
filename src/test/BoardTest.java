package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BoardTest {
	public Board board = new Board();
	
	
	/* NOTE:
	 * There are many tests here that are commented out.  These tests were used to develop
	 * the valid_placement() method.  The methods that valid_placement calls were set to public
	 * for development purposes and for testing.  When the tests were passing and the code 
	 * was written, the methods were set to private (since only valid_placement() needs to be 
	 * public.  The tests for these private methods were then commented out.  These 
	 * commented out tests are left here to show how the development process happened.
	 */
	
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
	void testForValidPlacement() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		Ship destroyer = new Ship("Destroyer", 3);
		Ship carrier = new Ship("Carrier", 3);
		Ship hovercraft = new Ship("Hovercraft", 3);
		
		//correct values all around
		String[] cruiserCoord = {"A1", "A2", "A3"};
		
		//check for wrong legth
		String[] subCoord = {"A1", "A2", "A3"};
		
		//check for consecutive letters
		String[] destroyerCoord = {"A1", "B2", "D4"};

		//check for diagonal coordinates
		String[] carrierCoord = {"B1", "C2", "D3"};
		
		//check for vertical placement
		String[] hovercraftCoord = {"D2", "D3", "D4"};
		
		Assert.assertTrue(board.valid_placement(cruiser, cruiserCoord));
		Assert.assertFalse(board.valid_placement(submarine, subCoord));
		Assert.assertFalse(board.valid_placement(destroyer, destroyerCoord));
		Assert.assertFalse(board.valid_placement(carrier, carrierCoord));
		Assert.assertTrue(board.valid_placement(hovercraft, hovercraftCoord));
	}

	/*
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
	void testForConsecutiveCoordinates() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"A1", "A3"};
		
		Assert.assertTrue(board.validateConsecutive(cruiser, cruiserCoord));
		Assert.assertFalse(board.validateConsecutive(submarine, subCoord));
		
		Ship destroyer = new Ship("Destroyer", 3);
		String[] destroyerCoord = {"A1", "B2", "D4"};
		
		Assert.assertFalse(board.validateConsecutive(destroyer, destroyerCoord));
		
		Ship frigate = new Ship("Frigate", 3);
		String[] frigateCoord = {"A1", "B1"};
		
		Assert.assertTrue(board.validateConsecutive(frigate, frigateCoord));
		
		Ship carrier = new Ship("Carrier", 3);
		String[] carrierCoord = {"B1", "C2", "D3"};
		
		Assert.assertFalse(board.validateConsecutive(carrier, carrierCoord));
	}
	*/
}

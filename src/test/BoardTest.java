package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test
	void testForCorrectArrayLength() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		String[] cruiserCoord = {"A1", "A2", "A3"};
		String[] subCoord = {"A1", "A2", "A3"};
		Assert.assertTrue(board.valid_placement(cruiser, cruiserCoord));
		Assert.assertFalse(board.valid_placement(submarine, subCoord));
	}
}

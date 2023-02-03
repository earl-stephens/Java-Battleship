package test;
import application.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ComputerTest {
	private Computer computer = new Computer();
	
	@Test
	void testForComputerObject() {
		
		Assert.assertNotNull(computer);;
	}
	
	@Test
	void testForHavingABoard() {
		
		Assert.assertNotNull(computer.board.cells);
	}
	
	@Test
	void testForGettingCoordinates() {
		String[] result = computer.placeCruiser();
		Board board = new Board();
		
		Assert.assertEquals(3, result.length);
		for(int i = 0; i < result.length; i++) {
			Assert.assertTrue(board.valid_coordinate(result[i]));
		}
	}

	@Test
	void testForPickingHorizontalOrVertical() {
		String output = computer.pickRowOrColumn();
		
		Assert.assertTrue("R".equals(output) || "C".equals(output));
	}
}

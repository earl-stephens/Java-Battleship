package test;
import application.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Disabled
	//@Test
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
	
	@Test
	void testForPickingWhichRowOrColumn() {
		int output = computer.pickWhichRowOrColumn();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
	}
	
	@Test
	void testForPickingRowStartingPoint() {
		int output = computer.pickRowStartingPoint();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
	}
}

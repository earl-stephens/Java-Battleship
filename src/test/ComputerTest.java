package test;
import application.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
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
	@Disabled
	//@RepeatedTest(5)
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
	//@Disabled
	@RepeatedTest(5)
	void testForPickingRowStartingPoint() {
		int output = computer.pickRowStartingPoint(3);
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
		
		output = computer.pickRowStartingPoint(2);
		check = expected.contains(output);
		Assert.assertTrue(check);
	}
	//@Disabled
	@RepeatedTest(5)
	void testForPickingColumnStartingPoint() {
		String output = computer.pickColumnStartingPoint(3);
		List<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		expected.add("C");
		
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
		
		output = computer.pickColumnStartingPoint(2);
		check = expected.contains(output);
		Assert.assertTrue(check);
	}

}

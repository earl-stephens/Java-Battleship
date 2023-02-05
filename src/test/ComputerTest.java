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
	
	//@Disabled
	@Test
	void testForGettingCoordinates() {
		Ship cruiser = new Ship("Cruiser", 3);
		String[] result = computer.placeShip(cruiser);
		Board board = new Board();
		
		Assert.assertEquals(3, result.length);
		for(int i = 0; i < result.length; i++) {
			Assert.assertTrue(board.valid_coordinate(result[i]));
		}
	}

	//@Test
	@RepeatedTest(10)
	void testForPickingHorizontalOrVertical() {
		String output = computer.pickRowOrColumn();
		
		Assert.assertTrue("R".equals(output) || "C".equals(output));
	}
	//@Disabled
	@RepeatedTest(5)
	void testForPickingWhichRowOrColumn() {
		String output = computer.pickWhichRowOrColumn();
		List<String> expected = new ArrayList<String>();
		expected.add("1");
		expected.add("2");
		expected.add("3");
		expected.add("4");
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
	}
	//@Disabled
	@RepeatedTest(5)
	void testForPickingRowStartingPoint() {
		String output = computer.pickRowStartingPoint(3);
		List<String> expected = new ArrayList<String>();
		expected.add("1");
		expected.add("2");
		expected.add("3");
		
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
	
	@Test
	void testForCreatingCoordinateArrayColumnStart() {
		Assert.assertEquals(3, computer.buildCoordinateArrayWithColumn("3", "B").length);
		Assert.assertEquals(3, computer.buildCoordinateArrayWithColumn("1", "A").length);
	}
	
	@Test
	void testForCreatingCoordinateArrayRowStart() {
		Assert.assertEquals(3, computer.buildCoordinateArrayWithRow("2", "2").length);
		Assert.assertEquals(3, computer.buildCoordinateArrayWithRow("4", "1").length);
	}
	
	@RepeatedTest(10)
	void testPlaceCruiserMethod() {
		Ship cruiser = new Ship("Cruiser", 3);
		Assert.assertEquals(3, computer.placeShip(cruiser).length);
	}

}

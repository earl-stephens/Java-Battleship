package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TurnTest {
	Ship playerCruiser = new Ship("Cruiser", 3);
	Ship playerSubmarine = new Ship("Submarine", 2);
	Computer computer = new Computer();
	Player player = new Player("John Doe", playerCruiser, playerSubmarine);
	Turn turn = new Turn(player, computer);
	
	@Test
	void testTurnExists() {
		Assert.assertNotNull(turn);
	}

	@RepeatedTest(5)
	void testForGettingComputerCoordinate() {
		String output = turn.getComputerCoordinate();
		List<String> expected = new ArrayList<String>();
		expected.add("A1");
		expected.add("A2");
		expected.add("A3");
		expected.add("A4");
		expected.add("B1");
		expected.add("B2");
		expected.add("B3");
		expected.add("B4");
		expected.add("C1");
		expected.add("C2");
		expected.add("C3");
		expected.add("C4");
		expected.add("D1");
		expected.add("D2");
		expected.add("D3");
		expected.add("D4");
		
		System.out.println(output);
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
	}
}

package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TurnTest {
	Ship playerCruiser = new Ship("Cruiser", 3);
	Ship playerSubmarine = new Ship("Submarine", 2);
	Ship computerCruiser = new Ship("Cruiser", 3);
	Ship computerSubmarine = new Ship("Submarine", 2);
	Computer computer = new Computer(computerCruiser, computerSubmarine);
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
		
		boolean check = expected.contains(output);
		
		Assert.assertTrue(check);
	}
	
	@Test
	void testForDisplayingBoardMessage() {
		String expected = "D . . . .";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream output = new PrintStream(baos);
		System.setOut(output);
		
		turn.displayBoards();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];
		System.out.println(actual);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void testForGettingPlayerCoordinate() {
		System.out.println("Enter D2");

		Assert.assertEquals("D2", turn.getPlayerCoordinate());
	}
	
	@Test
	void testForPlayerResult() {
		turn.computer.board.cells.get("A1").place_ship(computerCruiser);
		turn.computer.board.cells.get("B1").place_ship(computerCruiser);
		turn.computer.board.cells.get("C1").place_ship(computerCruiser);
		turn.updatePlayerShot("A1");
		turn.updatePlayerShot("D1");
		
		Assert.assertEquals(" was a hit.", turn.playerResult("A1"));
		Assert.assertEquals(" was a miss.", turn.playerResult("D1"));
		
		turn.updatePlayerShot("B1");
		turn.updatePlayerShot("C1");
		Assert.assertEquals(" sunk the enemy ship!", turn.playerResult("C1"));
		
	}
}

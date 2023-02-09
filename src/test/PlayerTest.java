package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testForPlayerObject() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		Player player = new Player("User", cruiser, submarine);
		
		Assert.assertNotNull(player);
	}
	
	@Test
	void testThatPlayerHasABoard() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		Player player = new Player("User", cruiser, submarine);
		
		Assert.assertNotNull(player.board.cells);
	}
	
	@Test
	void testForCruiserPlacement() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		Player player = new Player("User", cruiser, submarine);
		
		String input = "A1 B1 C1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		Assert.assertTrue(player.placeCruiser(cruiser));
	}

}

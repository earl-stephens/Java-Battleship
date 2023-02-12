package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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
		Ship cruiser2 = new Ship("Cruiser2", 3);
		Player player = new Player("User", cruiser, cruiser2);
		
		System.out.println("Enter valid coordinates");
		
		Assert.assertTrue(player.placeCruiser(cruiser));
	}
	
	@Test
	void testForSubmarinePlacement() {
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 2);
		Player player = new Player("User", cruiser, submarine);
		
		System.out.println("Enter valid coordinates");
		
		Assert.assertTrue(player.placeSubmarine(submarine));
	}
	
}

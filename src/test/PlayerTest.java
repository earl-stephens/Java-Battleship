package test;
import application.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PlayerTest {
	Ship submarine = new Ship("Submarine", 2);
	Ship cruiser = new Ship("Cruiser", 3);

	@Test
	void testForPlayerObject() {
		Player player = new Player("User", cruiser, submarine);
		
		Assert.assertNotNull(player);
	}
	
	@Test
	void testThatPlayerHasABoard() {
		Player player = new Player("User", cruiser, submarine);
		HashMap<String, Cell> cells = player.board.getCells();

		Assert.assertNotNull(cells);
	}
	
	@Test
	void testForCruiserPlacement() {
		Ship cruiser2 = new Ship("Cruiser2", 3);
		Player player = new Player("User", cruiser, cruiser2);
		
		System.out.println("Enter valid coordinates");
		
		Assert.assertTrue(player.placeCruiser(cruiser));
	}
	
	@Test
	void testForSubmarinePlacement() {
		Player player = new Player("User", cruiser, submarine);
		
		System.out.println("Enter valid coordinates");
		
		Assert.assertTrue(player.placeSubmarine(submarine));
	}
	
}

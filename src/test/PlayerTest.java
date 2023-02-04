package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testForPlayerObject() {
		Player player = new Player("User");
		
		Assert.assertNotNull(player);
	}
	
	@Test
	void testThatPlayerHasABoard() {
		Player player = new Player("User");
		
		Assert.assertNotNull(player.board.cells);
	}
/*
	@Test
	void testForComputerPlacement() {
		Player player = new Player("Computer");
		Ship cruiserComputer = new Ship("Cruiser", 3);
		player.place(cruiser);
		
		Assert.assertTrue(player.board.valid_placement(cruiserComputer, coordinates))
	}
	*/
}

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

		@Test
		
}

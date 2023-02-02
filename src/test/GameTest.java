package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testForGameObject() {
		Game game = new Game();
		
		Assert.assertNotNull(game);
	}
	
	@Test
	void testForMainMenuToEndGame() {
		Game game = new Game();
		
		String input = "q";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		Assert.assertEquals("q", game.mainMenu());
	}
	
	@Test
	void testForMainMenuToStartGame() {
		Game game = new Game();
		
		String input = "p";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		Assert.assertEquals("p", game.mainMenu());
	}
}

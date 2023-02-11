package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testForGameObject() {
		Game game = new Game();
		
		Assert.assertNotNull(game);
	}
	@Disabled
	//@Test
	void testForAWinner() {
		Game game = new Game();
		game.turn.winner = "User";
		
		
	}
	/*
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
	@Test
	void testForStartToEndGame() {
		Game game = new Game();
	    String expected = "Thanks for playing.";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);

	    game.start();

	    String[] lines = baos.toString().split(System.lineSeparator());
	    String actual = lines[lines.length-1];

	    Assert.assertEquals(expected,actual);
	}
	*/
}

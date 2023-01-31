package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BoardTest {
	public Board board = new Board();
	
	@Test
	void testForBoardObject() {
		
		Assert.assertNotNull(board);
	}

}

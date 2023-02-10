package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
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

}

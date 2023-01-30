package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ShipTest {
	Ship ship = new Ship("Cruiser", 3);
	
	@Test
	void testForShipObject() {
		Assert.assertNotNull(ship);
	}
	
	@Test
	void testIfSunk() {
		Assert.assertFalse(ship.sunk());
	}

	@Test
	void testForHitMethod() {
		ship.hit();
		Assert.assertEquals(2, ship.health);
		Assert.assertFalse(ship.sunk());
		
		ship.hit();
		Assert.assertEquals(1, ship.health);
		Assert.assertFalse(ship.sunk());
		
		ship.hit();
		Assert.assertEquals(0, ship.health);
		Assert.assertTrue(ship.sunk());
	}
}

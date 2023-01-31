package test;
import application.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CellTest {
	Cell cell = new Cell("B4");
	
	@Test
	void testForCellObject() {
		Assert.assertNotNull(cell);
	}

	@Test
	void testForNullShip() {
		Assert.assertNull(cell.ship);
	}
	
	@Test
	void testTheEmptyMethod() {
		Assert.assertTrue(cell.empty());
	}
	
	@Test
	void testPlaceShipMethod() {
		Ship cruiser = new Ship("Cruiser", 3);
		cell.place_ship(cruiser);
		
		Assert.assertEquals(3, cell.ship.health);
		Assert.assertFalse(cell.empty());
	}
}

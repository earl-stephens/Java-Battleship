package test;
import application.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CellTest {
	Cell cell = new Cell("B4");
	Ship cruiser = new Ship("Cruiser", 3);
	
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
		cell.place_ship(cruiser);
		
		Assert.assertEquals(3, cell.ship.health);
		Assert.assertFalse(cell.empty());
	}
	
	@Test
	void testFiredUponAttribute() {
		cell.place_ship(cruiser);
		boolean actual = cell.getFiredUpon();
		Assert.assertFalse(actual);
	}
	
	@Test
	void testFireUponMethod() {
		cell.place_ship(cruiser);
		
		cell.fire_upon();
		boolean actual = cell.getFiredUpon();
		
		Assert.assertEquals(2, cell.ship.health);
		Assert.assertTrue(actual);
	}
	
	@Test
	void testRenderForNotFiredUponInEmptyCell() {

		Assert.assertEquals(".", cell.render(false));
		
		cell.fire_upon();
		Assert.assertEquals("M", cell.render(false));
	}
	
	@Test
	void testRenderForAPopulatedCell() {
		cell.place_ship(cruiser);
		
		Assert.assertEquals("S", cell.render(true));
		
		cell.fire_upon();
		
		Assert.assertEquals("H", cell.render(false));
		Assert.assertEquals("H", cell.render(true));
		
		cruiser.hit();
		cruiser.hit();
		
		Assert.assertTrue(cruiser.sunk());
		Assert.assertEquals("X", cell.render(false));
		Assert.assertEquals("X", cell.render(true));
	}
}

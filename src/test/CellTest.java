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
	
	@Test
	void testFiredUponAttribute() {
		Ship cruiser = new Ship("Cruiser", 3);
		cell.place_ship(cruiser);
		
		Assert.assertFalse(cell.fired_upon);
	}
	
	@Test
	void testFireUponMethod() {
		Ship cruiser = new Ship("Cruiser", 3);
		cell.place_ship(cruiser);
		
		cell.fire_upon();
		
		Assert.assertEquals(2, cell.ship.health);
		Assert.assertTrue(cell.fired_upon);
	}
	
	@Test
	void testRenderForNotFiredUponInEmptyCell() {

		Assert.assertEquals(".", cell.render(false));
		
		cell.fire_upon();
		Assert.assertEquals("M", cell.render(false));
	}
	
	@Test
	void testRenderForAPopulatedCell() {
		Ship cruiser = new Ship("Cruiser", 3);
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

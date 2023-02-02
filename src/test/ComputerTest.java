package test;
import application.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ComputerTest {
	private Computer computer = new Computer();
	
	@Test
	void testForComputerObject() {
		Assert.assertNotNull(computer);;
	}

}

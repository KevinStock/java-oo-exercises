package encapsulation;
import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerTest {

	@Test
	public void testAddMemory() {
		Computer c = new Computer(4, 100, 100, "Lenovo");
		assertTrue("Problem setting memory in the constructor", c.getMemory() == 4);
		c.addMemory(2);
		assertTrue("Problem updating memory in addMemory()", c.getMemory() == 6);
	}
	
	@Test
	public void testAddMemoryMax() {
		Computer c = new Computer(16, 100, 100, "Lenovo");
		assertTrue("Problem setting memory in the constructor", c.getMemory() == 16);
		c.addMemory(2);
		assertTrue("Problem updating memory in addMemory(), when we hit the maximum allowed", c.getMemory() == 16);
	}

	@Test
	public void testInvalidMemory() {
		try {
			Computer c = new Computer(-16, 100, 100, "Lenovo");
			fail("Exception was not thrown for invalid value");
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}

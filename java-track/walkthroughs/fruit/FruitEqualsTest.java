package fruit;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.TestCase;

public class FruitEqualsTest extends TestCase {

	private Orange o1 = new Orange(); // name -> "orange"; isCitrus -> boolean
	private Orange o2 = new Orange(); 
	private Orange o3 = new Orange();
	// name -> "orange"; isCitrus -> boolean; from -> "southern California"
	private RegionalOrange ro = new RegionalOrange("southern California");
	private Peach p = new Peach();
	
	@Test
	public void testEqualsOperator() {
		assertTrue(o1 == o1);
		assertFalse(o1 == o2);
	}
	
	@Test
	public void testSelfEquals() {
		assertTrue(o1.equals(o1));
		assertTrue(ro.equals(ro));
		assertTrue(p.equals(p));
	}
	
	@Test
	public void testSubclassNotEquals() {
		assertFalse(o1.equals(ro));
		assertFalse(ro.equals(o1));
	}
	
	@Test
	public void testValueCheck() {
		assertTrue(o1.equals(o2));
		assertTrue(o2.equals(o1));
		assertFalse(o1.equals(p));
		assertFalse(p.equals(o1));
	}
	
	@Test
	public void testTransitivity() {
		assertTrue(o1.equals(o2));
		assertTrue(o2.equals(o3));
		assertTrue(o3.equals(o1));
	}
	
	@Test
	public void testNull() {
		assertFalse(o1.equals(null));
	}

}

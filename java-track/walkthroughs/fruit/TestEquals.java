package fruit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEquals {

	@Test
	public void testEqualsOperator() {
		String a = new String("hello");
		String b = new String("hello");
		assertFalse(a == b);
		
		String c = new String("hi");
		String d = c;
		assertTrue(c == d);
	}

}

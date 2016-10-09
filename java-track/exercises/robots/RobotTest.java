import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void moveRobotTest() {
		Robot r = new Robot("Kevin", new int[] {5, 5}, 3, 'N');
		r.moveRobot();
		assertTrue("Problem moving robot xPos", r.getPosX() == 8);
		assertTrue("Problem moving robot yPos", r.getPosY() == 5);
	}

	@Test
	public void rotateTest() {
		Robot r = new Robot("Kevin", new int[] {5, 5}, 3, 'N');
		r.rotate();
		assertTrue("Problem rotating robot", r.getOrientation() == 'E');
		r.rotate();
		assertTrue("Problem rotating robot", r.getOrientation() == 'S');
		r.rotate();
		assertTrue("Problem rotating robot", r.getOrientation() == 'W');
		r.rotate();
		assertTrue("Problem rotating robot", r.getOrientation() == 'N');
	}
	
	@Test
	public void getDistanceTest() {
		Robot r1 = new Robot("Kevin", new int[] {5, 5}, 3, 'N');
		Robot r2 = new Robot("John", new int[] {1, 1}, 3, 'S');
		assertTrue("Problem with distance", Math.round(r1.getDistance(r2) * 10000.0) / 10000.0 == 5.6569); 
	}
	
	@Test
	public void pickupHeavyTest() {
		PackMuleRobot pmr1 = new PackMuleRobot("Kevin", new int[] {5, 5}, 3, 'N', 30.0);
		assertFalse("Problem with picking up too heavy of an object", pmr1.pickup("Bowling Ball", 31));
		assertTrue(pmr1.pickup("Sock", 10.0));
		assertFalse(pmr1.pickup("Car", 21.0));
	}
	
	@Test
	public void pickupMultipleTest() {
		PackMuleRobot pmr1 = new PackMuleRobot("Kevin", new int[] {5, 5}, 3, 'N', 30.0);
		for (int i = 0; i < 30; i++) {
			assertTrue("Problem picking up multiple objects", pmr1.pickup("Paper", 1.0));
		}
	}
	
	@Test
	public void dropTest() {
		PackMuleRobot pmr1 = new PackMuleRobot("Kevin", new int[] {5, 5}, 3, 'N', 30.0);
		pmr1.pickup("Paper", 1);
		pmr1.pickup("Pen", 2);
		assertTrue("Problem dropping an object", pmr1.drop("Paper"));
		assertFalse("Problem dropping an object not being carried", pmr1.drop("Sock"));
	}
	
	
}

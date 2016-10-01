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
	
}

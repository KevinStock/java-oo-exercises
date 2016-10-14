package robots;

import java.util.Arrays;

public class Robot {

	// Attributes
	protected String name;
	//private int posX;
	//private int posY;
	private int[] position;
	private int speed;
	private char orientation;
	private RobotBehavior behavior;
	
	/**
	 * Robot Constructor
	 * @param name
	 * @param posX
	 * @param posY
	 * @param speed
	 * @param orientation
	 */
	public Robot(String name, int[] position, int speed, char orientation) {
		this.name = name;
		this.position = position;
		//this.posX = posX;
		//this.posY = posY;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	public int getPosX() {
		return position[0];
	}

	public int getPosY() {
		return position[1];
	}

	public char getOrientation() {
		return orientation;
	}

	/**
	 * Move a robot according to direction and distance from current position
	 */
	public void moveRobot() {
		switch (this.orientation) {
			case 'N':
				this.position[0] += this.speed;
				break;
			case 'E':
				this.position[1] += this.speed;
				break;
			case 'S':
				this.position[0] -= this.speed;
				break;
			case 'W':
				this.position[1] -= this.speed;
				break;
		}
	}
	
	/**
	 * Rotate a robot clockwise
	 */
	public void rotate() {
		switch (this.orientation) {
			case 'N':
				this.orientation = 'E';
				break;
			case 'E':
				this.orientation = 'S';
				break;
			case 'S':
				this.orientation = 'W';
				break;
			case 'W':
				this.orientation = 'N';
		}
	}
	
	/** Get the distance between two robots
	 * @param r2
	 * @return
	 */
	public double getDistance(Robot r2) {
		return Math.sqrt(Math.pow(((double)r2.position[0] - (double)this.position[0]), 2) + 
				Math.pow(((double)r2.position[1] - (double)this.position[1]), 2));
	}
	
	// Display robot detail
	public void printDescription() {
		System.out.print("Name: " + this.name + " Position: " + this.position[0] + "," +
				this.position[1] + " Speed: " + this.speed +
				" Orientation: " + this.orientation);
	}
	
	public void setBehavior(RobotBehavior behavior) {
		this.behavior = behavior;
	}
	
	
	@Override
	public String toString() {
		return "Name: " + name + " Position: " + Arrays.toString(position) + " Speed: " + speed + " Orientation: "
				+ orientation + " Behavior " + behavior;
	}

	public static void main(String[] args) {

		Robot r1 = new AttackRobot("Kevin", new int[] {5, 5}, 3, 'N', 3, 5);
		Robot r2 = new AttackRobot("Joel", new int[] {1, 1}, 3, 'S', 5, 10);
		r1.setBehavior(new AggressiveBehavior());
		r2.setBehavior(new DefensiveBehavior());
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		r1.behavior.doNextMove(r1, r2);
		
//		while (!ar1.isDead() && !ar2.isDead()) {
		for (int i = 0; i < 10; i++) {
			r1.behavior.doNextMove(r1, r2);
			
			r2.behavior.doNextMove(r2, r1);
		}
	}

}

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
				+ orientation;
	}

	public static void main(String[] args) {

		AttackRobot ar1 = new AttackRobot("Kevin", new int[] {5, 5}, 3, 'N', 10, 5);
		AttackRobot ar2 = new AttackRobot("Joel", new int[] {1, 1}, 3, 'S', 10, 5);
		ar1.setBehavior(new AggressiveBehavior());
		ar2.setBehavior(new DefensiveBehavior());
		
		while (!ar1.isDead() && !ar2.isDead()) {
			doNextMove(ar1, ar2);
			doNextMove(ar2, ar1);	
		}
	}

}

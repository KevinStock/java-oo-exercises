package robots;

public class Robot {

	// Attributes
	protected String name;
	//private int posX;
	//private int posY;
	private int[] position;
	private int speed;
	private char orientation;
	
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
	
	public static void main(String[] args) {

		Robot r1 = new Robot("Bob", new int[] {5, 5}, 3, 'S');
		r1.printDescription();
		r1.moveRobot();
		System.out.println();
		System.out.println("Moved");
		r1.printDescription();
		r1.rotate();
		System.out.println();
		System.out.println("Rotated");
		r1.moveRobot();
		System.out.println("Moved");		
		r1.printDescription();
		r1.rotate();
		System.out.println();
		System.out.println("Rotated");
		r1.moveRobot();
		System.out.println("Moved");
		r1.printDescription();
		r1.rotate();
		System.out.println();
		System.out.println("Rotated");
		r1.printDescription();
		r1.rotate();
		System.out.println();
		System.out.println("Rotated");
		r1.printDescription();
		System.out.println();
		Robot r2 = new Robot("John", new int[] {1, 1}, 5, 'E');
		System.out.println(r1.getDistance(r2));
		System.out.println((double)Math.round(r1.getDistance(r2) * 10000.0) / 10000.0);
	}

}

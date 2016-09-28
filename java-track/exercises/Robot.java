
public class Robot {

	// Attributes
	private String name;
	private int posX;
	private int posY;
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
	public Robot(String name, int posX, int posY, int speed, char orientation) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.orientation = orientation;
	}

	/**
	 * Move a robot according to direction and distance from current position
	 */
	public void moveRobot() {
		switch (this.orientation) {
			case 'N':
				this.posX += this.speed;
				break;
			case 'E':
				this.posY += this.speed;
				break;
			case 'S':
				this.posX -= this.speed;
				break;
			case 'W':
				this.posY -= this.speed;
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
		return Math.sqrt(Math.pow(((double)r2.posX - (double)this.posX), 2) + Math.pow(((double)r2.posY - (double)this.posY), 2));
	}
	
	// Display robot detail
	public String toString() {
		return "Name: " + this.name + " Position: " + this.posX + "," + this.posY + " Speed: " + this.speed + " Orientation: " + this.orientation;
	}
	
	public static void main(String[] args) {

		Robot r1 = new Robot("Bob", 5, 5, 3, 'S');
		System.out.println(r1.toString());
		r1.moveRobot();
		System.out.println("Moved");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		r1.moveRobot();
		System.out.println("Moved");		
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		r1.moveRobot();
		System.out.println("Moved");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		System.out.println(r1.toString());
		
		Robot r2 = new Robot("John", 1, 1, 5, 'E');
		System.out.println(r2.getDistance(r1));
	}

}

import java.util.Arrays;

public class Robot {

	private String name;
	private int[] position;
	private int speed;
	private int[] orientation;
	
	public Robot(String name, int[] position, int speed, int[] orientation) {
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	/*
	 * [1,0]  = North
	 * [0,1]  = East
	 * [-1,0] = South
	 * [0,-1] = West
	*/
	
	public void moveRobot() {
		for (int i = 0; i < position.length; i++) {
			for (int j = this.speed; j > 0; j--) {
				this.position[i] += this.orientation[i];
			}
		}
	}
	
	public void rotate() {
		for (int i = 0; i < this.orientation.length; i++) {
			if (this.orientation[i] < 0) {
				this.orientation[i] += 1;
			}
			else {
				this.orientation[i] += -1;
			}
			
		}
	}
	
	public int distance(Robot r2) {
		
		return 0;
	}
	
	public String toString() {
		return "Name: " + this.name + " Position: " + Arrays.toString(this.position) + " Speed: " + this.speed + " Orientation: " + Arrays.toString(this.orientation);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r1 = new Robot("Bob", new int[]{5,5}, 3, new int[]{1,0});
		System.out.println(r1.toString());
		r1.moveRobot();
		System.out.println("Moved");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		System.out.println(r1.toString());
		r1.rotate();
		System.out.println("Rotated");
		System.out.println(r1.toString());
	}

}

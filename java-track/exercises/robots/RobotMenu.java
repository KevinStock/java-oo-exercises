package robots;
import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {

	private ArrayList<Robot> robots;
	private Scanner s;
	
	// Constructor
	public RobotMenu() {
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}

	public static void main(String[] args) {		
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.robotMenu();
			rm.processInput(x);
		} while (x != 6);
	}
	
	public int robotMenu() {
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Computer the distance between two robots");
		System.out.println("6. Exit");
		
		int selection = s.nextInt();
		while (selection < 1 || selection > 6) {
			System.out.println("Invalid selection. Please try again.");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection) {
		if (selection == 1) {
			createRobot();
		}
		else if (selection == 2) {
			displayRobots();
		}
		else if (selection == 3) {
			Robot selectedRobot = selectRobot();
			selectedRobot.moveRobot();
			System.out.println("Here is the robot's status after it moved:");
			System.out.println(selectedRobot);
			System.out.println();
		}
		else if (selection == 4) {
			Robot selectedRobot = selectRobot();
			selectedRobot.rotate();
			System.out.println("Here is the robot's status after it rotated:");
			System.out.println(selectedRobot);
			System.out.println();
		}
		else if (selection == 5) {
			Robot firstRobot = selectRobot();
			Robot secondRobot = selectRobot();
			double distance = firstRobot.getDistance(secondRobot);
			System.out.println("The distance between the robots you selected is: " + distance);
			System.out.println();
		}
	}
	
	private void createRobot() {
		System.out.println("Please enter a name for the robot: ");
		String name = s.next();
		while (name.length() <= 0) {
			System.out.println("Invalid name. Please try again.");
			name = s.next();
		}
		System.out.println("Please enter an x position for the robot:");
		int x = s.nextInt();
		while (x < 0) {
			System.out.println("Invalid position. Please provide a positive X value.");
			x = s.nextInt();
		}
		System.out.println("Please enter a y position for the robot: ");
		int y = s.nextInt();
		while (y < 0) {
			System.out.println("Invalid position. Please provide a positive Y value.");
			y = s.nextInt();
		}
		System.out.println("Please enter a speed for the robot: ");
		int speed = s.nextInt();
		while (speed < 0) {
			System.out.println("Invalid speed. Please provide a positive speed value.");
			speed = s.nextInt();
		}
		System.out.println("Please enter an orientation for the robot (north = N, east = E, south = S, west = W):");
		char orientation = s.next().charAt(0);
		String expectedChars = ("NESW");
		while (expectedChars.indexOf(orientation) < 0) {
			System.out.println("Invalid orientation. Please try again.");
			orientation = s.next().charAt(0);
		}
		robots.add(new Robot(name, new int[] {x, y}, speed, orientation));
	}

	private void displayRobots() {
		for (int i = 0; i < robots.size(); i++) {
			System.out.println((i+1) + ".)" + robots.get(i));
		}
		System.out.println();
	}

	private Robot selectRobot() {
		System.out.println("\nPlease select a robot: ");
		displayRobots();
		int selection = s.nextInt();
		while (selection < 1 || selection > robots.size()) {
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return robots.get(selection - 1);
	}
	
}

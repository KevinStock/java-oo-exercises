package robots;

public class DefensiveBehavior implements RobotBehavior {

	@Override
	public void doNextMove(Robot r1, Robot r2) {
		System.out.println(r1.name + " running");
		r1.rotate();
		r1.moveRobot();
	}

}

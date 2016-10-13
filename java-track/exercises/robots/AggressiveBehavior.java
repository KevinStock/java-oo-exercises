package robots;

public class AggressiveBehavior implements RobotBehavior {

	@Override
	public void doNextMove(AttackRobot r1, AttackRobot r2) {
		System.out.println(r1.name + " attacking");
		r1.attack(r2);
	}

}

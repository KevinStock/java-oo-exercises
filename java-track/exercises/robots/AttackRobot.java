package robots;
public class AttackRobot extends Robot {

	private int maxDamage;
	private int currentDamage;
	private int attackRange;
		
	public AttackRobot(String name, int[] position, int speed, char orientation, int maxDamage, int attackRange) {
		super(name, position, speed, orientation);
		this.maxDamage = maxDamage;
		currentDamage = 0;
		this.attackRange = attackRange;
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
	public void attack(AttackRobot ar2) {
		if (isDead()) {
			System.out.println(name + " cannot attack because it is dead");
		}
		else if (ar2.isDead()) {
			System.out.println(ar2.name + " is already dead");
		}
		else {
			if (this.getDistance(ar2) < attackRange) {
				int damage = (int)(Math.random() * 10 + 1);
				ar2.currentDamage += damage;
				if (ar2.isDead()) {
					System.out.println(ar2.name + " has taken " + damage + " damage");
					System.out.println(ar2.name + " has died");
				}
				else {
					System.out.println(ar2.name + " has taken " + damage + " damage");
				}
			}
			else {
				System.out.println(ar2.name + " is too far away for an attack");
			}
		}
	}
	
	public boolean isDead() {
		if (currentDamage >= maxDamage) {
			return true;
		}
		return false;
	}
	
	public void printDescription() {
		super.printDescription();
		System.out.println(" Max Damage: " + maxDamage + " Current Damage: " + currentDamage + " Attack Range: "
				+ attackRange);
	}

	public static void main(String[] args) {
		AttackRobot ar1 = new AttackRobot("Kevin", new int[] {5, 5}, 3, 'N', 10, 5);
		AttackRobot ar2 = new AttackRobot("Joel", new int[] {1, 1}, 3, 'S', 10, 5);
		ar1.attack(ar2);
		ar1.printDescription();
		ar2.printDescription();
		ar2.rotate();
		ar2.rotate();
		ar2.moveRobot();
		ar1.printDescription();
		ar2.printDescription();
		ar1.attack(ar2);
		ar2.attack(ar1);
		ar1.printDescription();
		ar2.printDescription();
		ar1.attack(ar2);
		ar1.attack(ar2);
		ar1.attack(ar2);
		ar1.printDescription();
		ar2.printDescription();
	}
	
}

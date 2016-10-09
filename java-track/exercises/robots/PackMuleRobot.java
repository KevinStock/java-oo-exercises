package robots;
import java.util.ArrayList;

public class PackMuleRobot extends Robot {

	private double maxWeight;
	private double currentWeight;
	private ArrayList<String> items;
	private ArrayList<Double> itemWeights;
	
	public PackMuleRobot(String name, int[] position, int speed, char orientation, double maxWeight) {
		super(name, position, speed, orientation);
		this.maxWeight = maxWeight;
		items = new ArrayList<>();
		itemWeights = new ArrayList<>();
	}
	
	public boolean pickup(String item, double weight) {
		if (currentWeight + weight <= maxWeight) {
			items.add(item);
			itemWeights.add(weight);
			currentWeight += weight;
			return true;
		}
		System.out.println(item + " is too heavy. Please drop something first.");
		return false;
	}
	
	public boolean drop(String item) {
		if (items.contains(item)) {
			int itemIndex = items.indexOf(item);
			currentWeight -= itemWeights.get(itemIndex);
			items.remove(itemIndex);
			itemWeights.remove(itemIndex);
			return true;
		}
		System.out.println("Not currently carrying " + item);
		return false;
	}
	
	@Override
	public String toString() {
		return "PackMuleRobot [maxWeight=" + maxWeight + ", currentWeight=" + currentWeight + ", items=" + items
				+ ", itemWeights=" + itemWeights + "]";
	}

	public static void main(String[] args) {
		PackMuleRobot pmr1 = new PackMuleRobot("Kevin", new int[] {5, 5}, 3, 'N', 30);
		System.out.println(pmr1);
		pmr1.pickup("Sock", 10);
		System.out.println(pmr1);
		pmr1.pickup("Shirt", 5);
		System.out.println(pmr1);
		pmr1.drop("Sock");
		System.out.println(pmr1);
		pmr1.drop("Pants");
		System.out.println(pmr1);
		pmr1.pickup("Bowling Ball", 31);
		System.out.println(pmr1);
	}
}

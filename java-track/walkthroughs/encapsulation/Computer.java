package encapsulation;

public class Computer {

	// attributes
	private int memory;
	private double size;
	private double processor;
	private String brand;
	
	// Behaviors
	// Create a computer
	public Computer(int memory, double size, double processor, String brand) {
		this.memory = memory;
		this.size = size;
		this.processor = processor;
		this.brand = brand;
	}
	
	// Get the brand name
	public String getBrand() {
		return this.brand;
	}
	
	// Get the size
	public double getSize() {
		return this.size;
	}
	
	// Get the processor speed
	public double getProcessor() {
		return this.processor;
	}
	
	// Get the memory
	public int getMemory() {
		return this.memory;
	}
	
	// Add memory
	public void addMemory(int newMemory) {
		if (this.memory + newMemory > 16) {
			return;
		}
		else {
			this.memory += newMemory;
		}
	}
	
	// Swap out the processor
	public void setProcessor(double newProcessor) {
		this.processor = newProcessor;
	}
	
	// toString
	public String toString() {
		return "Memory: " + this.memory + " Processor: " + this.processor + " Size: " + this.size + " Brand: " + this.brand;
	}
	
	public static void main(String args[]) {
		Computer myComputer = new Computer(8, 2.4, 15.5, "Lenovo");
		Computer yourComputer = new Computer(4, 3.3, 13.3, "Apple");
		
		System.out.println(myComputer.getBrand());
		System.out.println(yourComputer.getBrand());
		myComputer.addMemory(4);
		System.out.println(myComputer.getMemory());
		yourComputer.addMemory(3);
		System.out.println(yourComputer.getMemory());
		System.out.println(myComputer.toString());
	}
}

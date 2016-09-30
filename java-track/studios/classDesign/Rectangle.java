package classDesign;

public class Rectangle {
    
	private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public double getArea() {
        return this.width * this.length;
    }
    
    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }
    
    public boolean isSmaller(Rectangle r2) {
        if (this.getArea() < r2.getArea()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isSquare() {
        if (this.length == this.width) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String toString() {
        return "Length: " + this.length + "\nWidth: " + this.width + "\n\n";
    }
    
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4, 5);
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getPerimeter());
		System.out.println(r1.isSquare());
		Rectangle r2 = new Rectangle(4,4);
		System.out.println(r2.isSquare());
		System.out.println(r2.isSmaller(r1));
	}

}

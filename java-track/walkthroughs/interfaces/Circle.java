package interfaces;

public class Circle implements Measurable {

	private float radius;
	
	public Circle(float r) {
		radius = r;
	}
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return (float) Math.PI * radius * radius;
	}

	@Override
	public float getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * (float) Math.PI * radius;
	}

}

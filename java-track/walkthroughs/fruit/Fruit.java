package fruit;

import java.util.Objects;

public abstract class Fruit {

	protected String name;
	protected boolean isCitrus;
	
	public boolean isCitrus() {
		return isCitrus;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		
		// self check
		if (this == o)
			return true;
		
		// null check
		if (o == null)
			return false;
		
		// type check and cast
		if (getClass() != o.getClass())
			return false;
		
		Fruit fruit = (Fruit) o;
		
		// field comparison
		return Objects.equals(name, fruit.getName()) && isCitrus == fruit.isCitrus();
	}
	
}

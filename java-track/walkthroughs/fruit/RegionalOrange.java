package fruit;

public class RegionalOrange  extends Orange {

	private String from;
	
	public RegionalOrange(String from) {
		super();
		this.from = from;
	}
	
	public void setRegion(String from) {
		this.from = from;
	}
	
	public String getRegion() {
		return from;
	}
}

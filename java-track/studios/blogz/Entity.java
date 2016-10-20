package blogz;

public abstract class Entity {

	private int uid;
	private static int uidCounter = 0;
	
	public Entity() {
		uid = incrementUID();
	}
	
	private int incrementUID() {
		uidCounter++;
		return uidCounter;
	}
	
	public int getUID() {
		return uid;
	}
	
	public static void main(String[] args) {
		Entity u = new User("Kevin", "123");
		Entity p = new Post("First", "1st Post");
		System.out.println(u);
		System.out.println(p);
	}
	
}

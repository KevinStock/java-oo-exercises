package blogz;

public abstract class Entity {

	private final int uid;
	private static int uidCounter = 0;
	
	public Entity() {
		uid = incrementUID();
	}
	
	private int incrementUID() {
		uidCounter++;
		return uidCounter;
	}
	
	protected static void decrementUID() {
		uidCounter--;
	}
	
	public int getUID() {
		return uid;
	}
	
	public static void main(String[] args) {
		Entity u = new User("Kevin", "123");
		Entity u2 = new User("?Kevin", "321");
		Entity p = new Post("First", "1st Post");
		System.out.println(u);
		System.out.println(u2);
		System.out.println(p);
		System.out.println(User.getUsers());
		System.out.println(Post.getPosts());
	}
	
}

package blogz;

import java.util.Objects;

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
	
	@Override
	public boolean equals(Object other) {
		
		// self check
		if (this == other)
			return true;
		
		// null check
		if (other == null)
			return false;
		
		// type check and cast
		if (getClass() != other.getClass())
			return false;
		
		Entity ent = (Entity) other;
		
		// field comparison
		return Objects.equals(uid, ent.getUID());
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

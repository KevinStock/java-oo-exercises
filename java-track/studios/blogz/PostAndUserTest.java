package blogz;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostAndUserTest {

	@Test
	public void usernameTest() {
		assertTrue(User.isValidUsername("Kevin"));
		assertFalse(User.isValidUsername("1Kevin"));
		assertFalse(User.isValidUsername("?Kevin"));
	}
	
	@Test
	public void passwordTest() {
		assertTrue(User.isValidPassword("123", "123"));
		assertFalse(User.isValidPassword("123", "321"));
	}
	
	@Test
	public void userListTest() {
		User u = new User("Kevin", "123");
		assertTrue(User.getUsers().contains(u));
	}
	
	@Test
	public void postListTest() {
		Post p = new Post("First", "1st Post");
		Post.getPosts().contains(p);
	}

	
}

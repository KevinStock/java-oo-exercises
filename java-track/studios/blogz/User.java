package blogz;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {

	private String username;
	private String pwdHash;
	private static ArrayList<User> users = new ArrayList<User>();
	
	public User(String username, String password) {
		try {
			if (isValidUsername(username)) {
				this.username = username;
			}
			else {
				throw new SecurityException();
			}
		} catch (Exception e) {
			System.out.println("Username is not valid");
		}
		pwdHash = hashPassword(password);
		users.add(this);
	}
	
	private static String hashPassword(String password) {
		return password;
	}
	
	public static boolean isValidPassword(String pwdHash, String password) {
		if (pwdHash == hashPassword(password)) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidUsername(String username) {
		return Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
	}

	public String getUsername() {
		return username;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}
	
	public static void main(String[] args) {
		User u = new User("Kevin?", "123");
		System.out.println(u.getUsername());
	}
}

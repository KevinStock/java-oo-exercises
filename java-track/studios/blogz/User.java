package blogz;

import java.util.ArrayList;

public class User {

	private String username;
	private String pwdHash;
	private static ArrayList<User> users = new ArrayList<User>();
	
	public User(String username, String password) {
		this.username = username;
		pwdHash = hashPassword(password);
		users.add(this);
	}
	
	private static String hashPassword(String password) {
		return password;
	}
	
	private boolean isValidPassword() {
		return true;
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
}

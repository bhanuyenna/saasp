package main.java.model;

public class User {
	private long user_id;
	private String firstname;
	private String lastname;
	private String password;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getfirstName() {
		return firstname;
	}
	public void setfirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getlastName() {
		return lastname;
	}
	public void setlastName(String lastName) {
		this.lastname = lastName;
	}
	public String getpassWord() {
		return password;
	}
	public void setpassWord(String password) {
		this.password = password;
	}

}

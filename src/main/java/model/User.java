package model;

public class User {
	private int user_id;
	private String fname;
	private String lname;
	private String password;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getfirstName() {
		return fname;
	}
	public void setfirstName(String firstName) {
		this.fname = firstName;
	}
	public String getlastName() {
		return lname;
	}
	public void setlastName(String lastName) {
		this.lname = lastName;
	}
	public String getpassWord() {
		return password;
	}
	public void setpassWord(String password) {
		this.password = password;
	}

}

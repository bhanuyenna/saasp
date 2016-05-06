package Command;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectionprovider.DBConnection;
import model.User;



public class ListOfUsers {

	public ArrayList<User> execute() {
		ArrayList<User> ret = new ArrayList<User>();
		try {
			Connection connection = DBConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM recipeusers");
			while (rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setfirstName(rs.getString("fname"));
				u.setlastName(rs.getString("lname"));
				u.setpassWord(rs.getString("password"));
				ret.add(u);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
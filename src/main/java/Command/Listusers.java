package Command;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionprovider.DBConnection;

import model.User;

public class Listusers {
	public User execute(int id) {
		User u = new User();
		try {
			Connection connection = DBConnection.getConnection();
			// Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM recipeusers WHERE user_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				u.setUser_id(rs.getInt("user_id"));
				u.setfirstName(rs.getString("fname"));
				u.setlastName(rs.getString("lname"));
				u.setpassWord(rs.getString("password"));
				
//				s.setArtist(rs.getString("artist"));
//				s.setTitle(rs.getString("title"));
//				s.setId(rs.getInt("id"));
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}

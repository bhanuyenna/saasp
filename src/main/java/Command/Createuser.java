package Command;


	
	import java.net.URISyntaxException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import connectionprovider.DBConnection;
import model.User;
	public class Createuser {

		public String execute(User s) {

			try {
				Connection connection = DBConnection.getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO recipeusers( user_id, fname, lname, password)    VALUES (?, ?, ?, ?) Returning user_id");
				stmt.setLong(1,s.getUser_id());
				stmt.setString(2, s.getfirstName());
				stmt.setString(3, s.getlastName());
				stmt.setString(4, s.getpassWord());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					return rs.getString("user_id");
				}

			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println("Exception:"+ e);;
			}
			return "-1";
		}

	}



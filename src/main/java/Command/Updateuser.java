package Command;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionprovider.DBConnection;
import model.User;



public class Updateuser {
	public String execute(User s)  {

		try {
//			User s=new User();
			Connection connection = DBConnection.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE recipeusers SET fname=?, lname=?, password=? WHERE User_ID=?");
			stmt.setString(1, s.getfirstName());
			stmt.setString(2, s.getlastName());
			stmt.setString(3, s.getpassWord());
			stmt.setInt(4, s.getUser_id());
			stmt.executeUpdate();
			

		} catch (URISyntaxException e) {
			e.printStackTrace();
			

		} catch (SQLException e) {
			e.printStackTrace();
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "-1";
	}

}

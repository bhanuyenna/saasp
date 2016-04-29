package Command;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionprovider.DBConnection;
import model.User;



public class Deleteuser {
	public String execute(User u) throws Exception {

		try {
			User s=new User();
			DBConnection db = new DBConnection();
			Connection connection = db.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("Delete from recipeusers  WHERE user_id=?");
			
			stmt.executeQuery();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}


	

}

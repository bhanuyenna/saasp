package Command;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionprovider.DBConnection;
import model.User;



public class Deleteuser {
	public String execute(int user_id) throws Exception {

		try {
//			User s=new User();
			DBConnection db = new DBConnection();
			Connection connection = db.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("Delete from recipeusers WHERE user_id=?");
			stmt.setInt(1, user_id);
			stmt.executeUpdate();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}


	

}

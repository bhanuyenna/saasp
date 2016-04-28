package connectionprovider;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	
	public static Connection getConnection() throws Exception
	{
	try
	{
	String connectionURL = "jdbc:postgresql://localhost:5432/mydb";
	Connection connection = null;
	Class.forName("org.postgresql.Driver").newInstance();
	connection = DriverManager.getConnection(connectionURL,"postgres",
			"root");
	System.out.println("Database Connected");
	return connection;
	} catch (Exception e)
	{
	throw e;
	}
	 
	}
	
	
	
	public static void main(String[] args) {
		try {
			Connection connection = getConnection();
			System.out.println("Database connected successfully");
			/*Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO GOODS(THING) VALUES('My cool Item');");
			ResultSet rs = stmt.executeQuery("SELECT Thing FROM Goods");
			while (rs.next()) {
				System.out.println("Thing: " + rs.getString("thing"));
			}*/
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e){
			System.out.println("Exception is:"+e);
			
		}
		
		
	}
	
	
	/*

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/User", "postgres",
					"root");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User");
			while (rs.next()) {
				System.out.println("I am here");
				//System.out.println("login: " + rs.getString("login"));
				System.out.println("firstName: " + rs.getString("Name"));
			//	System.out.println("lastName: " + rs.getString("ID"));
				//System.out.println("Password: " + rs.getString("Password"));
			}

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
*/
}
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;

import constants.ConfigConstants;

public class DBConnection {

   Logger LOGGER; 
	
	public Statement connectionEnablerRetStmt() {
		Connection con = null;
		Statement stmnt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					ConfigConstants.DB_CONNECTION_URL,
					ConfigConstants.DB_USER_NAME, 
					ConfigConstants.DB_PASSWORD);

			stmnt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info("Error in connecting to db, {}", e.getMessage());
		}
		return stmnt;
		}
}

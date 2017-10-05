package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;


import constants.ConfigConstants;

public class LoginValidationDAO {

	private static final Logger LOGGER = Logger.getLogger("LoginValidationDAO.class");
	
	public Statement connectionEnabler() {
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
			LOGGER.info("Error in connecting to db, "+ e.getMessage());
		}
		return stmnt;
	}

	public boolean isAdmin(final String userName, final String password) {
		final Statement stmnt = connectionEnabler();
		ResultSet rs = null;
		PreparedStatement sql = null;
		try {
/*			sql = con.prepareStatement("SELECT count(*) FROM user_profile where user_id = ?  and password = ? and is_store_admin = 1");
			sql.setString(1, userName);
			sql.setString(2, password);*/
			rs = stmnt.executeQuery("SELECT count(*) FROM user_profile "
					+ " where user_id = '"+ userName + "'" 
					+ " and password = '"+ password + "'"  
					+ " and is_store_admin = 1");
			/*ResultSet i = sql.executeQuery();*/
			while(rs.next())
			System.out.println(rs.getInt(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		try {
			if(rs.getFetchSize() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return false;
	}

/*	public boolean isUser(String userName, String password) {
		final Statement stmnt = connectionEnabler();
		ResultSet rs = null;
		try {
			rs = stmnt.executeQuery("SELECT * FROM user_profile "
					+ "where user_id = "+ userName 
					+  "and password = "+ password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.getFetchSize() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}*/

}

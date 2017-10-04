package dao;

import java.util.logging.Logger;

public class LoginValidationDAO {

	private static final Logger LOGGER = Logger.getLogger("LoginValidationDAO.class");

	public boolean isAdmin(final String userName, final String password) {
		LOGGER.info("test");
		//user exist? is Admin flag = true?
		return false;
	}

	public boolean isUser(String userName, String password) {
		LOGGER.info("test");
		//user exist? is User flag = true?
		return false;
	}

}

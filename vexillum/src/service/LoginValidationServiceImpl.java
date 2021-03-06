package service;

import dao.LoginValidationDAO;

public class LoginValidationServiceImpl implements LoginValidationService{
	
	public LoginValidationServiceImpl(){	
	}
	
	private LoginValidationDAO loginValidationDAO;
	
	@Override
	public boolean loginAsAdmin(final String userName, final String password) {
		loginValidationDAO = new LoginValidationDAO();
		if(loginValidationDAO.isAdmin(userName, password)) {
			System.out.println("OK");
			return true;	
		} else 
			System.out.println("NOT OK");
			return false;
	}

	@Override
	public boolean loginAsUser(String userName, String password) {
		loginValidationDAO = new LoginValidationDAO();
/*		if(loginValidationDAO.isUser(userName, password)) {
			return true;	
		} else */
			return false;
	}
}

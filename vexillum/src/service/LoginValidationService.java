package service;

public interface LoginValidationService {
	
	public boolean loginAsAdmin(final String userName, final String password);
	
	public boolean loginAsUser(final String userName, final String password);
}

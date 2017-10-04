package service;

import java.util.List;
import java.util.Map;

import model.PersonInfo;

public interface ProfileOperationsService {

	public Map<String, String> createUser(final PersonInfo peronInfo);
	
	public PersonInfo getUser(final String userId);
	
	public Map<String, String> updateUser(final PersonInfo peronInfo);
	
	public Map<String, String> deleteUser(final String userId);
	
	public List<PersonInfo> getUserList(final String queriedName);
	
}

package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.ProfileContants;
import dao.ProfileOperationsDAO;
import model.PersonInfo;

public class ProfileOperationsServiceImpl implements ProfileOperationsService{

	public ProfileOperationsServiceImpl() {
	}
	
	ProfileOperationsDAO profileOperationsDAO;
	Map<String, String> userStatus;
	
	@Override
	public Map<String, String> createUser(final PersonInfo peronInfo){
		//all validations must be done from API level, based on dob, age must be auto calculated
		userStatus = new HashMap<>();
		if(profileOperationsDAO.createUser(peronInfo)) {
			userStatus.put(ProfileContants.SUCCESS_FLAG, "true");
			userStatus.put(ProfileContants.MESSAGE, "User profile has been successfully created");
			userStatus.put(ProfileContants.USER_NAME, peronInfo.getFirstName());
		}
		else {
			userStatus.put(ProfileContants.SUCCESS_FLAG, "false");
			userStatus.put(ProfileContants.MESSAGE, "Failed in creating user profile");
			userStatus.put(ProfileContants.USER_NAME, peronInfo.getFirstName());
		}
		return userStatus;
	}

	@Override
	public PersonInfo getUser(String userId) {
		return profileOperationsDAO.getUser(userId);
	}

	@Override
	public Map<String, String> updateUser(PersonInfo peronInfo) {
		//all validations must be done from API level
		//only able to update password with confirm pwd, name is not editable
		userStatus = new HashMap<>();
		if(profileOperationsDAO.createUser(peronInfo)) {
			userStatus.put(ProfileContants.SUCCESS_FLAG, "true");
			userStatus.put(ProfileContants.MESSAGE, "User profile has been successfully updated");
			userStatus.put(ProfileContants.USER_NAME, peronInfo.getFirstName());
		}
		else {
			userStatus.put(ProfileContants.SUCCESS_FLAG, "false");
			userStatus.put(ProfileContants.MESSAGE, "Failed in updating user profile");
			userStatus.put(ProfileContants.USER_NAME, peronInfo.getFirstName());
		}
		return userStatus;
	}

	@Override
	public Map<String, String> deleteUser(String userId) {
		userStatus = new HashMap<>();
		if(profileOperationsDAO.deleteUser(userId)) {
			userStatus.put(ProfileContants.SUCCESS_FLAG, "true");
			userStatus.put(ProfileContants.MESSAGE, "User profile has been successfully deleted");
		}
		else {
			userStatus.put(ProfileContants.SUCCESS_FLAG, "false");
			userStatus.put(ProfileContants.MESSAGE, "Failed in deleting user profile");
		}
		return userStatus;
	}

	@Override
	public List<PersonInfo> getUserList(String queriedName) {
		return profileOperationsDAO.getUserList(queriedName);
	}
}

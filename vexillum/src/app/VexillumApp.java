package app;

import service.LoginValidationService;
import service.LoginValidationServiceImpl;


/**
 * 
 */

/**
 * @author Vishnu Gopan, 02-Oct-2017
 * @version 1.0

 */
public class VexillumApp {

	static LoginValidationService loginValidationService;
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {

		loginValidationService= new LoginValidationServiceImpl();
		loginValidationService.loginAsAdmin("testUN", "testPwd");
	}

}

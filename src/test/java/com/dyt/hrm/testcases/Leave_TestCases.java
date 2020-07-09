package com.dyt.hrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dyt.hrm.screenpages.ApplyLeave;
import com.dyt.hrm.screenpages.Home;
import com.dyt.hrm.screenpages.Login;

public class Leave_TestCases extends BaseTestClass {
	
	@Test
	void tc001_VerifyLoginAuthentication()
	{		
		//initialize elements of required pages
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		
		//Verification methods(Test case steps)
		login.pageDisplayed();
		login.loginPageElements();
		
		//call login page other negative validations
		
		login.loginAPP("user02", "TM1234");
		home.pageDisplayed();	
	}
	
	@Test
	void tc002_ApplyLeave()
	{			
		// initialize elements of required pages
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		ApplyLeave applyleave = PageFactory.initElements(driver, ApplyLeave.class);
		
		//Test case steps
		login.pageDisplayed();
		login.loginAPP("user02", "TM1234");
		home.pageDisplayed();
		
		
	}
	
	@Test
	void tc003_CancelLeave()
	{		
		
		
	}	
	
}

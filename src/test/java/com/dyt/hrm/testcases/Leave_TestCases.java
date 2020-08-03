package com.dyt.hrm.testcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dyt.hrm.screenpages.ApplyLeave;
import com.dyt.hrm.screenpages.Home;
import com.dyt.hrm.screenpages.Login;
import com.dyt.utilities.Excel;

public class Leave_TestCases extends BaseTestClass {
	
	@Test
	void tc001_VerifyLoginAuthentication()
	{		
		//get test data of current test case from test data file(Excel)
		String filepath = TESTDATA_PATH + TESTDATA_FILE;
		//String[] data = Excel.getRowData(filepath, "smoke", CURRENT_TESTCASE);
		HashMap<String, String> data = Excel.getRowData2(filepath, "smoke", CURRENT_TESTCASE);
		
		//initialize elements of required pages
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		
		//Verification methods(Test case steps)
		login.pageDisplayed();
		login.loginPageElements();
		
		//call login page other negative validations
		//login.loginAPP(data[0], data[1]);
		login.loginAPP(data.get("user"), data.get("pwd"));
		home.pageDisplayed();	
	}
	
	@Test
	void tc002_ApplyLeave()
	{			
		//get test data of current test case from test data file(Excel)
		String filepath = TESTDATA_PATH + TESTDATA_FILE;
		String[] data = Excel.getRowData(filepath, "smoke", CURRENT_TESTCASE);
				
		// initialize elements of required pages
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		ApplyLeave applyleave = PageFactory.initElements(driver, ApplyLeave.class);
		
		//Test case steps
		login.pageDisplayed();
		login.loginAPP(data[0], data[1]);
		home.pageDisplayed();
		//applyLeave(data[2], data[3], data[4], data[5]);		
	}	
	
	@Test
	void tc003_CancelLeave()
	{		
		
		
	}	
	
}

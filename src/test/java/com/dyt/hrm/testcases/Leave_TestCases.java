package com.dyt.hrm.testcases;

import org.testng.annotations.Test;

import com.dyt.utilities.ExtentReport;

public class Leave_TestCases extends BaseTestClass {
	
	@Test
	void tc001_VerifyLoginAuthentication()
	{		
		ExtentReport.log(false, "Login successful", "Login unsuccessful");
		
	}
	
	@Test
	void tc002_ApplyLeave_Validate()
	{		
		
		ExtentReport.log(true, "Apply Leave successful", "Apply Leave unsuccessful");
		
	}
	
	@Test
	void tc003_CancelLeave_Validate()
	{		
		
		ExtentReport.log(false, "Cancel leave successful", "Cancel leave unsuccessful");
		
	}
	
	
}

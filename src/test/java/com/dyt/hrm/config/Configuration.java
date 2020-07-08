package com.dyt.hrm.config;

import org.openqa.selenium.WebDriver;

public class Configuration {
	
	public static WebDriver  driver;
	
	public static String  CURRENT_TESTCASE = null;
	
	public static String SIT_URL 		= 	"http://testingmasters.com/hrm/";
	
	public static String UAT_URL 		= 	"";
	
	public static String BROWSER_NAME	= 	"CHROME";
	
	public static String PROJECTNAME 	= 	"HRM";
	public static String RELASENAME 	= 	"Release 2.0";
	public static String ENVIRONMENT 	= 	"sit";	
	
	public static String TESTDATA_PATH 	= 	System.getProperty("user.dir")+ "\\TestData\\";
	public static String TESTDATA_FILE 	= 	"HRM_TestData.xlsx";
	
	public static String RESULTS_PATH 	= 	System.getProperty("user.dir")+ "\\Results\\";
	public static String RESULTS_FILE 	= 	"\\HRM_SummaryReport.html";		
	
	public static int MAX_WAIT_TIME 	= 	10;
	public static int MID_WAIT_TIME 	= 	5;
	public static int MIN_WAIT_TIME 	= 	1;	

}
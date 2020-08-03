package com.dyt.hrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.dyt.hrm.config.Configuration;
import com.dyt.utilities.Excel;
import com.dyt.utilities.Reporter;

public class BaseTestClass extends Configuration {	
			//========================================================================	
			@BeforeSuite
			public void setupReport()
			{
				System.out.println("******  Intializing Test Suite *******");		
				Reporter.intializeReports();
				
				System.out.println("******  Test Suite is intialized sucessfully *******");
			}	
			//========================================================================
			@BeforeMethod
			public void launchBrowser(Method method)  throws IOException {		
				CURRENT_TESTCASE = method.getName();
				Reporter.startTest(CURRENT_TESTCASE);
				System.out.println("<<TestStart>> TestCase Name   " + CURRENT_TESTCASE + "  <<TestStart>>");
				//Browser = Browser.toUpperCase();
				
				switch(BROWSER_NAME)
				{
					case "FF":				
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//servers//geckodriver.exe");
							driver = new FirefoxDriver();				  
					  break;
				
					case "IE":				
						System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//servers//IEDriverServer.exe");
						driver = new InternetExplorerDriver();				 
						break; 
					  
					case "CHROME":
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//servers//chromedriver.exe");
						driver = new ChromeDriver();
						break;
						
					case "EDGE":
						System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//servers//MicrosoftWebDriver.exe");
						driver = new EdgeDriver();
						break;
						
					default: System.out.println("Incorrect browser name");						
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(SIT_URL);
			}
			//========================================================================	

			@AfterMethod
			public void closeBrowser() {		
				Reporter.closeTest();
				driver.close();
				System.out.println("<<TestEnd>> TestCase Name   " + CURRENT_TESTCASE + "  <<TestEnd>>");
				System.out.println();			
			}
			//========================================================================

			@AfterSuite
			public void flushReportAndOpen() {
				try {					
					Reporter.flushReport();
					
					Thread.sleep(2000);
					
				} catch (Exception e) {					
					e.printStackTrace();
				}
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//servers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(Reporter.resultfile);
				driver.navigate().refresh();
			}		
			//========================================================================
			/*
			@DataProvider(name="testcase_data")
		    public Map<String, String> getDataFromDataprovider() throws IOException
		    {
				Map<String, String> tc_data = new HashMap<String, String>();			
				String cellData;
				String sheetName = "smoke";
				String filepath = TESTDATA_PATH+TESTDATA_FILE;
				int rowCount = Excel.getRowCount(filepath, sheetName);
				String[] arrData;
				
				for(int row=2; row<=rowCount; row++) 
				{
					cellData = Excel.getCellData(filepath, sheetName, row, 1);
					if(cellData.trim().equals(CURRENT_TESTCASE))
					{
						arrData = Excel.getRowData(filepath, sheetName, row);
						for(int i=0; i<arrData.length; i++)
						{
							String[] data = arrData[i].split(":=");
							tc_data.put(data[0], data[1]);
						}						
					}
				}
				
		        return tc_data;
		    }
		    
		    */
			//========================================================================

}

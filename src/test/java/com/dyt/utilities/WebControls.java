package com.dyt.utilities;

import org.openqa.selenium.WebElement;

import com.dyt.hrm.config.Configuration;

public class WebControls extends Configuration {	
	
	
	public static boolean clickElement(WebElement element) 
	{
		boolean staus = true;
		try {
			element.click();
		}
		
		catch(Exception e) {
			staus = false;
		}
		
		return staus;
	}
	
	
	public static boolean setEditValue(WebElement element, String value) 
	{
		boolean staus = true;
		try {
			element.sendKeys(value);
		}
		
		catch(Exception e) {
			staus = false;
		}		
		return staus;
	}
	
	
	
}

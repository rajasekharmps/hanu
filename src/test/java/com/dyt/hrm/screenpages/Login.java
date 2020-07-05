package com.dyt.hrm.screenpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dyt.utilities.WebControls;

public class Login extends WebControls {

	boolean retval;
	WebElement login = driver.findElement(By.id("btnLogin"));
	WebElement un = driver.findElement(By.id("txtUsername"));
	WebElement pw = driver.findElement(By.id("txtPassword"));
	
	
	public void loginHRM()
	{
		//Enter user name
		retval = setEditValue(un, "user02");
		if(retval)
			System.out.println("Password entered");
		else
			System.out.println("Password not entered");
		
		//Enter password
		retval = setEditValue(pw, "TM1234");
		if(retval)
			System.out.println("Username entered");
		else
			System.out.println("Username not entered");
		
		//click login button
		retval = clickElement(login);
		if(retval)
			System.out.println("login button clicked");
		else
			System.out.println("login button not clicked");
	}
	
}

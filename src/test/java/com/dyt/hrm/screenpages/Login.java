package com.dyt.hrm.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.utilities.Reporter;
import com.dyt.utilities.WebControls;

public class Login extends WebControls {

	//========= Login page WebElements ========================
	@FindBy(xpath="//div[text()='LOGIN Panel']")
	public static WebElement labelLoginPanel;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	public static WebElement editUserName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	public static WebElement editPassword;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	public static WebElement buttonLogin;	
	
	
	//========= Login page behaviors(Verifications)============
	
	public void pageDisplayed()
	{
		boolean retval;
		retval = verifyPageTitle("OrangeHRM");
		Reporter.log(retval, "Login page title displayed correctly", "Login page title displayed incorrectly");
	}
	//------------------
	public void loginPageElements()
	{
		boolean retval;
		retval = isElementDisplayed(labelLoginPanel);
		Reporter.log(retval, "Login Panel text displayed", "Login Panel text not displayed");
		
		retval = isElementDisplayed(editUserName);
		Reporter.log(retval, "Username textbox displayed", "Username textbox not displayed");
		
		retval = isElementDisplayed(editPassword);
		Reporter.log(retval, "Password textbox displayed", "Password textbox not displayed");
		
		retval = isElementDisplayed(buttonLogin);
		Reporter.log(retval, "Login button displayed", "Login button not displayed");
	}
	//------------------
	public void loginAPP(String userID, String Password)
	{
		boolean retval;
		
		retval = setEditValue(editUserName, userID);
		Reporter.log(retval, "Username entered", "Username not entered");
		
		retval = setEditValue(editPassword, Password);
		Reporter.log(retval, "Password entered", "Password not entered");
		
		retval = clickElement(buttonLogin);
		Reporter.log(retval, "Login button clicked", "Login button not clicked");
	}	
	
	//------------------	
	//both empty
	
	//user name empty
	
	//password empty
	
	//incorrect user username
	
	//incorrect password	
	
}

package com.dyt.hrm.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.utilities.Reporter;
import com.dyt.utilities.WebControls;

public class Home extends WebControls{

	//========= Home page WebElements ========================
	@FindBy(xpath="//h1[text()='Dashboard']")
	public static WebElement labelDashboard;
	
	@FindBy(xpath="//span[text()='Apply Leave']")
	public static WebElement labelApplyLeave;
	
	@FindBy(xpath="//span[text()='My Leave']")
	public static WebElement labelMyLeave;
	
	@FindBy(xpath="//span[text()='My Timesheet']")
	public static WebElement labelMyTimesheet;
	
	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']")
	public static WebElement menuLeave;
	
	@FindBy(xpath="//a[@id='menu_leave_applyLeave']")
	public static WebElement submenuApply;
	
	@FindBy(xpath="//a[@id='menu_leave_viewMyLeaveList']")
	public static WebElement submenuMyLeave;	
	
	@FindBy(xpath="//a[@id='menu_pim_viewMyDetails']")
	public static WebElement menuMyInfo;
	
	
	//========= Home page methods ========================
	public void pageDisplayed()
	{
		boolean retval;
		retval = isElementDisplayed(labelDashboard);
		Reporter.log(retval, "Home page displayed", "Home page not displayed");
	}
	
	public void HomePageElements()
	{
		
	}
	
	public void navApplyLeavePage()
	{
		boolean retval;
		retval = mouseHover(menuLeave);
		Reporter.log(retval, "Mouse hover to Leave menu successful", "Mouse hover to Leave menu unsuccessful");
		
		retval = clickElement(submenuApply);
		Reporter.log(retval, "Apply submenu option clicked", "Apply submenu option not clicked");
	}
	
	public void navMyLeavePage()
	{
		boolean retval;
		retval = mouseHover(menuLeave);
		Reporter.log(retval, "Mouse hover to Leave menu successful", "Mouse hover to Leave menu unsuccessful");
		
		retval = clickElement(submenuMyLeave);
		Reporter.log(retval, "MyLeave submenu option clicked", "MyLeave submenu option not clicked");
	}
	
	public void navMyInfoPage()
	{
		boolean retval;
		retval = clickElement(menuMyInfo);
		Reporter.log(retval, "MyInfo menu clicked", "MyInfo menu not clicked");
	}
	
	
	//======================================================
	
	
	
}

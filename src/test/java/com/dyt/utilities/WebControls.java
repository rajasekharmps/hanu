package com.dyt.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.dyt.hrm.config.Configuration;

/*
 * Class Name		: 	WebControls.java
 * Description		: 	It contains all generic methods to perform actions on elements and to verify elements status
 * Author			: 	DevelopYou Technologies
 * Date 			:	7th July 2020
 * Modified Date	:
 * Modified By 		:
 * Comments			:
 */
public class WebControls extends Configuration {
	//---------------------------Variables section----------------------------------
	
	
	
	//---------------------------Methods section------------------------------------
	
	/*
	 * Method Name			: 	clickElement
	 * Description			: 	To click on any element on the page
	 * Input Parameter(s)	:	element -> WebElement on which click action need to be perform
	 * Return value			:	boolean value - true/false. true-> click action successful, false->unsuccessful
	 * Author				: 	DevelopYou Technologies
	 * Date 				:	7th July 2020
	 * Modified Date		:
	 * Modified By 			:
	 * Comments				:
	 */
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
	//-------------------------------------------------------------------------------
	/*
	 * Method Name			: 	setEditValue
	 * Description			: 	To set value to text box
	 * Input Parameter(s)	:	element -> WebElement on which senkeys action need to be performed
	 * 							value -> input value to textbox
	 * Return value			:	boolean value - true/false. true-> successful, false-> unsuccessful
	 * Author				: 	DevelopYou Technologies
	 * Date 				:	7th July 2020
	 * Modified Date		:
	 * Modified By 			:
	 * Comments				:
	 */
	public static boolean setEditValue(WebElement element, String value) 
	{
		boolean staus = true;
		try {
			element.sendKeys(value);
			String editValue = element.getAttribute("value");
			if(!value.equals(editValue)) staus = false;							
		}
		
		catch(Exception e) {
			staus = false;
		}		
		return staus;
	}
	//---------------------------------------------------------------
	//Select drop down text by visible text
		public static  boolean selectItemWithText(WebElement element, String visibleText)
		{
			boolean status = true;
			try
			{
				Select selItem = new Select(element);
				selItem.selectByVisibleText(visibleText);
			}
			catch(Exception e) {
				status = false;
			}
			return status;
		}	
		//---------------------------------------------------------------
		//Select drop down text by index
		public static  boolean selectItemWithIndex(WebElement element, int index)
		{
			boolean status = true;
			try
			{
				Select selItem = new Select(element);
				selItem.selectByIndex(index);
			}
			catch(Exception e) {
				status = false;
			}
			return status;
		}	
		//---------------------------------------------------------------
		//Select drop down text by value
		public static  boolean selectItemWithValue(WebElement element, String value)
		{
			boolean status = true;
			try
			{
				Select selItem = new Select(element);
				selItem.selectByValue(value);
			}
			catch(Exception e) {
				status = false;
			}
			return status;
		}
		//---------------------------------------------------------------
		//Move from one element to another element
		public static boolean mouseHover(WebElement element) 
		{
			boolean status = true;
			try{
				Actions actions = new Actions(driver);
				actions.moveToElement(element).build().perform();				
			}
			catch(Exception e) {
				status = false;
			}
			return status;
		}
		//---------------------------------------------------------------
		//Display the visible text of the element
		public static String getElementText(WebElement element)
		{
			String elementText = null;
			try {
				elementText = element.getText();				
			}
			catch(Exception e) {
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return elementText;
		}
		//---------------------------------------------------------------
		public static boolean verifyText(WebElement element, String text)
		{
			boolean status = true;
			try {
				String appText = element.getText();
				if(!appText.equals(text)) status = false;
			}
			catch(Exception e) {
				status = false;
			}
			return status;
		}
		//---------------------------------------------------------------
		//Display value of the attribute passed as parameter
		public static String getAtributeValue(WebElement element, String elementAttribute)
		{
			String retval = null;
			try 
			{
				retval = element.getAttribute(elementAttribute);				
			}
			catch(Exception e) {
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return retval;
		}
		//---------------------------------------------------------------		
		//verify selected element/ check box
		public static boolean isElementedSelected(WebElement element, boolean exp)
		{
			boolean status = true;
			try 
			{
				boolean appStatus = element.isSelected();
				if (appStatus != exp) status = false;
			}
			catch(Exception e) {
				status = false;
			}
			return status;
		}		
		//---------------------------------------------------------------
	
	
}

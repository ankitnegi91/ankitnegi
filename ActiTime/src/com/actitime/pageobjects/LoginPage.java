package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(name="username")
	private WebElement untxbx;

	@FindBy(name="pwd")
	private WebElement pwdtxbx;
	
	@FindBy(id="loginButton")
	private WebElement loginbtn;
	
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid.')]")
	private WebElement invalidLoginMsg;
	
	 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*login method */
	public void login(String username, String password)
	{
		untxbx.sendKeys(username);
		pwdtxbx.sendKeys(password);
		loginbtn.click();		
	}
	
	/* invalid verify*/
	public void verifyInvalidLoginMsg()
	{	
//		Assert.assertTrue(invalidLoginMsg.isDisplayed());
//		Reporter.log("invalid login is verified",true);
		String expMsg ="Username or Password is invalid. Please try again.";
		String actMsg=invalidLoginMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log("invalid login msg is verified",true);
		
	
	
	}
	
	
	
	
	
}

package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage{
	WebDriver driver;
	
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		this.driver= driver;
	}
	
	
	public void verifyHomePageTitle()
	{
		String expTitle="actiTIME - Enter Time-Track";
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("home page title is verified",true);
	}

	 
}

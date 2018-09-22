package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage 
{
	
	@FindBy(css="img[src*='default-logo.png']")
	private WebElement logo;
	
	@FindBy(xpath="//div[contains(text(),'Tasks')]")
	private WebElement task;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogo()
	{
		Assert.assertTrue(logo.isDisplayed());
	}
	
	
	
	public void clickOnTasks()
	{
		task.click();
	}
	
	
	public void logout()
	{
		logoutLink.click();
	}
	
	
	
}

package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTasksPage 
{
	@FindBy(linkText="Projects & Customers")
	private WebElement projNCustLink;
	
	@FindBy(css="input[value='Create New Tasks']")
	private WebElement createNwTasks;
	
	public  OpenTasksPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
	public void clickOnProjNCustLink()
		{
			 projNCustLink.click();
		}
	
	public void clickOnCreateNTask()
	{
		createNwTasks.click();
	}



}

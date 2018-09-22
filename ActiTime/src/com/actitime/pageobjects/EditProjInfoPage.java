package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProjInfoPage 
{
	
	@FindBy(css="input[value='Delete This Project']")
	private WebElement delThisProj;
	
	
	@FindBy(css="input[value='Delete Project']")
	private WebElement delProject;

	public void DeleteThisProj()
	{
		delThisProj.click();
		delProject.click();
	}
	
	 
	
	public EditProjInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}

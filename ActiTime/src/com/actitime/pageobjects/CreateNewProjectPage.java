package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjectPage 
{
	@FindBy(name="customerId")
	private WebElement selCustName;
	
	@FindBy(name="name")
	private WebElement projectName;
	
	@FindBy(css="input[value='Create Project']")
	private WebElement createProjBtn;
	
	 public CreateNewProjectPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	 
	 public void selCustName(String customerName)
	 {
		Select sel= new Select(selCustName);
		sel.selectByVisibleText(customerName);
	 }
	
	 public void projectName(String projName)
	 {
		 projectName.sendKeys(projName);
		 
	 }
	 
	 public void createProject()
	 {
		 createProjBtn.click();
	 }
	
	
	
}

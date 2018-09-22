package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjNCustPage extends BasePage
{
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustButn;
	
	@FindBy(className="successmsg")
	private WebElement successMsg;
	
	@FindBy(name="selectedCustomer")
	private WebElement customerDropdwn;
	
	@FindBy(css="input[value*='Show']")
	private WebElement showBtn;
	
	@FindBy(xpath="//td[contains(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private WebElement custNameLink;
	
	@FindBy(css="input[value='Create New Project']")
	private WebElement CreateNwProj;
	
	@FindBy(xpath="//td[contains(@id,'projectNameCell')]//a[contains(@href,'projectId')]")
	private WebElement projNameLink;
	//constructor
	public ActiveProjNCustPage(WebDriver driver)
	{	super(driver);
		PageFactory.initElements(driver,this);
	}
	
	//to click on create button
	public void clicOnCreateNewCustBtn()
	{
			createNewCustButn.click();
	}
	
	//to verify created customer
	public void verifyCreateCustMsg(String customerName)
	{
		//String expMsg="Customer \"GE HealthCare\" has been successfully created.";
		Assert.assertTrue(successMsg.isDisplayed());
		Assert.assertTrue(successMsg.getText().contains(customerName));
		Reporter.log(successMsg.getText(), true);
	}
	
	public void showCustomer(String customerName)
	{
		Select sel= new Select(customerDropdwn);
		sel.selectByVisibleText(customerName);
		showBtn.click();
		
		if(custNameLink.getText().equals(customerName))
		{
			custNameLink.click();
		}
		else
		{
			System.out.println(customerName+"  doesnot exist");
		}
	}
	
	
	public void verifyDeleteCustMsg()
	{
		String expMsg="Customer has been successfully deleted.";
		String actMsg=successMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(expMsg,true);
	}
	
	public void createnewProject()
	{
		CreateNwProj.click();
	}
	
	public void verifyCreateProjtMsg(String projName)
	{
		//String expMsg="Customer \"GE HealthCare\" has been successfully created.";
		Assert.assertTrue(successMsg.isDisplayed());
		Assert.assertTrue(successMsg.getText().contains(projName));
		Reporter.log(successMsg.getText(), true);
	}
	
	public void showProject(String customerName,String projName)
	{
		Select sel= new Select(customerDropdwn);
		sel.selectByVisibleText(customerName);
		showBtn.click();
		
		if(projNameLink.getText().equals(projName))
		{
			projNameLink.click();
		}
		else
		{
			System.out.println(projName+"  doesnot exist");
		}
	}
	
	public void verifyDelProjMsg()
	{
		String expMsg="Project has been successfully deleted.";
		String actMsg=successMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(expMsg,true);
	}
	
}

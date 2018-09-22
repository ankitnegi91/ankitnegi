package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiveProjNCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjectPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EditProjInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;

public class TaskTest extends BaseLib

{
	@Test(priority=1,enabled=true)
	public void createNewCustomer()
	{	String filepath="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(filepath, "Sheet1", 3,1);
		String password=ExcelUtilities.readData(filepath, "Sheet1", 3,2);		
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp= new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);
		apcp.clicOnCreateNewCustBtn();
		
		String customerName=ExcelUtilities.readData(filepath, "Sheet1", 3,3);
		CreateNewCustPage cncp= new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);
		apcp.verifyCreateCustMsg(customerName);
		apcp.logout();
		
		
	}
	
	@Test(dependsOnMethods={"createNewCustomer"},enabled=false)
	public void deleteCustomer()
	{
		
		String filepath="./testdata/testdata.xlsx";
		String 	username= ExcelUtilities.readData(filepath, "Sheet1", 4, 1);
		String 	password= ExcelUtilities.readData(filepath, "Sheet1", 4, 2);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp = new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		String customerName= ExcelUtilities.readData(filepath, "Sheet1", 4, 3);
		ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);
		apcp.showCustomer(customerName);
		EditCustInfoPage ecip= new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		apcp.logout();
		
	}
	
	
	@Test(priority=2,enabled=true)
	public void createProject()
	{	String filepath="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(filepath, "Sheet1", 5, 1);
		String password=ExcelUtilities.readData(filepath, "Sheet1", 5, 2);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp= new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		ActiveProjNCustPage apcp = new ActiveProjNCustPage(driver);
		apcp.createnewProject();
		String customerName=ExcelUtilities.readData(filepath, "Sheet1", 5, 3);
		CreateNewProjectPage cnp= new CreateNewProjectPage(driver);
		cnp.selCustName(customerName);
		String projName=ExcelUtilities.readData(filepath, "Sheet1", 5, 4);
		cnp.projectName(projName);
		cnp.createProject();
		apcp.verifyCreateCustMsg(projName);
		apcp.logout();
		
	}
	
	@Test(priority=3)
	public void delProject()
	{	String filepath="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(filepath, "Sheet1", 6, 1);
		String password=ExcelUtilities.readData(filepath, "Sheet1", 6, 2);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp= new OpenTasksPage(driver);
		otp.clickOnProjNCustLink();
		String customerName= ExcelUtilities.readData(filepath, "Sheet1", 6, 3);
		ActiveProjNCustPage apcp= new ActiveProjNCustPage(driver);
		String projName=ExcelUtilities.readData(filepath, "Sheet1", 6, 4);
		apcp.showProject(customerName, projName);
		EditProjInfoPage epip= new EditProjInfoPage(driver);
		epip.DeleteThisProj();
		apcp.verifyDelProjMsg();
		apcp.logout();		
	}
	
	
	
	
	
	
	
}

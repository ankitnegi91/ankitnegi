package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib
{
	@Test(priority =1,enabled=false)
	public void validLogin()
	{	//String filePath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filePath,"Sheet1", 1, 1);
		String password=ExcelUtilities.readData(filePath,"Sheet1", 1, 2);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.verifyLogo();
		ettp.verifyHomePageTitle();
		//"jnj"
		
	}
	
	@Test(priority =2)
	public void invalidLogin()
	{	//String filePath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filePath,"Sheet1", 2, 1);
		String password=ExcelUtilities.readData(filePath,"Sheet1", 2, 2);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		lp.verifyInvalidLoginMsg();
		
		
	}
	

	
	
}

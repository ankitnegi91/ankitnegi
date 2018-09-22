package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib 
{
	WebDriver driver;
	/**************Constructor************************************/
	public WaitStatementLib(WebDriver driver)
	{
		this.driver = driver;
	}
	/*****************Hardcode Wait*************************************/
	 
	public void iSleep(int secs)
	{
		try 
		{
			Thread.sleep(secs*1000);
		}
		catch (InterruptedException e) 
		{
	 		e.printStackTrace();
		}
	}
	
	/******************Implicit Wait***********************************************/
	public void iWaitForSeconds(int secs)
	{
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	/***********************Explicit Wait***************************************************/
	public void eWaitForVisible(int secs, WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/***************************Explicit Wait (Refresh)****************************************/
	public void eRefresh(int secs, WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
	}
	
}

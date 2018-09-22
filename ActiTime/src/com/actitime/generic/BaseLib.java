package com.actitime.generic;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib 
{
	
	public static String filePath="./testdata/testdata.xlsx";
	public WebDriver driver;//global driver in this framework
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public void setUp(String browserName, String url)
	{
		if (browserName.equalsIgnoreCase("firefox"))
		  {	  
			  System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			  
			  //to remove red logs from console and move it to any text file.
			  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			  
			  //firefox profiling	
			  FirefoxOptions options = new FirefoxOptions();
			  ProfilesIni allprof= new ProfilesIni();
			  FirefoxProfile fp= allprof.getProfile("Sel");
			  options.setProfile(fp);
			  
			  //remove web notifications
			  fp.setPreference("dom.webnotifications.enable",false);
			  
			  //certificate issue
			  fp.setAcceptUntrustedCertificates(true);
			  fp.setAssumeUntrustedCertificateIssuer(false);
			  
			  //page load strategy: fill the details before loading whole page=eager
			  options.setPageLoadStrategy(PageLoadStrategy.NONE);
			  driver= new FirefoxDriver();
			  Reporter.log("Launched", true);
			  
			  
			  
		  }
	  else if(browserName.equalsIgnoreCase("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			  System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");//logs disable and write in log file
			 
			  Map<String, Object> prefs = new HashMap<String, Object>();
			  prefs.put("profile.default_content_setting_values.notifications", 2);
			  ChromeOptions options = new ChromeOptions();
			  options.setExperimentalOption("prefs", prefs);
			  options.addArguments("disable-infobars");
			  driver= new ChromeDriver(options);
			  Reporter.log("Chrome Launched", true);
		  }
			   
	  else if(browserName.equalsIgnoreCase("ie"))
		  {		//zoom levl=100, protected mode turn off, security setting> allow active content
		 
			  System.setProperty("webdriver.ie.driver", "./exefiles/ieDriverServer.exe");
			  driver= new InternetExplorerDriver();
			  Reporter.log("IE Launched", true);
		  }
			  
	  else if(browserName.equalsIgnoreCase("edge"))
		  {
			  System.setProperty("webdriver.edge.driver", "./exefiles/MicrosoftWebDriver.exe");
			  driver= new EdgeDriver();
			  Reporter.log("Edge Launched", true);
		  }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		Reporter.log(url+"url navigated", true);
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{	
		String scriptName = result.getMethod().getMethodName();
		
		if (result.isSuccess())//true-->Pass
		{
			Reporter.log(scriptName+"  script is pass ", true);
		}
		else //false
		{
			Reporter.log(scriptName +" script is fail ", false);
			ScreenshotLib slib = new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
			Reporter.log("screenshot has been taken", true);
			
			
		}	
		driver.close();
		Reporter.log("Browser Closed", true);
		
		
	}
	
	
	
	
	
	
	
}

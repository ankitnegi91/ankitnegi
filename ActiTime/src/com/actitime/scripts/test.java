package com.actitime.scripts;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class test {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

	 System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
	  System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");//logs disable and write in log file
	  ChromeDriver driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.rediffmail.com");
	 List<WebElement> ls = driver.findElements(By.xpath("//a"));
	 for(int i=0; i<ls.size();i++)
	 {Iterator<WebElement> ss = ls.iterator();
	 WebElement aa = ss.next();
	 System.out.println(aa.getText());
	 
		 	/*String xx = ls.get(i).getText();
		 	System.out.println(xx);*/
	 }
 	/*
	String filepath="./testdata/testdata.xlsx";
	File f = new File(filepath);
	FileInputStream ifs = new FileInputStream(f);
	  Workbook wb = WorkbookFactory.create(ifs);
	  Sheet sh = wb.getSheet("Sheet1");
	String xx = sh.getRow(1).getCell(1).getStringCellValue();
	System.out.println(sh.getLastRowNum());
	  Row rw = sh.getRow(0);
	  System.out.println(xx);
	  Cell cl = rw.getCell(0);
	 System.out.println(sh.getSheetName());
	*/  
	  
	   
 	
}
}

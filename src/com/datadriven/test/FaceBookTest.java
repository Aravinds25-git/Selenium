package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil_DataProvider;

public class FaceBookTest {
	
	WebDriver driver;

	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		}
	
	@DataProvider
	 public Iterator<Object[]> getData()
	 {
		ArrayList<Object[]> data=TestUtil_DataProvider.getDataFromExcel();
		return data.iterator();
	 }
	
	@Test(dataProvider="getData")
	public void FacebookReg(String firstname, String Surname, String MobileNumber, String Password)
	{
		driver.findElement(By.id("u_0_l")).clear();
		driver.findElement(By.id("u_0_l")).sendKeys(firstname);
		
		driver.findElement(By.id("u_0_n")).clear();
		driver.findElement(By.id("u_0_n")).sendKeys(Surname);
		
		driver.findElement(By.id("u_0_q")).clear();
		driver.findElement(By.id("u_0_q")).sendKeys(MobileNumber);
		
		driver.findElement(By.id("u_0_x")).clear();
		driver.findElement(By.id("u_0_x")).sendKeys(Password);
	}

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}
 package TestNGBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotation {
	
	//Order of execution
	//1.Suite
	//2.Test
	//3.Class
	//4.Method---it will execute before and after each for each test
	
	@BeforeSuite
	public void Setup() {
		System.out.println("setup the browser");
	}

	@BeforeTest
	public void LaunchBrowser() {
		System.out.println("Launch the Browser");
	}
	
	@BeforeClass
	public void LaunchURL() {
		System.out.println("Launch URL");
	}
	@BeforeMethod
	public void Login()
	{
		System.out.println("Login");
	}
	@Test
	public void GoogleTitle()
	{
		System.out.println("Google title test");
	}
	@Test
	public void AGoogleSearch()
	{
		System.out.println("Search test");
	}
	
	@AfterMethod
	public void LogOut()
	{
		System.out.println("LogOut");
	}
	@AfterClass
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	@AfterTest
	public void Close()
	{
		System.out.println("Close the browser");
	}
	
	@AfterSuite
	public void GenerateReport()
	{
		System.out.println("GenerateReport");
	}
}

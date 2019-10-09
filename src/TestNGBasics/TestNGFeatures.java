package TestNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGFeatures {

	//1.priority
	//2.grouping
	WebDriver driver;
	
	@BeforeMethod
	public void launchUrl()
	{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.google.com");
	}	
	
	@Test(priority=2,groups="login")
	public void test()
	{
		System.out.println("test1");
	}
	
	@Test(priority=3,groups="login")
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test(priority=1,groups="logout")
	public void test3()
	{
		System.out.println("test3");
	}
	
	@AfterMethod()
	public void closeBrowser()
	{
		driver.close();
	}
}

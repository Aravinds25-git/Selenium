package TestNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertTestNG {

	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	}
	
	@Test
	public void GoogleTitle()
	{
		String title=driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Google","text failed");
	}
	
	@Test
	public void logo()
	{
		boolean b= driver.findElement(By.xpath("//*[@id=\"hplogo\"]/a/img")).isDisplayed();
		Assert.assertTrue(b);
		Assert.assertEquals(b,true);
	}
	
	@AfterMethod
	
		public void close()
		{
		driver.close();	
		}
	
}

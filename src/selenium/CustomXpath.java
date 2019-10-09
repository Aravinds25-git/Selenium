package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	
		//DynamicWAIT
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com/");
		//absolute xpath 
		//1.performance issue
		//2.not reliable
		//3.can be changed at anytime in future
		
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input ui-autocomplete-loading']")).sendKeys("English");
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Aravind");
		
		//*****Contain**********
		
		//driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete')]")).sendKeys("xyz");
		
		//*******starts-with******
		//driver.findElement(By.xpath("//input[starts-with(@class,'gh-tb ui-autocomplete')]")).sendKeys("xyz");
		
		//*******ends-with********
		//driver.findElement(By.xpath("//input[ends-with(@id,'ac')]")).sendKeys("jhsn");
		
		//tagname
		//driver.findElement(By.xpath("//a[contains(text(),'Advanced')]")).click();
		
	}

}

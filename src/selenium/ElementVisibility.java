package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibility {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/register/");
		
		//isDisplayed()---- for all the elements
		boolean b=driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b);//true
		
		//isEnabled()
		boolean b1=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b1);

		//selected the checkbox to enable the submit button
		driver.findElement(By. name("agreeTerms")).click();
				
		boolean b2=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);
		
		
		//isSelected()----radiobutton, dropdown, checkbox
		
		boolean b3=driver.findElement(By. name("agreeTerms")).isSelected();
		System.out.println("check box is"+b3);
		
		
		
		driver.close();
		
	}

}

package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		//HTML unit driver is not part of selenium 3.x jars.. only in 2.x
		//to use this concept have to downlaod htmlunit driver jar
		
		//Advantages
		//testing is happening behind the scene--no browser is launched
		//very fast--execution of testcases
		//not suitable for action class--mouse movement,double click,drag and drop
		//Ghost driver--headless browser
		
		
		
		
		WebDriver driver=new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());//before title
		
		driver.findElement(By.name("email")).sendKeys("aravinds397@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("aravind@1");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println(driver.getTitle());///after title

	}

}

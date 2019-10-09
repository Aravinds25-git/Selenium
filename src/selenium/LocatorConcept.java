package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//1.xpath--2nd priority
		//absolute--not a good.. the position might change
		driver.findElement(By.xpath("//*[@id=\"u_0_l\"]")).sendKeys("aravind");
		
		//2.id--1st priority
		driver.findElement(By.id("u_0_n")).sendKeys("shanmugavel");
		
		//3.classname---not a good practise or useful
		//driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("9715566940");
		
		//4.name// 2nd priority
		//driver.findElement(By.name("reg_passwd__")).sendKeys("aravi@123");
		
		//5.linktext---only for links---3rd priority
		//driver.findElement(By.linkText("Create a Page")).click();
		
		//6.partiallinktext---4th priority
		//driver.findElement(By.partialLinkText("Cookie")).click();
		
		//7.CssSelector--2nd priority
		//for id --#{id}
		//for class--.{class}
		driver.findElement(By.cssSelector("#u_0_x")).sendKeys("kdjjf");
	}

}

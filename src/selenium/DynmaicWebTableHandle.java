package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynmaicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("aravinds25");
		driver.findElement(By.name("password")).sendKeys("aravind@1");
		//driver.findElement(By.className("btn btn-small")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		driver.switchTo().frame("mainpanel");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		//driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a")).click();
		
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		
		//How to handle dynamic web table
		//1.by using for loop
		String before_xpath="//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String after_xpath="]/td[2]/a";
		
		
		/*for (int i=4;i<=8;i++)
		{
			String text=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			if (text.contains("john psa"))
			{
				driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[6]/td[1]/input")).click();
				driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[6]/td[5]")).click();
				driver.findElement(By.cssSelector("#vContactsForm > table > tbody > tr:nth-child(6) > td:nth-child(5) > input.select")).sendKeys("9715566430");
			}
		}*/
		
		//by using custom xpath
		
		driver.findElement(By.xpath("//a[contains(text(),'naveenk sss')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		

	}

}

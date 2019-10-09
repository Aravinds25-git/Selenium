package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		System.out.println(alert.getClass());
		
		String s=alert.getText();
		if (s.equals("Please enter a valid user name"))
		{
			System.out.println("Pass");
		}
		else {
			System.out.println("Pass");
		}
		alert.accept();
		//alert.dismiss--- to cancel the alert
	}

}

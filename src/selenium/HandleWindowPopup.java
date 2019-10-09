package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\ADMIN\\\\\\\\Downloads\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.findElement(By.xpath("/html/body/p/a")).click();
		driver.findElement(By.name("emailid")).sendKeys("aravinds197@gmail.com");
		driver.findElement(By.linkText("Click Here")).click();
		
		Set <String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		String ParentWindow=it.next();
		
		System.out.println("Parent Window Id is "+ParentWindow);
		
		String ChildWindow1=it.next();
		
		System.out.println("Child window 1 is "+ChildWindow1);
		
		String ChildWindow2=it.next();
		System.out.println("Child window 2 is "+ChildWindow2);
		
		driver.switchTo().window(ChildWindow1);
		
		driver.findElement(By.name("emailid")).sendKeys("aravinds197@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.switchTo().window(ChildWindow2);
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getTitle());
	}

}

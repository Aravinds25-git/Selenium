package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendar_JS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.spicejet.com");
		WebElement date=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
		String dateVal="28-08-2019";
		Thread.sleep(2000);
		selectDateByJS(driver, date, dateVal);

	}


	public static void selectDateByJS(WebDriver driver , WebElement element, String dateVal)
	{
		JavascriptExecutor Js=((JavascriptExecutor)driver);
		Js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}
	
}


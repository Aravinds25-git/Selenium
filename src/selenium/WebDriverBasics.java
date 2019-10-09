package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.Gecko
		//System.setProperty("webdriver.gecko.driver", "")
		//WebDriver driver=new FirefoxDriver();
		
		
		//2.InternetExplorer
		//System.setProperty("webdriver.ie.driver", "");
		//WebDriver driver=new InternetExplorerDriver();
		//driver.get("www.google.com");
		
		
		//3.Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.get("http://www.google.com");
		
		String s=driver.getTitle();
		System.out.println(s);
		
		if (s.equals("Google"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.quit();//to quit the browser
		
	}

}

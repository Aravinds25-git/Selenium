package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream input=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\src\\selenium\\config.properties");
		
		prop.load(input);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String URL=prop.getProperty("url");
		System.out.println(URL);
		
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("mozila"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\gecko.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("internet explorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\ie.exe");
			driver=new ChromeDriver();
		}

		driver.get(URL);
		
		driver.findElement(By.id(prop.getProperty("firstname_id"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.name(prop.getProperty("number_name"))).sendKeys(prop.getProperty("number"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		
	}

}

package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.crm.qa.util.WaitUtil;
//import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
	public TestBase()
	{
	
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\FreeCRMtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_77\\chromedriver.exe");
			driver =new ChromeDriver();
			
		}
		
		else {
			System.out.println("browser is invalid");
		}
		e_driver=new EventFiringWebDriver(driver);
		//now create  object of EventListenerHandler to register it with EventFiringWebDriver
		//WebDriverEventListener eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		//driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitUtil.page_limit, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitUtil.implicit_limit, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
	
	//Screenshot
	public static void failed(String testMethodName)
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\FreeCRMtest\\ScreenShots\\Failed.jpg"+testMethodName+"_"+".jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

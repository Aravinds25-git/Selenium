package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techcanvass.com/examples/webtable.html");
		
		String Company_before_xpath="//*[@id=\"t01\"]/tbody/tr[";
		String Company_after_xpath="]/td[1]";
		
		String Make_before_xpath="//*[@id=\"t01\"]/tbody/tr[";
		String Make_after_xpath="]/td[2]";
		
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"t01\"]//tr"));
		int rowCount=rows.size();
		System.out.println(rowCount);
		
		//*[@id="t01"]/tbody/tr[2]/td[1]
		//*[@id="t01"]/tbody/tr[4]/td[1]
		
		//*[@id="t01"]/tbody/tr[2]/td[2]
		//*[@id="t01"]/tbody/tr[3]/td[2]
		
		Xls_Reader Reader=new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\Test_Data_Facebook.xlsx");
		if (!Reader.isSheetExist("WeTable"))
		{
			Reader.addSheet("WeTable");
			Reader.addColumn("WeTable", "Company");
			Reader.addColumn("WeTable", "Make");
		}
		
		
		
		for (int i=2;i<=rowCount;i++)
		{
			String actual_xpath=Company_before_xpath+i+Company_after_xpath;
			String actual_xpath2=Make_before_xpath+i+Make_after_xpath;
			String text=driver.findElement(By.xpath(actual_xpath)).getText();
			String text2=driver.findElement(By.xpath(actual_xpath2)).getText();
			System.out.println(text);
			System.out.println(text2);
			
			
			Reader.setCellData("WeTable","Company", i,text);
			Reader.setCellData("WeTable", "Make", i, text2);
			
			
			
		}
		
		
		

	}

}

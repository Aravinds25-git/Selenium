package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class Datadriven {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		Xls_Reader reader=new Xls_Reader("C:\\Users\\ADMIN\\eclipse-workspace\\Selenium\\Test_Data_Facebook.xlsx");
		
		/*String firstname=reader.getCellData("Sheet1","Firstname",2);
		System.out.println(firstname);
		
		String Surname=reader.getCellData("Sheet1","Surname",2);
		System.out.println(Surname);
		
		String MobileNumber=reader.getCellData("Sheet1","MobileNumber",3);
		System.out.println(MobileNumber);
		
		String Password=reader.getCellData("Sheet1","Password",2);
		System.out.println(Password);*/
		
		int RowCount=reader.getRowCount("Sheet1");
		System.out.println(RowCount);
		//reader.addColumn("Sheet1","Dummy");
		
		for (int RowNum=2;RowNum<=RowCount;RowNum++)
		{
		String firstname=reader.getCellData("Sheet1","Firstname",RowNum);
		System.out.println(firstname);
		String Surname=reader.getCellData("Sheet1","Surname",RowNum);
		System.out.println(Surname);
		String MobileNumber=reader.getCellData("Sheet1","MobileNumber",RowNum);
		System.out.println(MobileNumber);
		//int result = Integer.parseInt(MobileNumber);
		//System.out.println(MobileNumber);
		String Password=reader.getCellData("Sheet1","Password",RowNum);
		System.out.println(MobileNumber);
		
		driver.findElement(By.id("u_0_l")).clear();
		driver.findElement(By.id("u_0_l")).sendKeys(firstname);
		
		driver.findElement(By.id("u_0_n")).clear();
		driver.findElement(By.id("u_0_n")).sendKeys(Surname);
		
		driver.findElement(By.id("u_0_q")).clear();
		driver.findElement(By.id("u_0_q")).sendKeys(MobileNumber);
		
		driver.findElement(By.id("u_0_x")).clear();
		driver.findElement(By.id("u_0_x")).sendKeys(Password);
		
	//	reader.setCellData("Sheet1", "Dummy",RowNum ,"PASS");//write data into cell
		
		}
		
	}

}

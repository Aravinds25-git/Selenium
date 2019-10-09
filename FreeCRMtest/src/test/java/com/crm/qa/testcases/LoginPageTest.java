package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	Homepage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void CRMtitletest()
	{
		String title=loginpage.validateLoginTitle();
		System.out.println(title);
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	@Test(priority=2)
	public void CRMImageTest()
	{
		boolean flag=loginpage.CRMimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest()
	{
		homepage=loginpage.ValidateLogin();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
 
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.WaitUtil;
@Listeners(CustomListener.class)
public class HomePageTest extends Homepage {

	Homepage homepage;
	LoginPage loginpage;
	WaitUtil TestUtil;
	ContactsPage contactspage;
	DealsPage dealspage;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		TestUtil=new WaitUtil();
		LoginPage loginpage=new LoginPage();	
		homepage=loginpage.ValidateLogin();
		
	}
	
	@Test(priority=1)
	public void UsernameLabelTest() {
		TestUtil.framehandle();
		Assert.assertTrue(homepage.ValidateUserNameLabel());
	}
	
	@Test(priority=2)
	public void ContactsLinkTest()
	{
		TestUtil.framehandle();
		contactspage=homepage.ValidateContactsLink();
	}
	
	@Test(priority=3)
	public void DealsLinkTest()
	{
		TestUtil.framehandle();
		dealspage=homepage.ValidateDealsLink();
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

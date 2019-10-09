package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.WaitUtil;
@Listeners(CustomListener.class)
public class ContactsPageTest extends TestBase{
	
	ContactsPage contactspage;
	Homepage homepage;
	LoginPage loginpage;
	WaitUtil TestUtil;
	String sheetName="Sheet1";
	
	public ContactsPageTest()
	{
		super();
	}

	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		TestUtil=new WaitUtil();
		contactspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.ValidateLogin();
		TestUtil.framehandle();
		homepage.ValidateContactsLink();
	}
	
	@Test(priority=1)
	public void ContactsLabelTest()
	{
		Assert.assertTrue(contactspage.ContactsLabel());
	}
	
	@Test(priority=2)
	public void SelectContactsTest()
	{
		contactspage.selectContactsByName("john psa");
	}
	
	/*@Test
	public void failure()
	{
		Assert.assertEquals(true, false);
	}
	
	/*@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=WaitUtil.getTestData(sheetName);
		return data;	
		
	}
	
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void ValidateCreateContact(String title,String firstname, String lastname,String company)
	{
		homepage.NewContactLink();	
		//contactspage.createNewContact("Mr.", "Ms", "Dhoni", "BCCI");
		contactspage.createNewContact(title, firstname, lastname, company);
		
	}*/
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

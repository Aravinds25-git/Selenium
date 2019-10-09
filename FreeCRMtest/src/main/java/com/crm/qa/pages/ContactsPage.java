package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.CustomListener;
public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement ContactsText;
	
	@FindBy(name="title")
	WebElement Title;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement Lastname;
	
	@FindBy(name="client_lookup")
	WebElement Company;

	@FindBy(xpath="//input [@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
	//Initializing the page objects
	 public ContactsPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public boolean ContactsLabel()
	 {
		 return ContactsText.isDisplayed();
	 }
	 
	 public void selectContactsByName(String name)
	 {
		 driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	 }
	 	 
	 public void createNewContact(String title,String fname, String lname, String company)
	 {
		 Select select =new Select(Title);
		 select.selectByVisibleText(title);;
		 
		 FirstName.sendKeys(fname);
		 Lastname.sendKeys(lname);
		 Company.sendKeys(company);
		 
		 SaveBtn.click();
		 
		 
	 }
}

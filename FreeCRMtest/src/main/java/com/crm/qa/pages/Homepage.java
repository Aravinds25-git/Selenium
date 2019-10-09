package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.CustomListener;

public class Homepage extends TestBase{
	
	//PageFactory
	@FindBy(xpath="//td[contains(text(),'User: Aravind Shanmugavel')]")
	WebElement usernameLabel;
	
	
	@FindBy(xpath="//a [contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a [contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="//a [contains(text(),'Tasks')]")
	WebElement tasks;
	
	@FindBy(xpath="//a [contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public boolean ValidateUserNameLabel()
	{
		
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage ValidateContactsLink()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage ValidateDealsLink()
	{
		deals.click();
		return new DealsPage(); 
	}
	
	public TasksPage ValidateTasksLink()
	{
		tasks.click();
		return new TasksPage();
	}
	
	public void NewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contacts).build().perform();
		NewContactLink.click();
	}
	
}

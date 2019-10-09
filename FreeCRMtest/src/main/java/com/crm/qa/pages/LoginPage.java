package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.WaitUtil;

public class LoginPage extends TestBase {
	
	
	//PageFactory or OR
	WaitUtil wait=new WaitUtil();
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input [contains(@type,'submit')]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement TitleLogo;
	
	//Actions
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginTitle()
	{
		return driver.getTitle();
	}

	public boolean CRMimage()
	{
		return TitleLogo.isDisplayed();
	}
	
	
	public Homepage ValidateLogin()
	{
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		wait.clickOn(driver,LoginBtn, 20);
		//LoginBtn.click();
		return new Homepage();
	}
	
	
}

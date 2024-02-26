package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;// here ldriver means local driver
	
	public LoginPage(WebDriver rdriver){ //here rdriver means remote driver
	
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(name="uid")
	WebElement txtuser;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		txtuser.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
		
	}
	
	public void clickSubmit() {
	loginButton.click();
		
	}
	public void clickLogout() {
		lnkLogout.click();
		
		
	}
	

}

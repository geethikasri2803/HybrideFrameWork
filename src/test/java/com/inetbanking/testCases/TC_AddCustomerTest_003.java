package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Geethikasri");
		addcust.custgender("Female");
		Thread.sleep(3000);
		addcust.custdob("28", "03","2022");
		addcust.custaddress("bheemgal");
		addcust.custcity("Nizamabad");
		addcust.custstate("Telanagana");
		addcust.custpinno("5000025");
		addcust.custtelephoneno("7780145481");
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("validation started here.....");
		boolean res=driver.getPageSource().contains("Customer registered successfully");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else {
			logger.info("test case failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}

	
	

}

package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass {
	@Test
	public void loginTest() {
		logger.info("url is entered");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("test is passed");
			}else {
				Assert.assertFalse(false);
				logger.info("test is failed");
				}
		}
	
		
	}

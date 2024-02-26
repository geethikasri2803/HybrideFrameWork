package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name");
		lp.setPassword(pwd);
		logger.info("user password");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();//this will close the logout alert
			driver.switchTo().defaultContent();
		}
		
	}//below method endhukante oka vela login succeess aithe logout kavadaniki notification box vasthundhi so.
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="loginData")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
			
			String loginData[][]=new String [rownum][colcount];
			for(int i=1;i<=rownum;i++) {
				for(int j=0;j<colcount;j++) {
					loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0
				}
				}
			return loginData;
			}}
			
			
	



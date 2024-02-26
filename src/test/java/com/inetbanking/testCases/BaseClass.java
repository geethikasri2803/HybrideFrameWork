package com.inetbanking.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String userName=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static org.apache.logging.log4j.Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
	logger=LogManager.getLogger("ebanking");
		//PropertyConfigurator.configure("log4j.properties");
	if(br.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	 driver=new ChromeDriver();
	 logger.info("chrome executed successfully");
	}
	else if(br.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxPath());
		 driver=new FirefoxDriver();
		 logger.info("Firefox executed successfully");
	}
	else if(br.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		 driver=new InternetExplorerDriver();
		 logger.info("IE executed successfully");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(baseURL);
	
	}
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		logger.info("All browsers closed successfully");
	}
public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}

	public String randomestring() {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		
		return (generatedstring);
	}
	public static String randomeNum() {
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}


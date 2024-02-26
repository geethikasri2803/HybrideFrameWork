package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties prop;
	
public ReadConfig(){
	File src=new File("./Configurations/config.properties");
	try {
		FileInputStream fis=new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);
	}catch(Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
		
	}

//confi.properties lo prathi object indhylo manam methods ni create cheyyali

public String getApplicationURL() {
	String url=prop.getProperty("baseURL");
	return url;
	
}
public String getUsername() {
	String username=prop.getProperty("username");
	return username;
	
}
public String getPassword() {
	String password=prop.getProperty("password");
	return password;
	
}
public String getChromePath() {
	String chromepath=prop.getProperty("chromepath");
	return chromepath;
}
public String getIEPath() {
	String iepath=prop.getProperty("iepath");
	return iepath;
	
}
public String getFirefoxPath() {
	String firefoxpath=prop.getProperty("firefoxpath");
	return firefoxpath;
}


}

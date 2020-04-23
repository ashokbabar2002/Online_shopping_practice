package com.onlineshopping.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.onlineshopping.utilities.*;

public class ReadConfig {
	
	public static Properties prop;
	public static FileInputStream fis ;
	{
	
	 try {
		fis = new FileInputStream("C:\\Users\\SHREE\\eclipse-workspace\\onlineshopping_POC\\configurations\\config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// create Properties class object to access properties file
	 prop = new Properties();
	// load the properties file
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TOD""O Auto-generated catch block
		e.printStackTrace();
	}
	// get the property of "url" using getProperty()
	System.out.println("url in the properties files is "+prop.getProperty("URL"));
	//System.out.println(prop.getProperty("author"));
	// get the property of "url" using ge//t()
	//System.out.println(prop.get("user"));
	}
	
}


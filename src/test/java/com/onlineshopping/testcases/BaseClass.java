package com.onlineshopping.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;
import com.onlineshopping.testData.PageTestConstants;
import com.onlineshopping.utilities.ReadConfig;
import com.onlineshopping.utilities.Reporting;
import com.onlineshopping.utilities.SendEmailReport;

public class BaseClass {

	public static ReadConfig RdConfig = new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;
	public static ReadConfig Rd;
	public static String url;
	public static WebDriverWait wait;
	int timeOutInSeconds = 120;
	public static PageTestConstants pageConstas;
	public static SendEmailReport semail;
	public static Reporting report;

	@BeforeClass
	public void setup() {
		// logger.info(" m in before class");
		// Rd = new ReadConfig();
		pageConstas = new PageTestConstants();
		url = ReadConfig.prop.getProperty("URL");
		System.out.println("url fetched from properties is  " + url);
		String browsername = ReadConfig.prop.getProperty("browser");
		System.out.println("In setup method");

		String path = System.getProperty("user.dir");
		System.out.println(path);

		if (browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser launched" + driver);
		} else if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Firefox Browser launched");
		}
		wait = new WebDriverWait(driver, timeOutInSeconds);
		logger = Logger.getLogger("onlineshopping");
		logger.info("logs in Baseclass");
		// PropertyConfigurator.configure("log4j.properties");
	}

	@AfterClass
	public void teardown() {
		driver.close();
		// semail = new SendEmailReport();
		// semail.sendemail();
	}

}

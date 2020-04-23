package com.onlineshopping.testcases;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.onlineshopping.PageObjects.*;
import com.onlineshopping.testcases.BaseClass;
import com.onlineshopping.utilities.*;

///import freemarker.template.utility.CaptureOutput;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Onlineshopping_LoginTest extends BaseClass {
	static WebDriverWait wait = null;

	@Test
	public static void login() throws Throwable {

		Logger log = Logger.getLogger("devpinoyLogger");

		driver.get(url);
		System.out.println("url launched " + url);
		driver.manage().window().maximize();
		// log.infoSystem.out.println("Clicked on Login button");

		LoginPage lp = new LoginPage(driver);

		lp.ClickLogin();
		System.out.println("Clicked on Login button");

		String username = ReadConfig.prop.getProperty("username");
		lp.txtEnterEmail(username);
		// log.info("username entered is :"+username);
		System.out.println("username entered is :" + username);

		String password = ReadConfig.prop.getProperty("password");
		log.info("password entered is :" + password);
		lp.txtEnterPwd(password);

		lp.ClickSignIn();
		System.out.println("Clicked on SignIn button");

		System.out.println("==================== Login done =======================");

		String Homepage_Title = driver.getTitle();
		System.out.println("Home Page title : " + Homepage_Title);

		if (Homepage_Title.contains("My Store")) {
			Assert.assertTrue(true);
			System.out.println("Login Test for online shopping passed");
		} else {
			Assert.assertTrue(false);
			// captureScreen(driver,"LoginTest");
			System.out.println("Login Test for online shopping failed");

		}
	}
}

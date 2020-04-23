package com.onlineshopping.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.onlineshopping.PageObjects.LoginPage;
//import com.onlineshopping.PageObjects.TShirtsPage;
import com.onlineshopping.PageObjects.WomensPage;
import com.onlineshopping.utilities.ReadConfig;

public class Onlineshopping_WomensPageTest extends BaseClass {

	static WebDriverWait wait = null;

	@Test
	public void WomensCatergory() throws Exception {
		driver.get(url);
		System.out.println("url launched " + url);

		LoginPage lp = new LoginPage(driver);
		// ReadConfig Rd = new ReadConfig();

		driver.manage().window().maximize();
		lp.ClickLogin();

		String username = ReadConfig.prop.getProperty("username");
		lp.txtEnterEmail(username);
		System.out.println("username is entered" + username);

		String password = ReadConfig.prop.getProperty("password");
		lp.txtEnterPwd(password);

		lp.ClickSignIn();
		System.out.println("Clicked on SignIn button");

		System.out.println("==================== Login done =======================");
		// System.out.println("Logged in successfully");

		Thread.sleep(5000);

		WomensPage tp = new WomensPage(driver);		
		tp.WomensTShirts();
		tp.SleevedTShirts();
		tp.AddToCart();

		String Title = driver.getTitle();
		System.out.println("Page tiltle is " + Title);

		if (Title.contains("Faded Short Sleeve T-shirts")) {
			Assert.assertTrue(true);
			System.out.println("Add_To_Cart Test passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("Add_To_Cart Test failed");
		}
	}
}

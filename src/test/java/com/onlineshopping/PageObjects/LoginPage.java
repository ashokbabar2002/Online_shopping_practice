package com.onlineshopping.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlineshopping.testcases.BaseClass;

public class LoginPage extends BaseClass{

	static WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) throws Exception{
		System.out.println("Inside login page class");
		ldriver= rdriver;
		System.out.println("driver in page object is "+ldriver);		
		PageFactory.initElements(rdriver, this);	
		Thread.sleep(5000);
	}
			
	@FindBy(xpath = "//a[@class='login']")
	WebElement Login;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement EnterEmail;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement EnterPassword;
	
	@FindBy(xpath = "//p[@class='submit']//span[1]")
	WebElement ClickSignIn;
	
	
	public void ClickLogin() {
		Login.click();
	}
	
	public void txtEnterEmail(String email) {
		EnterEmail.sendKeys(email);
	}	
	
	public void txtEnterPwd(String pwd) {
		EnterPassword.sendKeys(pwd);
	}	
	
	
	public void ClickSignIn() {
		ClickSignIn.click();
	}
	
}

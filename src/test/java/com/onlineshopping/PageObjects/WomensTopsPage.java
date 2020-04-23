package com.onlineshopping.PageObjects;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.onlineshopping.PageObjects.LoginPage;
import com.onlineshopping.testcases.BaseClass;

import okhttp3.internal.platform.ConscryptPlatform;

public class WomensTopsPage extends BaseClass {

	public WomensTopsPage(WebDriver rdriver) {
		System.out.println("Inside shopping page class");
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement TShirts;
	
	@FindBy(xpath = "//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Tops')]")
	WebElement TopsMenu;		
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement submit;	
	
	
	public void WomensTShirts() throws Exception {
		TShirts.click();
		Thread.sleep(5000);
	}	
	
	public void TopsMenu() throws Exception {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Tops')]")));
	TopsMenu.click();
    								 
	}
	
	public void AddToCart() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add to cart')]")));
		submit.click();
		//Thread.sleep(5000);
	}	
	
	
	}

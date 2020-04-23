package com.onlineshopping.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import com.onlineshopping.testcases.BaseClass;
import com.onlineshopping.testcases.Onlineshopping_LoginTest;

public class Test extends BaseClass {
	static WebDriver ldriver = null;
	
	public static void launch(WebDriver rdriver) throws Exception {
		System.out.println("m in test method");
		ldriver = rdriver;
		System.out.println("driver is "+ldriver);
		System.out.println("Hello");
		String url = "http://www.automationpractice.com/";
		ldriver.get(url);
		System.out.println("url launched " + url);
		logintoapp();
		
	}
	
	public static void logintoapp() throws Exception {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ashokbabar2002@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Shivansh&56789");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		womenmenu();
		
	}
	
	public static void womenmenu() throws Exception {
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		driver.findElement(By.xpath("//span[@class='grower CLOSE']")).click();
		Thread.sleep(5000);
		List<WebElement> listofTops =  driver.findElements(By.xpath("//div[@class='block_content']//ul[@class='tree dynamized']//span[@class='grower CLOSE']"));
		System.out.println("no of items under tops are "+listofTops.size());
		
		for(int i = 0;i<listofTops.size();i++){
			   System.out.println("index of webelements in increasing order is : " + i + listofTops.get(i).getText());  
		}
	}
	
	
	///https://www.uvdesk.com/en/blog/passing-data-dataprovider-excel-sheet-testng/ = data provider with testng
	
	
	public static void main(String args[]) throws Exception{  
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SHREE\\eclipse-workspace\\onlineshopping_POC\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();		
		System.out.println("r driver is "+driver);
		Test.launch(driver);
		
		System.out.println("in main method");
		System.out.println("driver in main method"+driver);
		
	     }
  
}

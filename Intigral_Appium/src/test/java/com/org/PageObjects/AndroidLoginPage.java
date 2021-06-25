package com.org.PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.org.Reusable.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidLoginPage {
	
	AppiumDriver<MobileElement> driver;
	Common common;
	
	public AndroidLoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		common = new Common(driver);
	}
	
	private static By UserName = By.id("test-Username");
	private static By Password = By.id("test-Password");
	private static By LoginBtn = By.id("test-LOGIN");
	private static By HomepageElement = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
	
	public void Login(String username, String password) {
		
		common.WaitforPresentofElement(UserName);
		driver.findElement(UserName).clear();
		driver.findElement(UserName).sendKeys(username);
		driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys(password);
		driver.findElement(LoginBtn).click();
	}
	
	public void AssertElementHomePage() throws InterruptedException {
		Thread.sleep(2000);
		boolean element = driver.findElement(HomepageElement).isDisplayed();
		Assert.assertEquals(element, true);
	}
	

}

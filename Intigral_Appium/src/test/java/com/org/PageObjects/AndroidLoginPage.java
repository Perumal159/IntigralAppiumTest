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
	
	private static String UserName = "test-Username";
	private static String Password = "test-Password";
	private static String LoginBtn = "test-LOGIN";
	private static By HomepageElement = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
	
	public void Login(String username, String password) throws InterruptedException {
		
//		common.WaitforPresentofElement(UserName);
		
//		driver.findElementByAccessibilityId(password);
		Thread.sleep(5000);
		driver.findElementByAccessibilityId(UserName).clear();
		driver.findElementByAccessibilityId(UserName).sendKeys(username);
		driver.findElementByAccessibilityId(Password).clear();
		driver.findElementByAccessibilityId(Password).sendKeys(password);
		driver.findElementByAccessibilityId(LoginBtn).click();
	}
	
	public void AssertElementHomePage() throws InterruptedException {
		Thread.sleep(2000);
		boolean element = driver.findElement(HomepageElement).isDisplayed();
		Assert.assertEquals(element, true);
	}
	

}

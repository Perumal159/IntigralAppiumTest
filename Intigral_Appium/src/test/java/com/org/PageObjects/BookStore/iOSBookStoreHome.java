package com.org.PageObjects.BookStore;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.org.Reusable.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class iOSBookStoreHome {
	
	AppiumDriver<MobileElement> driver;
	Common common;
	
	public iOSBookStoreHome(AppiumDriver<MobileElement> driver){
		this.driver =  driver;
		common = new Common(driver);
	}
	
	private static String FirstBook = "TypeScript Notes for Professionals";
	
	public void LoadnVerifyHomepage() {
		Assert.assertEquals(driver.findElementByName("ISBN-13: ").isDisplayed(), true);
		int noOfBooks = driver.findElementsByName("ISBN-13: ").size();
		System.out.println("---- Total noOfBooks ----"+noOfBooks);
	}
	
	public void ClickFirstBook() {
		driver.findElementByAccessibilityId(FirstBook).click();
		System.out.println("Clicked FirstBook");
	}

}

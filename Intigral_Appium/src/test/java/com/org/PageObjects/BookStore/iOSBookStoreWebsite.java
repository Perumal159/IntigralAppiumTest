package com.org.PageObjects.BookStore;

import com.org.Reusable.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class iOSBookStoreWebsite {
	
	AppiumDriver<MobileElement> driver;
	Common common;
	
	public iOSBookStoreWebsite(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		common = new Common(driver);
	}
	
	private static String Header = "TypeScript Notes for Professionals";
	
	public void VerifyPageHeader() {
		System.out.println("Header is --->"+driver.findElementByAccessibilityId(Header).getAttribute("name"));	
	}

}

package com.org.PageObjects.BookStore;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class iOSBookStoreBookDescription {
	
	AppiumDriver<MobileElement> driver;
	
	public iOSBookStoreBookDescription(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		
	}
	
	private static String BuyBookBtn = "Buy from BookStore";
	
	public void clickBuyBook() {
		driver.findElementByAccessibilityId(BuyBookBtn).click();
	}
	

}

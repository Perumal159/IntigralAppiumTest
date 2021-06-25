package com.org.Reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Common {
	
	protected AppiumDriver<MobileElement> driver;
	protected WebDriverWait wait;
	
	public Common(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	 
	
	public void WaitforPresentofElement(By Ele) {
		wait.until(ExpectedConditions.presenceOfElementLocated(Ele));
		System.out.println("Presence of Element Located");
	}

	
	
}

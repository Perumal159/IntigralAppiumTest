package com.org.Reusable;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.PointOption;

public class Common {
	
	protected static AppiumDriver<MobileElement> driver;
	protected WebDriverWait wait;
	
	public Common(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	 
	
	public void AndroidUIScrollable(String Containstext) {
		 MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true))" +
	                        ".scrollIntoView(new UiSelector().textContains(\"" + Containstext + "\"))"));
	}
	
	public void AndroidUIScrollable(MobileElement ele) {
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\""+ele+"\"))"));

	}
	
	public static PointOption CenterPoint() {
		
		Dimension WindowSize = driver.manage().window().getSize();
		
		PointOption PointOptionStart = PointOption.point(WindowSize.width/2,WindowSize.height/2);
		
		return PointOptionStart;
	}

	public PointOption swipeAction(String Dir) {
		
		PointOption PointOptionEnd = null;
		
		int edge = 10;
		
		Dimension WindowSize = driver.manage().window().getSize();
		
		
		switch (Dir) {
		
		case "Down":
			PointOptionEnd = PointOption.point(WindowSize.width/2,WindowSize.height-edge);
			break;
		
		case "Up":
			PointOptionEnd = PointOption.point(WindowSize.width/2,edge);
			break;
			
		case "Left":
			PointOptionEnd = PointOption.point(edge,WindowSize.height/2);
			break;
			
		case "Right":
			PointOptionEnd = PointOption.point(WindowSize.width-edge,WindowSize.height/2);
			break;
		
		}
		
		return PointOptionEnd;
	}
	
	public void WaitforPresentofElement(By Ele) {
		wait.until(ExpectedConditions.presenceOfElementLocated(Ele));
		System.out.println("Presence of Element Located");
	}

	
	
}

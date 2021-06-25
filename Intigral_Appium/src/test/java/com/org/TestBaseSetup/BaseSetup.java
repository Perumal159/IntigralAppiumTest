package com.org.TestBaseSetup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseSetup {

	private static AppiumDriver<MobileElement> driver;
	static DesiredCapabilities Caps;
	protected static String Platform;
	
	public AppiumDriver GetDriver() {
		return driver;
	}
	
public static AppiumDriver LaunchAndroidApp() throws MalformedURLException {
		
		Caps= new DesiredCapabilities();
		
		
		Caps.setCapability("platformName", "Android");
		Caps.setCapability("deviceName", "Android SDK built for x86");
		Caps.setCapability("udid", "emulator-5554");
		Caps.setCapability("platformVersion", "10");
		
		Caps.setCapability("appPackage", "com.swaglabsmobileapp");
		Caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url,Caps);
		
		System.out.println("Successfully launching Android ");
		
		return driver;
	}

	public static AppiumDriver LaunchIOSApp() throws MalformedURLException {
		
		Caps= new DesiredCapabilities();
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new IOSDriver<MobileElement>(url,Caps);
		
		System.out.println("Successfully launching IOS Appp");
		
		return driver;
		
	}
	
	public void initdriver(String Platform) throws MalformedURLException {
		switch (Platform) {
		case "Android":
			driver = LaunchAndroidApp();
			break;
		
		case "IOS":
			driver = LaunchIOSApp();
			break;
		
		}
	}
	
	@Parameters({"PlatformName"})
	@BeforeClass
	public void launchDriver(@Optional("Android") String PlatformName) {
		try {
			Platform = PlatformName;
			initdriver(PlatformName);
		} catch(Exception e) {
			System.out.println("Unable to launch driver");
			e.printStackTrace();
		}
	}
	
}

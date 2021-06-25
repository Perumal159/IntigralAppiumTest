package com.org.ExecutableTests;

import org.testng.annotations.Test;

import com.org.PageObjects.AndroidLoginPage;
import com.org.TestBaseSetup.BaseSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SwagEndtoEndTest extends BaseSetup{

	AppiumDriver<MobileElement> driver;



	@BeforeClass
	public void PreSetup() {
		driver = GetDriver();
		System.out.println("Opening Swag App on "+BaseSetup.Platform);
	}


	@Test(priority=0)
	public void LoginFailure() {
		if(BaseSetup.Platform.equals("Android")) {
			AndroidLoginPage ALP = new AndroidLoginPage(driver);


			ALP.Login("standard_user", "wrongPass");

		}
		else{
			//Runs IOS Test
		}
	}

	@Test(priority=1)
	public void LoginSuccess() throws InterruptedException  {

		if(BaseSetup.Platform.equals("Android")) {
			AndroidLoginPage ALP = new AndroidLoginPage(driver);


			ALP.Login("standard_user", "secret_sauce");
			ALP.AssertElementHomePage();

		}
		else{
			//Runs IOS Test
		}

	}
	



}

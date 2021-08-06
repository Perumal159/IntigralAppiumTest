package com.org.ExecutableTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.PageObjects.BookStore.iOSBookStoreBookDescription;
import com.org.PageObjects.BookStore.iOSBookStoreHome;
import com.org.PageObjects.BookStore.iOSBookStoreWebsite;
import com.org.Reusable.Common;
import com.org.TestBaseSetup.BaseSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BookStoreEndtoEnd extends BaseSetup{
	
	Common common;
	iOSBookStoreHome IBH;
	iOSBookStoreBookDescription IBBD;
	iOSBookStoreWebsite IBW;
	AppiumDriver<MobileElement> driver;
  
	@BeforeClass
	public void PreSetUp() {
		driver = GetDriver();
		common = new Common(driver);
		common.WaitforPageLoad(20);
		common.waitforAsyncScript(20);
		common.ImplicitTimeout(20);
		IBH = new iOSBookStoreHome(driver);
		IBBD = new iOSBookStoreBookDescription(driver);
		IBW = new iOSBookStoreWebsite(driver);
		
	}
	
	@Test
  public void LoadnVerifyHomePage() {
		if(Platform.contentEquals("Android")) {
			
		} else {
			
			IBH.LoadnVerifyHomepage();
		}
	}
	
	
	@Test
	public void PurchaseBookFromWebSite() {
		if(Platform.contentEquals("Android")) {
			
		} else {
			IBH.ClickFirstBook();
			IBBD.clickBuyBook();
			IBW.VerifyPageHeader();
		
	}
	}

}

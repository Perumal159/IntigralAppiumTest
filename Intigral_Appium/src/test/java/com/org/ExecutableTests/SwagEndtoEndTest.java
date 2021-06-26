package com.org.ExecutableTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.PageObjects.AndroidCheckoutPage;
import com.org.PageObjects.AndroidHomePage;
import com.org.PageObjects.AndroidLoginPage;
import com.org.TestBaseSetup.BaseSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

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
			System.out.println("Going to enter credentials");

			ALP.Login("standard_user", "secret_sauce");
			ALP.AssertElementHomePage();
			System.out.println("Home page loaded");
		}
		else{
			//Runs IOS Test
		}

	}
	
	@Test(priority=2)
	public void VerifyItemsPricenDescription() throws InterruptedException  {

		if(BaseSetup.Platform.equals("Android")) {
			AndroidHomePage AHP = new AndroidHomePage(driver);
			AHP.IdentifyElementDescriptionnPrice();
			
		}
		else{
			//Runs IOS Test
		}

	}
	
	@Test(priority=3)
	public void SuccessfullCheckoutWithaddnDelete() throws InterruptedException  {

		if(BaseSetup.Platform.equals("Android")) {
			AndroidHomePage AHP = new AndroidHomePage(driver);
			AndroidCheckoutPage ACP = new AndroidCheckoutPage(driver);
			AHP.Add3ItemstoCart();
			ACP.VerifyItemsinCart();
			ACP.RemoveItemfromcart();
			AHP.VerifyTheItemsAddedinHomepagenRemove();
			ACP.verifyRemainingItem();
			ACP.FinalCheckout();
		}
		else{
			//Runs IOS Test
		}

	}
	
	@Test(priority=4)
	public void VerifyZeroItemCheckout() throws InterruptedException  {

		if(BaseSetup.Platform.equals("Android")) {
			AndroidHomePage AHP = new AndroidHomePage(driver);
			AndroidCheckoutPage ACP = new AndroidCheckoutPage(driver);
			AHP.ClickCart();
			ACP.CheckoutWithErrorVerification();
			
		}
		else{
			//Runs IOS Test
		}

	}
	
	@Test(priority=5)
	public void VerifyserWithIssueProdName() throws InterruptedException  {

		if(BaseSetup.Platform.equals("Android")) {
			AndroidLoginPage ALP = new AndroidLoginPage(driver);
			AndroidHomePage AHP = new AndroidHomePage(driver);
			AndroidCheckoutPage ACP = new AndroidCheckoutPage(driver);
			
			AHP.ClickLogout();
			ALP.Login("problem_user","secret_sauce");
			AHP.VerifySingleProductName();
			
		}
		else{
			//Runs IOS Test
		}

	}
	
	@Test(priority=6)
	public void VerifyserWithIssueAddtoCart() throws InterruptedException  {

		if(BaseSetup.Platform.equals("Android")) {
			AndroidLoginPage ALP = new AndroidLoginPage(driver);
			AndroidHomePage AHP = new AndroidHomePage(driver);
			AndroidCheckoutPage ACP = new AndroidCheckoutPage(driver);
			
			AHP.Add2ItemstoCart();
		}
		else{
			//Runs IOS Test
		}

	}

}

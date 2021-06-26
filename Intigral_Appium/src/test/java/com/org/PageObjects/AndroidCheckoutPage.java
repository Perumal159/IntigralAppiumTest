package com.org.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.org.Reusable.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidCheckoutPage {

	AppiumDriver<MobileElement> driver;
	Common common;

	public AndroidCheckoutPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		common = new Common(driver);
	}

	private static By Quantity = By.xpath("//android.view.ViewGroup[@content-desc='test-Amount']/android.widget.TextView");
	private static By ProdName = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]");
										  //android.view.ViewGroup[@content-desc="test-Description"]/android.widget.TextView
	private static By RemoveItembtn = By.xpath("//android.view.ViewGroup[@content-desc='test-REMOVE']/android.widget.TextView");
	private static By ContinueShopping = By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE SHOPPING']");
	private static By CheckoutBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']");
	private static By FirstName = By.xpath("//android.widget.EditText[@content-desc='test-First Name']");
	private static By LastName = By.xpath("//android.widget.EditText[@content-desc='test-Last Name']");
	private static By ZipCode = By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
	private static By LastContinuebtn = By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']");
	private static By LastPageProdName = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView");
	private static By FinishBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']");
	private static By ThankyouforOrder = By.xpath("//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.TextView");
	private static By BackHome= By.xpath("//android.view.ViewGroup[@content-desc='test-BACK HOME']");
	
	
	public void VerifyItemsinCart() throws InterruptedException {
		common.WaitforPresentofElement(Quantity);
		System.out.println("Going to verify "+AndroidHomePage.ItemAdded.size()+" items in cart");

		List<MobileElement> checkoutPageProdlist = driver.findElements(ProdName);
		ArrayList<String> ItemsinCheckoutpage = new ArrayList<String>();
		int tot= ItemsinCheckoutpage.size();
		int x=1;
		for(MobileElement items: checkoutPageProdlist) {
			ItemsinCheckoutpage.add(items.getText());
//			if(x==tot) {
//				common.AndroidUIScrollable("T-Shirt");
//				Thread.sleep(2000);
//				ItemsinCheckoutpage.add(items.getText());
//			}
			
//			x++;
		}
		common.AndroidUIScrollable("T-Shirt");
		List<MobileElement> checkoutPageProdlist2 = driver.findElements(ProdName);
		for(MobileElement items: checkoutPageProdlist2) {
			if(x==2) {
				ItemsinCheckoutpage.add(items.getText());
			}
			x++;
		}
		
		
		System.out.println("ItemsinCheckoutpage "+ItemsinCheckoutpage.toString());
		
		int count = AndroidHomePage.ItemAdded.size();
		for(int i=0; i<count; i++) {
			if(i==0) {
				Assert.assertEquals( ItemsinCheckoutpage.get(i),AndroidHomePage.ItemAdded.get(i),"Product Name doesnt match, Item not added to cart");
				System.out.println("Sauce Labs Backpack is Present in cart");
			}
			else if(i==1) {
				Assert.assertEquals( ItemsinCheckoutpage.get(i),AndroidHomePage.ItemAdded.get(i),"Product Name doesnt match, Item not added to cart");
				System.out.println("Sauce Labs Bike Light is Present in cart");
			}
			else if(i==2) {
//				common.AndroidUIScrollable("Sauce Labs Bolt T-Shirt");
				Assert.assertEquals( ItemsinCheckoutpage.get(i),AndroidHomePage.ItemAdded.get(i),"Product Name doesnt match, Item not added to cart");
				System.out.println("Sauce Labs Bolt T-Shirt is present in cart");
			}
		}
	}

	//Removes last item from cart
	public void RemoveItemfromcart() {
		List<MobileElement>removebtn = driver.findElements(RemoveItembtn);
		int tot = removebtn.size();
		int i=1;
		for(MobileElement rem: removebtn) {
			if(i==tot) {
				rem.click();
			}
				i++;
		}
		AndroidHomePage.ItemAdded.remove(2);
		System.out.println("Final List of item "+AndroidHomePage.ItemAdded.toString());
		driver.findElement(ContinueShopping).click();
	}
	
	public void verifyRemainingItem() {
		common.WaitforPresentofElement(CheckoutBtn);
		Assert.assertEquals(driver.findElement(ProdName).getText(),AndroidHomePage.ItemAdded.get(0));
	}
	
	public void FinalCheckout() {
		driver.findElement(CheckoutBtn).click();
		common.WaitforPresentofElement(FirstName);
		driver.findElement(FirstName).sendKeys("FirstName");
		driver.findElement(LastName).sendKeys("LastName");
		driver.findElement(ZipCode).sendKeys("1234");
		common.AndroidUIScrollable("CONTINUE");
		driver.findElement(LastContinuebtn).click();
		common.WaitforPresentofElement(LastPageProdName);
		Assert.assertEquals(driver.findElement(LastPageProdName).getText(), AndroidHomePage.ItemAdded.get(0),"Item not removed");
		System.out.println("Correct item is present in the final Checkout page");
		common.AndroidUIScrollable("FINISH");
		driver.findElement(FinishBtn).click();
		common.WaitforPresentofElement(ThankyouforOrder);
		Assert.assertEquals(driver.findElement(ThankyouforOrder).getText(), "THANK YOU FOR YOU ORDER");
		driver.findElement(BackHome).click();
	}

}

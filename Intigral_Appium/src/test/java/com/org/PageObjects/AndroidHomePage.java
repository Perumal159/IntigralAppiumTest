package com.org.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.org.Reusable.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;

public class AndroidHomePage {
	
	AppiumDriver<MobileElement> driver;
	Common common;
	public static ArrayList<String> ItemAdded;
	public static ArrayList<String> ItemAdded2;
	
	public AndroidHomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		common = new Common(driver);
	}
	
	private static By Productname = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
	private static By Prodprice = By.xpath("//android.widget.TextView[@content-desc='test-Price']");
	private static By ItemPageProdName = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]");
	private static By BackToProductbtn = By.xpath("//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']/android.widget.TextView");
	private static By AddtoCart = By.xpath("//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
											//android.view.ViewGroup[@content-desc="test-ADD TO CART"]
	private static By ShortItemInCart = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView");
	private static By CheckoutBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView");
	private static By RemoveBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-REMOVE']");
	private static By SidePanelBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView");
	private static By Logoutbtn = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']/android.widget.TextView");
	
	public void IdentifyElementDescriptionnPrice() {
		
//		HashMap<String, String> HM = new HashMap<String, String>();
		List<MobileElement> ProdName = driver.findElements(Productname);
		List<MobileElement> ProdPrice = driver.findElements(Prodprice);
		ArrayList<String> Name = new ArrayList<String>();
		ArrayList<String> Price = new ArrayList<String>();
		String name ="";
		String price = "";
		
		for(int i=0; i<ProdName.size(); i++) {
			name = ProdName.get(i).getText();
			price = ProdPrice.get(i).getText();
			System.out.println("Name->"+name+", Price"+price);
			Name.add(name);
			Price.add(price);
		}
		String pricetex="";
		int i=0;
		for(MobileElement Prod : ProdName ) {
			Prod.click();
			common.WaitforPresentofElement(ItemPageProdName);
			Assert.assertEquals(driver.findElement(ItemPageProdName).getText(), Name.get(i), "The Name doesnt match!!");
			pricetex = Price.get(i);
		    common.AndroidUIScrollable(pricetex);
			Assert.assertEquals(driver.findElement(Prodprice).getText(), Price.get(i), "The Price doesnt match!!");
			i++;
			System.out.println("Name and Price matches!!");
			driver.findElement(BackToProductbtn).click();
			common.WaitforPresentofElement(Productname);
		}
		
		
	}
	
	public void Add3ItemstoCart() throws InterruptedException {
		List<MobileElement> Add = driver.findElements(AddtoCart);
		ItemAdded = new ArrayList<String>();
		
		
		for(MobileElement add: Add) {
			add.click();
			Thread.sleep(1000);
		}
		List<MobileElement> ItemName = driver.findElements(Productname);
		for(MobileElement Name: ItemName) {
			System.out.println("Item Added "+Name.getText());
			ItemAdded.add(Name.getText());
		}
		
		common.AndroidUIScrollable("T-Shirt");
		
		Thread.sleep(1000);
		
		List<MobileElement> Add2 = driver.findElements(AddtoCart);
		
		for(MobileElement add: Add2) {
			add.click();
			Thread.sleep(1000);
		}
		
		ItemAdded.add(driver.findElement(Productname).getText());
		
		System.out.println("Item Added "+driver.findElement(Productname).getText());
		
		Assert.assertEquals(driver.findElement(ShortItemInCart).getText(), "3");
		
		driver.findElement(CheckoutBtn).click();

	}
	
	public void VerifyTheItemsAddedinHomepagenRemove() {
		common.AndroidUIScrollable("Backpack");
		List<MobileElement> Remove = driver.findElements(RemoveBtn);
		int totalRemove = Remove.size();
		Assert.assertEquals(totalRemove, 2,"Item not removed");
		int i=1;
		for(MobileElement Rem: Remove) {
			if(i==totalRemove) {
				Rem.click();
			}
			i++;
		}
		ItemAdded.remove(1);
		System.out.println("Remaining item in cart is "+ItemAdded.toString());
		String Shortitemtext = driver.findElement(ShortItemInCart).getText();
		
		Assert.assertEquals(Shortitemtext, "1","Item not removed");
		
		driver.findElement(CheckoutBtn).click();
	}
	
	public void ClickCart() {
		driver.findElement(CheckoutBtn).click();
	}
	
	public void ClickLogout() {
		driver.findElement(SidePanelBtn).click();
		common.WaitforPresentofElement(Logoutbtn);
		driver.findElement(Logoutbtn).click();
		
	}
	
	public void VerifySingleProductName() {
		common.WaitforPresentofElement(Productname);
		String ProdName = driver.findElement(Productname).getText();
		
		driver.findElement(Productname).click();
		
		String itempageProdName = driver.findElement(ItemPageProdName).getText();
		
		driver.findElement(BackToProductbtn).click();
		
		Assert.assertEquals(itempageProdName, ProdName);
		
	}
	
	public void Add2ItemstoCart() throws InterruptedException {
		common.WaitforPresentofElement(Productname);
		
		List<MobileElement> Add = driver.findElements(AddtoCart);
		ItemAdded2 = new ArrayList<String>();
		
		
		for(MobileElement add: Add) {
			add.click();
			Thread.sleep(1000);
		}
		
		String Shortitemtext = driver.findElement(ShortItemInCart).getText();
		
		Assert.assertEquals(Shortitemtext, "2","Item not Added");
	}

}

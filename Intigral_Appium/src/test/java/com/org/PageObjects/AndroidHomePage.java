package com.org.PageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.org.Reusable.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class AndroidHomePage {
	
	AppiumDriver<MobileElement> driver;
	Common common;
	
	public AndroidHomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		common = new Common(driver);
	}
	
	private static By Productname = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
	private static By Prodprice = By.xpath("//android.widget.TextView[@content-desc='test-Price']");
	private static By ItemPageProdName = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]");
	private static By BackToProductbtn = By.xpath("	//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']/android.widget.TextView");
	
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
	


}

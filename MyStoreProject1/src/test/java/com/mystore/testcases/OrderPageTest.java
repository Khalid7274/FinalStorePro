/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author naimt
 *
 */
public class OrderPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addtoCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void verifyTotalPrice() throws Exception {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct("T-shirt");
		addtoCartPage= searchResultPage.clickOnProduct();
		addtoCartPage.enterQuantity("2");
		addtoCartPage.selectSize("M");
		addtoCartPage.clickOnAddToCart();
		orderPage=addtoCartPage.clickOnProceedToCheckOut();
		double unitPrice=orderPage.getUnitPrice();
		double totalPrice=orderPage.getTotalPrice();
		double expectedPrice=unitPrice*2+2;
		Assert.assertEquals(totalPrice, expectedPrice);
		loginPage=orderPage.clickOnCheckout();
	}
}

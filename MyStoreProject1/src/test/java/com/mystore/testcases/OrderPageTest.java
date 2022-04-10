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
import com.mystore.dataprovider.DataProviders;
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
	
	@Test(groups="Regression", dataProvider="ProductDetails", dataProviderClass= DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Exception {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		addtoCartPage= searchResultPage.clickOnProduct();
		addtoCartPage.enterQuantity(qty);
		addtoCartPage.selectSize(size);
		addtoCartPage.clickOnAddToCart();
		orderPage=addtoCartPage.clickOnProceedToCheckOut();
		double unitPrice=orderPage.getUnitPrice();
		double totalPrice=orderPage.getTotalPrice();
		double expectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, expectedPrice);
		loginPage=orderPage.clickOnCheckout();
	}
}

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
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Nematullah Khalid 
 *
 */
public class AddToCartPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addtoCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"}, dataProvider="ProductDetails", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		addtoCartPage= searchResultPage.clickOnProduct();
		addtoCartPage.enterQuantity(qty);
		addtoCartPage.selectSize(size);
		addtoCartPage.clickOnAddToCart();
		boolean result=addtoCartPage.validateAddToCart();
		Assert.assertTrue(result);
	}
}

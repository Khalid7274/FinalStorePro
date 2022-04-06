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
import com.mystore.pageobjects.IndexPage;

/**
 * @author naimt
 *
 */
public class IndexPageTest extends BaseClass{
	
	IndexPage indexPage=new IndexPage();
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		indexPage=new IndexPage();
		boolean flag=indexPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test (groups = "Smoke")
	public void verifyTitle() {
		String actualTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Store");
		
	}
	
}

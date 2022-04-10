/**
 * 
 */
package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author naimt
 *
 */
public class AccountCreationPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (groups = "Sanity")
	public void verifyAccountCreationPageTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		
		accountCreationPage=loginPage.createNewAccount("salimkhan@gmail.com");
		boolean validatCreation=accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(validatCreation);
	}
	
	@Test(groups= "Regression", dataProvider="newAcountDetailsData", dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		accountCreationPage.createAccount(hashMapValue.get("Gender"), 
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"), 
				hashMapValue.get("Address"), 
				hashMapValue.get("City"), 
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"), 
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage=accountCreationPage.validRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrentUrl());
	}
}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	Action action=new Action();
	
	@FindBy (xpath = "//h1[text()='Create an account']")
	WebElement formTitle;
	
	@FindBy (xpath="//input[@id='id_gender1']")
	private WebElement mr;
	
	@FindBy (xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/label[1]")
	private WebElement mrs;
	
	@FindBy (xpath="//input[@id='customer_firstname']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@id='customer_lastname']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@id='passwd']")
	private WebElement passWord;
	
	@FindBy (xpath="//select[@id='days']")
	private WebElement days;
	
	@FindBy (xpath="//select[@id='months']")
	private WebElement months;
	
	@FindBy (xpath="//select[@id='years']")
	private WebElement years;
	//address
	@FindBy (xpath="//input[@id='firstname']")
	private WebElement customerFirstName;
	
	@FindBy (xpath="//input[@id='lastname']")
	private WebElement customerLastName;
	
	@FindBy (xpath="//input[@id='company']")
	private WebElement companyName;
	
	@FindBy (name="address1")
	private WebElement address;
	
	@FindBy (name="city")
	private WebElement city;
	
	@FindBy (name="id_state")
	private WebElement state;
	
	@FindBy (name="postcode")
	private WebElement zipCode;
	
	@FindBy (name="id_country")
	private WebElement country;
	
	@FindBy (name="phone_mobile")
	private WebElement mobile;
	
	@FindBy (name="alias")
	private WebElement ref;
	
	@FindBy (xpath="//span[normalize-space()='Register']")
	private WebElement registrationBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String gender, String fName,
			String lname,
			String pswd,
			String day,
			String month,
			String year,
			String comPany,
			String addr,
			String cityString,
			String statName,
			String zip,
			String countryName,
			String mobilePhone) {
		if(gender.equalsIgnoreCase("Mr")) {
			Action.click(getDriver(), mr);
		}else {
			Action.click(getDriver(), mrs);
		}
		
		Action.type(firstName, fName);
		Action.type(lastName, lname);
		Action.type(passWord, pswd);
		Action.selectByValue(days,day);
		Action.selectByValue(months, month);
		Action.selectByValue(years, year);
		Action.type(companyName, comPany);
		Action.type(address, addr);
		Action.type(city, cityString);
		Action.selectByVisibleText(state, statName);
		Action.type(zipCode, zip);
		Action.selectByVisibleText(country, countryName);
		Action.type(mobile, mobilePhone);
	}
	
	public HomePage validRegistration() {
		registrationBtn.click();
		return new HomePage();
	}
	
	public boolean validateAccountCreatePage() {
		return Action.isDisplayed(getDriver(), formTitle);
	}
	
	
}

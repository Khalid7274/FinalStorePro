package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{

	@FindBy (id = "cgv")
	WebElement AgreeCheckBox;
	
	@FindBy (xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() {
		Action.click(getDriver(),AgreeCheckBox);
	}
	
	public PaymentPage clickOnProceedToCheout() {
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new PaymentPage();
	}
	
}

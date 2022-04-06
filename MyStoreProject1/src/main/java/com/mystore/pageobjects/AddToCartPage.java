package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	@FindBy (id ="quantity_wanted")
	WebElement quantity;
	
	@FindBy (name ="group_1")
	WebElement size;
	
	@FindBy (xpath="//span[normalize-space()='Add to cart']")
	WebElement addTocartBtn;
	
	@FindBy (xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCartMessage;
	
	@FindBy(xpath ="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String qty) {
		Action.type(quantity, qty);
	}
	
	public void selectSize(String productsize) {
		Action.selectByVisibleText(size, productsize);
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addTocartBtn);
	}
	
	
	public boolean validateAddToCart() {
		Action.fluentWait(getDriver(), addToCartMessage, 10);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnProceedToCheckOut() throws Exception {
		Action.fluentWait(getDriver(), addToCartMessage, 15);
		Action.JSClick(getDriver(), proceedToCheckoutBtn);
		return new OrderPage();
	}
}

/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author naimt
 *
 */
public class PaymentPage extends BaseClass{

	@FindBy (xpath = "//a[@class='bankwire']")
	WebElement bankWireMethod;
	
	@FindBy (xpath = "//a[contains(text(),'Pay by check')]")
	WebElement checkMethod;
	
	public PaymentPage () {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnBanWireMethod() {
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}
	
	
}

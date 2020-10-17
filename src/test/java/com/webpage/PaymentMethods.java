package com.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethods {


	protected static WebDriver driver;

	public PaymentMethods(){
		PageFactory.initElements(BrowserClass.driver, this);
	}

	@FindBy(xpath="//*[@id='paymentmethod_1']")private WebElement paymentinformationfirst;

	@FindBy(xpath="//*[@id='paymentmethod_0']")private WebElement codpaymentinformation;

	@FindBy(xpath="//*[@id='payment-method-buttons-container']/input") private WebElement paymentinformationcontinue ;

	public void paymentinformationfirsts(){
		paymentinformationfirst.click();
	}

	public void codpaymentinformation(){
		codpaymentinformation.click();
	}

	public void paymentinformationcontinues(){
		paymentinformationcontinue.click();
	}
}

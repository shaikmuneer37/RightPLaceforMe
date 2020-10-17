package com.webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformation {


	public PaymentInformation(){
		PageFactory.initElements(BrowserClass.driver, this);
	}


	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[5]/div[2]/div/input") private WebElement paymentinformationcontinue;
	

	public void paymentinformationcontinues(){
		paymentinformationcontinue.click();
	}

	
}

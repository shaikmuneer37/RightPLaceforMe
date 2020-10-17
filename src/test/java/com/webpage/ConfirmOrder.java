package com.webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrder {


	public ConfirmOrder(){
		PageFactory.initElements(BrowserClass.driver, this);
	}



	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[6]/div[2]/div[2]/input") private WebElement confirmorderbutton;
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")private WebElement orderconformationmsg;
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]") private WebElement orderid;


	public void confirmorderbutton(){
		confirmorderbutton.click();
	}

	public String orderconformationmsg(){
		return orderconformationmsg.getText();
	}
	public String orderid(){
		return orderid.getText();
	}

}

package com.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddress {


	protected static WebDriver driver;

	public ShippingAddress(){
		PageFactory.initElements(BrowserClass.driver, this);
	}


	@FindBy(xpath="//*[@id='shipping-address-select']") private WebElement shipingropdowns ;


	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[2]/div[2]/div/input")private WebElement buttonshiping ;





	public void dropdowshipping(){
		Select sel = new Select(shipingropdowns);
		sel.selectByVisibleText("Munna sk, Hyderabad, Hyd 534234, India");
	}

	public void shipingcontinuebuttons(){
		buttonshiping.click();
	}



}

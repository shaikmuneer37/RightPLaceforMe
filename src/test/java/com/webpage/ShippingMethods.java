package com.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethods {


	protected static WebDriver driver;

	public ShippingMethods(){
		PageFactory.initElements(BrowserClass.driver, this);
	}

	@FindBy(xpath="//*[@id='shippingoption_1']") private WebElement shipingnextdayair ;

	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/input") private WebElement finalcontinue ;

	public void shipingnextdayairs(){
		shipingnextdayair.click();
	}


	public void finalcontinues(){
		finalcontinue.click();
	}
}

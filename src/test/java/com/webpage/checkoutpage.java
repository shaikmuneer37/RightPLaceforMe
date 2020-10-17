package com.webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkoutpage {


	public checkoutpage(){
		PageFactory.initElements(BrowserClass.driver, this);
	}

	@FindBy(xpath="//*[@id='billing-address-select']") private WebElement dropdown;


	public void dropdowns(){

		Select sel = new Select(dropdown);
		sel.selectByVisibleText("New Address");

	}



}

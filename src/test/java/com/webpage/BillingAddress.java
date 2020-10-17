package com.webpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingAddress  {

	public BillingAddress(){

		PageFactory.initElements(BrowserClass.driver, this);
	}


	@FindBy(xpath="//input[@data-val='true']")private List<WebElement>  manadaterytextfields;
	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")private WebElement  firstname;

	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")private WebElement  lastname;

	@FindBy(xpath="//*[@id='BillingNewAddress_StateProvinceId']")private WebElement  state;

	@FindBy(xpath="//*[@name='BillingNewAddress.CountryId']") private WebElement  countrylist;

	@FindBy(xpath="//input[@id='BillingNewAddress_City']")private WebElement city;

	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")private WebElement firstBillingAdderess;

	@FindBy(xpath="//input[@id='BillingNewAddress_Address2']")private WebElement secondBillingAdderess;


	@FindBy(xpath="//div[@id='billing-buttons-container']/input")private WebElement continuebutton;

	public void firstnames(String fstname){
		firstname.sendKeys(fstname);
	}

	public void lastnames(String lstname){
		lastname.sendKeys(lstname);
	}

	public void countrylists(){

		Select s = new Select(countrylist);
		s.selectByVisibleText("India");
	}
	public void states(){

		Select s = new Select(state);
		s.selectByIndex(0);
	}

	public void cityname(String cityname){
		city.sendKeys(cityname);
	}


	public void firstBillingAdderess(String add1){
		firstBillingAdderess.sendKeys(add1);
	}

	public void secondBillingAdderess(String add2){
		secondBillingAdderess.sendKeys(add2);
	}

	public void continuebuttons(){
		continuebutton.click();
	}

	public List<WebElement> manadaterytextfield(){

		return manadaterytextfields;
	}
}

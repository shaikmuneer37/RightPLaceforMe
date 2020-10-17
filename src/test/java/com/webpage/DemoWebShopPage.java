package com.webpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopPage {


	protected static WebDriver driver;

	public DemoWebShopPage(){
		PageFactory.initElements(BrowserClass.driver, this);
	}




	@FindBy(linkText="Log in") private WebElement loginbuttons ; 
    
	@FindBy(xpath="//a[@class='ico-cart']/span[1]") private WebElement addtocart;
	@FindBy(xpath="//a[@class='ico-cart']/span[2]") private List<WebElement> shopingcartquantity;
	
	

	@FindBy(xpath="//div[@class='header-links']/ul/li[1]") private WebElement credential;
	
	@FindBy(xpath="//div[@class='listbox']/ul/li") private List<WebElement>  allbooks;
	
	@FindBy(xpath="//*[text()='The product has been added to your ']") private WebElement  addtocartsucessfulmessage;  //div[@class='listbox']/ul/li/a
	@FindBy(xpath="//*[text()='shopping cart']") private WebElement  shopingcart; 
	@FindBy(xpath="div[@class='listbox']/ul/li/a") private WebElement  eachbooks; 
	@FindBy(xpath="//div[@class='listbox']/ul/li/a") private WebElement selectbooks;
	
	@FindBy(xpath="//div[@class='product-item']/div[2]/h2") private List<WebElement> subcatagerybooks;
	
	@FindBy(xpath="//div[@class='header-links-wrapper']/div/ul/li[2]")  private WebElement logout;
	
	public void login(){
		loginbuttons.click();
	  }
	

	public void shopingcart(){
          addtocart.click();
	} 
	public String credentials(){
		
		return credential.getText();
	}

	public String matchedbook(){
		return eachbooks.getText();
	}
	public int bookscount(){
		return allbooks.size();
	}
	
	
	public void selectedbooks(){
		selectbooks.click();
	}
	public int shopingcartquantitys(){
		return shopingcartquantity.size();
	}
	
	
	public int subcategerybooks(){
		return subcatagerybooks.size();	
	}
	

	public String addtocartsucessfulmessage(){
		String msg= addtocartsucessfulmessage.getText();
		System.out.println("cart msg="+msg);
		return msg;
	
}
	
	public void logout(){
		logout.click();
	}
}

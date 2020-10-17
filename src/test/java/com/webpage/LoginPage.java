package com.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	protected static WebDriver driver;

	      public LoginPage(){
		          PageFactory.initElements(BrowserClass.driver, this);
	            }

	
	 
	
	 @FindBy(linkText="Log in") private WebElement loginbuttons ; 
	 
	 @FindBy(xpath ="//div[@class='page-title']/h1") private WebElement messgae;
	 
	 @FindBy(xpath="//input[@id='Email']")     private WebElement email ;
	 
	 @FindBy(xpath="//input[@id='Password']")  private WebElement password ;
	 
	 @FindBy(xpath="//input[@value='Log in']") private WebElement logbutton;
	 
	 @FindBy(xpath="//a[@class='ico-cart']/span[1]") private WebElement cart;
	 
	  
	   public void login(){
		 loginbuttons.click();
	   }
	  
	   public String validatemessage(){
		  return  messgae.getText();
	   }
	 
	    public void username(String username){
		 
		 email.sendKeys(username);
		 
	 }
	 
     public void passwords(String passwrd){
		 
	 password.sendKeys(passwrd);
		 
	 }
	 
	 public void submittbutton(){
		
		 logbutton.click();
	 }
	 
	 public void addcart(){
			
		 cart.click();
	 } 
	 
	 
	
}

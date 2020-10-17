package com.webpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webpage.BrowserClass;

public class ShoppingCartPage {


	protected static WebDriver driver;

	public ShoppingCartPage(){
		PageFactory.initElements(BrowserClass.driver, this);
	}


	@FindBy(xpath="//tr[@class='cart-item-row']/td[1]/input") private WebElement remove ; 

	@FindBy(xpath="//div[@class='common-buttons']/input[1]") private WebElement updatecart;

	@FindBy(xpath="//div[@class='terms-of-service']/input[1]") private WebElement checkboxterm;

	@FindBy(xpath="//table[@class='cart-total']/tbody/tr[1]/td[2]") private WebElement subtotalamount;

	@FindBy(xpath="//button[@id='checkout']") private WebElement checkout;

	@FindBy(xpath="//tr[@class='cart-item-row']")private List<WebElement> deletcount;


	public void removebutton(){
		remove.click();	
	}

	public void updatedcartbutton(){
		updatecart.click();
	}

	public void termscheckbox(){
		checkboxterm.click();
	}

	public String subtotalamounts(){
		return subtotalamount.getText();

	}

	public void checkouts(){
		checkout.click();
	}

	public int selecteditemcount(){
		return deletcount.size();

	}


}

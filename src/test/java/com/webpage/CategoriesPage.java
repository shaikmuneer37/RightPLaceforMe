package com.webpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {


	public CategoriesPage(){
		PageFactory.initElements(BrowserClass.driver, this);
	}


	@FindBy(xpath="//div[@class='listbox']/ul/li") private List<WebElement>  categorilist;

	@FindBy(xpath="//div[@class='product-item']/div[2]/h2") private  WebElement selectedsubcatagerybooks; // selecte computerbook

	@FindBy(xpath="//div[@class='listbox']/ul/li/a")private  WebElement clickonbooks;

	@FindBy(xpath="//div[@class='add-to-cart-panel']/input[1]")private WebElement booksquanty;

	@FindBy(xpath="//div[@class='add-to-cart-panel']/input[2]") private WebElement bookaddtocart;

	@FindBy(xpath="//div[@class='header-menu']/ul/li[1]/a") private WebElement booklink;


	@FindBy(xpath="//div[@class='product-price']/span") private WebElement cartcost;
	public void categorilist(String nameofcategery){   
		int a =categorilist.size();
		for(int i=0;i<a;i++){

			if(categorilist.get(i).getText().equalsIgnoreCase(nameofcategery)){

				System.out.println(nameofcategery);
				System.out.println("spe bookname="+categorilist.get(i).getText());
				clickonbooks.click();
			}
		}

	}

	public void booksquanty(String quantity){
		booksquanty.clear();
		booksquanty.sendKeys(quantity);
	}

	public void bookaddtocart(){
		bookaddtocart.click();
	}



	public void selectedsubcatagerybooks(){
		selectedsubcatagerybooks.click();
	}

	public void booklinks(){
		booklink.click();
	}

	public String costs(){
		return cartcost.getText();
	}
}

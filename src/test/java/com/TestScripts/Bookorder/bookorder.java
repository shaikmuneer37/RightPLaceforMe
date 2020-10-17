package com.TestScripts.Bookorder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.common.util.Excel;
import com.webpage.BillingAddress;
import com.webpage.BrowserClass;
import com.webpage.CategoriesPage;
import com.webpage.ConfirmOrder;
import com.webpage.DemoWebShopPage;
import com.webpage.LoginPage;
import com.webpage.PaymentInformation;
import com.webpage.PaymentMethods;
import com.webpage.ShippingAddress;
import com.webpage.ShippingMethods;
import com.webpage.ShoppingCartPage;
import com.webpage.checkoutpage;

public class bookorder  extends BrowserClass {

	
	@Test
	public void testbook() throws InterruptedException, IOException{

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/testdata/app.properties");
		Properties ps = new Properties();
		ps.load(fis);
		String un =ps.getProperty("username");
		String pwd = ps.getProperty("password");
		
		
		
		DemoWebShopPage page = new DemoWebShopPage();
	  
		  page.login();
         logger.info("entering into login page");
         
		LoginPage login = new LoginPage();
		String s= login.validatemessage();
		System.out.println(s);
		String act ="Welcome, Please Sign In!";
		Assert.assertEquals(act, s);
		
	    login.username(un);
        login.passwords(pwd);
        logger.info("Enter username and password");
		login.submittbutton();

		ShoppingCartPage cart = new ShoppingCartPage();

		String accountid = page.credentials();
	
		Assert.assertEquals(un, accountid);


		page.shopingcart();
		
		logger.info("moving on shoping cart");
     	System.out.println(driver.getTitle());

		CategoriesPage categori = new CategoriesPage();
		int n= cart.selecteditemcount();
		
	
			if(n >0){
				for(int i=0;i<n;i++)
				{
					cart.removebutton();
					cart.updatedcartbutton();
				}
				
				}
			else{
				categori.booklinks();
			   }
logger.info("previous items are removed and now cart is empty");
	         categori.booklinks();

		
		categori.selectedsubcatagerybooks();

		String amunt= categori.costs();

		String Qua ="5";  
		categori.booksquanty(Qua);


		Double d = Double.parseDouble(amunt);
		Double carttotal= d* Integer.parseInt(Qua);

categori.bookaddtocart();

logger.info(" books are updated in the cart");

		String str1 =page.addtocartsucessfulmessage().toUpperCase().trim();
		String str2=  " The product has been added to your shopping cart";
		Assert.assertEquals( str1, str2.toUpperCase().trim());
       
		logger.info("validate the product has been added to your cart message is showing or Not");

		page.shopingcart();
		logger.info("again move on shoping cart ");
		String sm =cart.subtotalamounts();
		Double subtotal = Double.parseDouble(sm);
		System.out.println("subtotal="+subtotal); 

		Assert.assertEquals( carttotal, subtotal); 
		logger.info("valiated the item amount and sub amount ");

		cart.termscheckbox();
		cart.checkouts();


		checkoutpage cout = new checkoutpage();
		logger.info("select the new address from drop down");
		cout.dropdowns();

		BillingAddress address = new BillingAddress();
		logger.info("entered in billing address");
		List<WebElement> ele= address.manadaterytextfield();

		String sheetNames=ps.getProperty("sheetName");//"Sheet3";
		
		Excel el = new Excel();
		el.ReadExcel( sheetNames);
		Iterator<String> itr = el.arrName.iterator();
		while(itr.hasNext())
		{

			Thread.sleep(1000);
			for(int i=1;i<=ele.size()-1;i++){ 
				ele.get(i).clear();

				ele.get(i).sendKeys(itr.next());
			}
		}

     	address.countrylists();
		Thread.sleep(100);
		address.continuebuttons(); 


		ShippingAddress shipadd = new ShippingAddress();
		logger.info(" selcting ShippingAddress down");
		Thread.sleep(1000);  
		shipadd.dropdowshipping();
		shipadd.shipingcontinuebuttons();


		ShippingMethods shpmethods = new ShippingMethods();
		logger.info(" shipping methods page");
		shpmethods.shipingnextdayairs();
		shpmethods.finalcontinues();

		PaymentMethods paymentmethod = new PaymentMethods();
		paymentmethod.paymentinformationfirsts();
		paymentmethod.codpaymentinformation();
		logger.info(" payment page");
		paymentmethod.paymentinformationcontinues();


		PaymentInformation paymeInf = new PaymentInformation();
		Thread.sleep(1000);
		logger.info(" payment information page ");
		paymeInf.paymentinformationcontinues();


		ConfirmOrder corder = new ConfirmOrder();
		Thread.sleep(1000);
		corder.confirmorderbutton();
		logger.info(" order confirmed");
		String ordermessage= corder.orderconformationmsg();
		System.out.println(ordermessage);

		String orderids= corder.orderid();
		System.out.println(orderids);

		page.logout();


	}}
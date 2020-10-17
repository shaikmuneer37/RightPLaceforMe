package com.webpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrowserClass {

	public static WebDriver driver ;
	public static Logger logger;

	@Parameters("diffbrowser")
	@Test
	public void testbase(String diffbrowser) throws IOException {

		if(diffbrowser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}

		else if(diffbrowser.equalsIgnoreCase("firefox"))  {

			System.setProperty("webdriver.gecko.driver" ,System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		logger = Logger.getLogger("PlanIT");
		PropertyConfigurator.configure("Log4j.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/testdata/app.properties");
		Properties ps = new Properties();
		ps.load(fis);
		String url =ps.getProperty("url");

		driver.get(url);



	}
}

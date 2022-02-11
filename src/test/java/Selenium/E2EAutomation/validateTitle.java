package Selenium.E2EAutomation;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
//import pages.LoginPage;
import resources.Base;

public class validateTitle extends Base 
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	LandingPage landingpage;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	  public void validateAppTitle() throws IOException
	  {
		  landingpage=new LandingPage(driver);
		  Assert.assertEquals(landingpage.getTitle().getText(), "FEATURED COURSES123");
		  log.info("Successfully validated text message");
	  }
	
	@Test
	  public void validateHeader() throws IOException
	  {
		  //LandingPage landingpage=new LandingPage(driver);
		  Assert.assertEquals(landingpage.getHeader().getText(), "Learn1 Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		  log.info("Successfully validated header message");
	  }
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}

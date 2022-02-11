package Selenium.E2EAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import resources.Base;

public class validateNavigationBar extends Base
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	  public void validateNavBar() throws IOException
	  {
		  LandingPage landingpage=new LandingPage(driver);
		  Assert.assertTrue(landingpage.getNavigationBar().isDisplayed());
		  log.info("Navigation Bar is displayed");
		  
	  }
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}

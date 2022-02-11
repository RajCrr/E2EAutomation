package Selenium.E2EAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;
import resources.Base;

public class HomePage extends Base
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=InitializeDriver();
		
	}
	
  @Test(dataProvider="getData")
  public void homepageNavigation(String username,String password,String text) throws IOException, InterruptedException
  {
	  driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	  LandingPage landingpage=new LandingPage(driver);
	  LoginPage loginpage=landingpage.Login();
	  
	  //LoginPage loginpage=new LoginPage(driver);
	  loginpage.EmailId().sendKeys(username);
	  loginpage.Password().sendKeys(password);
	  System.out.println(text);
	  log.info(text);
	  loginpage.LogIn().click();
  }
  
  @AfterTest
	public void tearDown()
	{
		driver.close();
	}
  
  @DataProvider
  public Object[][] getData()
  {
	  return new Object[][] {{"restricteduser@qw.com","123456","Restricted User"},{"nonrestricteduser@qw.com","123456","Non Restricted User"}};
  }
  
}

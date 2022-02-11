package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{

	public WebDriver driver;
	
	private By signIn=By.cssSelector("a[href*='sign_in']");
	private  By Title=By.xpath("//*[@id='content']/div/div/h2");
	private By Navigationbar=By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul");
	private By header=By.xpath("//*[@id='myCarousel']/div/div/div/div/div[1]/p");
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public LoginPage Login()
	{
		driver.findElement(signIn).click();
		return new LoginPage(driver);
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(Navigationbar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	} 
}

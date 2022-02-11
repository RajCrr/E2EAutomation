package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	By email=By.id("user_email");
	By pswd=By.name(" password");
	By submit=By.name("commit");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement EmailId()
	{
		return driver.findElement(email);
	}
	
	public WebElement Password()
	{
		return driver.findElement(pswd);
	}
	
	public WebElement LogIn()
	{
		return driver.findElement(submit);
	}
	
}

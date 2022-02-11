package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Base 
{

	public WebDriver driver;
	public Properties prop;
	
	
	@SuppressWarnings("deprecation")
	public WebDriver InitializeDriver() throws IOException
	{
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if (browserName.contains("chrome"))
		{
			System.out.println(browserName);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Executables\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
		
		else if (browserName.equals("edge"))
		{
			System.out.println(browserName);
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Executables\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public String Screenshotpath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
	
}

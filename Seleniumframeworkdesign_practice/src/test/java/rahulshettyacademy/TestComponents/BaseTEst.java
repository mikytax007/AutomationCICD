package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Rahulshettyacademy.POM.Landingpage;

public class BaseTEst {
	
	public WebDriver driver; 
	public Landingpage land;
	// for class variable using public to access any wr within the class
	@Test
	public WebDriver InitializeDriver() throws IOException
	{
		// This is hw we extract values from the properties
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//RahulshettysAcademy//resources//globaldatas.properties");
		p.load(fis);
		String browsername = p.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		return driver;
		
	}
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchApplication() throws IOException
	{	
	  driver = InitializeDriver();
	   land = new Landingpage(driver);
		land.goTo();
		return land;
	}
	
//	@AfterMethod
//	public void teardown()
//	{	
//	  driver.quit();
//	}

}

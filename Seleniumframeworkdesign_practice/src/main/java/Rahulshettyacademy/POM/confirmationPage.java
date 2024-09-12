package Rahulshettyacademy.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Rahulshettyacademy.AbstractComponents.Abstractcomponent;

public class confirmationPage extends Abstractcomponent{

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
    
	@FindBy(css=".hero-primary")
	WebElement txt;
	
	public String confirm()
	{
//		 String Confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		return txt.getText();
//	     Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	     Assert.assertTrue(Confirmmessage.equalsIgnoreCase(msg));
	}
	
//	 String Confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//     Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
}

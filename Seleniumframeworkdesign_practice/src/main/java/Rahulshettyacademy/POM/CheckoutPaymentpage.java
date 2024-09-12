package Rahulshettyacademy.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Rahulshettyacademy.AbstractComponents.Abstractcomponent;

public class CheckoutPaymentpage extends Abstractcomponent{
	
	WebDriver driver;
	public CheckoutPaymentpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;
	@FindBy(css=".action__submit")
	WebElement submit;
	By findingsearch = By.cssSelector(".ta-results");
//	Actions a = new Actions(driver);
	public void selectcountry(String countname)
	{
		
		Actions a = new Actions(driver);
//	    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		Actions a = new Actions(driver);
		a.sendKeys(country, countname).build().perform();
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		visibilityToAppear(findingsearch);
//	    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		selectcountry.click();
		
	}
    
	public confirmationPage submitorder()
	{
		Actions a = new Actions(driver);
//	    a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
		a.moveToElement(submit).click().build().perform();
//		submit.click();
		confirmationPage chckout = new confirmationPage(driver);
		return chckout;
	
	}


//    a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
//    


}

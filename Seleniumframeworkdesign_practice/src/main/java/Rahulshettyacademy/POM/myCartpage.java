package Rahulshettyacademy.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Rahulshettyacademy.AbstractComponents.Abstractcomponent;
//import rahulshettyacademy.Checkoutpaymentpage;

public class myCartpage extends Abstractcomponent {
	
	WebDriver driver;
 public myCartpage(WebDriver driver)
 {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}


 @FindBy(xpath="//ul //button[text()='Checkout']")
 WebElement chckout;
 @FindBy(css=".cartWrap.ng-star-inserted")
 List<WebElement> cartprod;
 
 //  By cart = By.cssSelector(".cartWrap.ng-star-inserted");
   By cartzara = By.cssSelector("h3");
 

 
 public List<WebElement> getcartproducts()
 {
     //List<WebElement> cartproducts =  driver.findElements(By.cssSelector(".cartWrap.ng-star-inserted"));
	 List<WebElement> cartproducts =  cartprod;
	 return cartproducts;
	 
 }
 public Boolean trymatch(String PNN)
 {
//   Boolean match = cartproducts.stream().anyMatch(b->b.findElement(By.cssSelector("h3")).getText()
//		.equalsIgnoreCase(prdname));
	 Boolean match = getcartproducts().stream().anyMatch(b->b.findElement(cartzara).getText()
			 .equalsIgnoreCase(PNN));
	 return match;

 }
 
 public CheckoutPaymentpage checkout()
 {

//    driver.findElement(By.xpath("//ul //button[text()='Checkout']")).click();
	 chckout.click();
	 CheckoutPaymentpage paymentpage = new CheckoutPaymentpage(driver);
	 return paymentpage;
	 
 }
}

package Rahulshettyacademy.POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.AbstractComponents.Abstractcomponent;

public class productcatalguepage extends Abstractcomponent
{
	WebDriver driver;
	public productcatalguepage(WebDriver driver)
	{  
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> productss;
	
	@FindBy(css=".ng-animating")
	WebElement spinning;
	

//	@FindBy(css="[routerlink*='cart']")
//	WebElement headercart;
	
	   By appear = By.cssSelector(".mb-3"); 
	  By cartclick =  By.cssSelector(".fa-shopping-cart");
	  By toastmessage = By.cssSelector("#toast-container");
	  
	
     
	public List<WebElement> listproducts()
	{
		visibilityToAppear(appear);
		return productss;
	}

    public WebElement getbyprdname(String PName)
    {
    	WebElement prdnme =   listproducts().stream().filter(a->a.findElement(By.cssSelector("b"))
        		.getText().equalsIgnoreCase(PName)).findFirst().orElse(null);
    	return prdnme;
    }
    
    public  void cartbutton(String PPName)
    {
    	//      prod.findElement(By.cssSelector(".fa-shopping-cart")).click();
    	 WebElement prdnme = getbyprdname(PPName);
    	prdnme.findElement(cartclick).click();	
    	visibilityToAppear(toastmessage);
    	invisibility(spinning);
    	
    	
//    	headercart.click();
    	
    }

    
}
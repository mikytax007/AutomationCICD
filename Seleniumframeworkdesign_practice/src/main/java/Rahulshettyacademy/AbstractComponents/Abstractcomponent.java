package Rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.POM.Orderpage;
import Rahulshettyacademy.POM.myCartpage;

public class Abstractcomponent {
	WebDriver driver;
	
    public Abstractcomponent(WebDriver driver) 
    {
	      this.driver=driver;
	}
    
	 @FindBy(css="[routerlink*='cart']")
	 WebElement cartclick;
	 
	 @FindBy(css="[routerlink*='myorders']")
	 WebElement orderHeaderClick;
	 
	 public myCartpage cartclickMainPage()
	 { 
	     //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 cartclick.click();
		 myCartpage c =  new myCartpage(driver);
		 return c;
	 }
	 
	 public Orderpage goToOrdersmainPageclick()
	 { 
	     //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 orderHeaderClick.click();
		 Orderpage orderpage =  new Orderpage(driver);
		 return orderpage;
	 }
     
     
	public void visibilityToAppear(WebElement appear)
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOf(appear));
    }
	
	public void visibilityToAppear(By appear)
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(appear));
    }
	public void invisibility(WebElement ele) 
	{
	//	Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

}

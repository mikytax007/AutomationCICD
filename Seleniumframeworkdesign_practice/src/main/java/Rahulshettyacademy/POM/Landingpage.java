package Rahulshettyacademy.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.Abstractcomponent;

public class Landingpage extends Abstractcomponent  {
	
//	driver.get("https://rahulshettyacademy.com/client/");	
//	driver.findElement(By.id("userEmail")).sendKeys("kalla@gmail.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Dennys@123");
//	driver.findElement(By.id("login")).click();
	
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement un;
	@FindBy(id="userPassword")
	WebElement pw;
	@FindBy(id="login")
	WebElement login;
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;


	public String geterrormessage()
	{
		visibilityToAppear(errormessage);
		return errormessage.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public productcatalguepage submit(String uname,String pword)
	{
		un.sendKeys(uname);
		pw.sendKeys(pword);
		login.click();
		productcatalguepage pcp = new productcatalguepage(driver);
		return pcp;
	}
	
}

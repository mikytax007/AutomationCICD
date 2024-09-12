package rahulshettyacademy.Test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Rahulshettyacademy.POM.Landingpage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		String productname = "ZARA COAT 3";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("kalla@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dennys@123");
		driver.findElement(By.id("login")).click();
		
		// methods for landing page //
		Landingpage landingpage = new Landingpage(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
        List<WebElement> products =  driver.findElements(By.cssSelector(".mb-3"));
        
        WebElement item =   products.stream().filter(a->a.findElement(By.cssSelector("b"))
        		.getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
        
        item.findElement(By.cssSelector(".fa-shopping-cart")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        
        
        
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        
        System.out.println("***********now put all the cart items in the list*********");
        
        List<WebElement> cartproducts =  driver.findElements(By.cssSelector(".cartWrap.ng-star-inserted"));
        
        Boolean match = cartproducts.stream().anyMatch(b->b.findElement(By.cssSelector("h3")).getText()
        		.equalsIgnoreCase(productname));
        
        Assert.assertTrue(match);
        
        driver.findElement(By.xpath("//ul //button[text()='Checkout']")).click();
        
        System.out.println("********** cart page********");
   
        
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
        
       String Confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       System.out.println("click on orders");
      a.moveToElement(driver.findElement(By.cssSelector("[routerlink*='myorders']"))).click().build().perform();

      List<WebElement> listing = driver.findElements(By.xpath("//tr/td[2]"));
     Boolean m = listing.stream().anyMatch(o->o.getText().equalsIgnoreCase(productname));
     Assert.assertTrue(m);
     driver.quit();
            
        
	}

}

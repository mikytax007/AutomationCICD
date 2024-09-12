package rahulshettyacademy.Test;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Rahulshettyacademy.POM.CheckoutPaymentpage;
import Rahulshettyacademy.POM.Landingpage;
import Rahulshettyacademy.POM.confirmationPage;
import Rahulshettyacademy.POM.myCartpage;
import Rahulshettyacademy.POM.productcatalguepage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import rahulshettyacademy.TestComponents.BaseTEst;

public class ErrorValidation extends BaseTEst

	  {
		
		@Test(groups= {"errorhandling"})
		public void LoginErrorValidation() throws IOException, InterruptedException
		{
			
		land.submit("kallaa@gmail.com", "Dennys@123");
		Assert.assertEquals("Incorrect email or password.", land.geterrormessage());
	
		}   
		@Test
		public void ProductErrorValidation() throws IOException, InterruptedException
		{
			
			String prdname = "ZARA COAT 3";
			String selectcountry = "India";
			
			productcatalguepage pcp = land.submit("kalli@gmail.com", "Dennys@123");
			
			List<WebElement> products =  pcp.listproducts();
			 pcp.getbyprdname(prdname);
			pcp.cartbutton(prdname);
			myCartpage c = pcp.cartclickMainPage();
			Boolean match =c.trymatch("ZARA COAT 33");
			Assert.assertFalse(match);
	
		}    
        
	}



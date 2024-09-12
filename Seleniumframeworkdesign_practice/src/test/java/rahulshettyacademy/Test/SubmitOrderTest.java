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
import Rahulshettyacademy.POM.Orderpage;
import Rahulshettyacademy.POM.confirmationPage;
import Rahulshettyacademy.POM.myCartpage;
import Rahulshettyacademy.POM.productcatalguepage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import rahulshettyacademy.TestComponents.BaseTEst;

public class SubmitOrderTest extends BaseTEst
{
String prdname = "ZARA COAT 3";
	  
		
		@Test
		public void submitorder() throws IOException, InterruptedException
		{
		
		String selectcountry = "India";
		
		productcatalguepage pcp = land.submit("kalla@gmail.com", "Dennys@123");
		
		List<WebElement> products =  pcp.listproducts();
		 pcp.getbyprdname(prdname);
		pcp.cartbutton(prdname);
		myCartpage c = pcp.cartclickMainPage();
		Boolean match =c.trymatch(prdname);
		Assert.assertTrue(match);
		CheckoutPaymentpage paymentpage = c.checkout();
        System.out.println("********** cart page********");
        paymentpage.selectcountry(selectcountry);
        confirmationPage chckout =  paymentpage.submitorder();
        String Confirmmessage = chckout.confirm();
       Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}    
		
		@Test(dependsOnMethods= {"submitorder"})
		public void OrderHistoryTest()
		{
			productcatalguepage pcp = land.submit("kalla@gmail.com", "Dennys@123");
			Orderpage orderspage = pcp.goToOrdersmainPageclick();
			Assert.assertTrue(orderspage.VerifyOrderDisplay(prdname));
			
		}
        
	}



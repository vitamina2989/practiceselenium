package WebBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class baiso8 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1. Setting the driver path
	    System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
						
	    //2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
						
		//3, Navigate to web page
		String url = "https://mecoxcloud.flywheelstaging.com/";
		driver.get(url);
		
		//4. Maximizing window
		driver.manage().window().maximize();
		
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//6. Print title of Mecox
		System.out.println("6. Mecox's title is " + driver.getTitle());
		
		//7. Verify Mecox's title is correct
		String expectedtitle1 = "Mecox Gardens Homepage - Mecox Gardens";
        String actualtitle1 = driver.getTitle();
		Assert.assertEquals(actualtitle1,expectedtitle1);
        
       /*  if (expectedtitle1.equals(actualtitle1))
        {
            System.out.println("7.a - Mecox's title is correct");
        }
        else
        {
            System.out.println("7.b - Mecox's title is not correct");
        }*/
		   
       //8. Select Mecox Collection category
      	Actions action = new Actions(driver);
      	action.moveToElement(driver.findElement(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[contains(text(),'MECOX COLLECTION')]"))).perform();
      	driver.findElement(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[contains(text(),'MECOX COLLECTION')]")).click();
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	
      //9. Select COLBY TEAK AND WOVEN DESK (Mecox Collection > click choose item > detail item)
        action.moveToElement(driver.findElement(By.xpath("//h2[contains(text(),'Colby Teak and Woven Desk')]"))).perform();
      	driver.findElement(By.xpath("//h2[contains(text(),'Colby Teak and Woven Desk')]")).click();
      	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      		
      //10. Select 2 units by clicking + button of RUCKER ROPE CONSOLE WITH ARCHED BASE	
        driver.findElement(By.xpath("//span[@class='yc-advance-icon quantity-plus noselect']")).click();	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		
      //12. Add to Cart button
    	driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		
      //13. Click Cart shopping 
        driver.findElement(By.xpath("//a[contains(text(),'View cart')]")).click();
            
      //14. Click Checkout
        driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
      //15. User fills in checkout form
        String firstname = "Anh", lastname = "Do", companyname = "CES", town = "Da Nang",
        zipcode ="1223", phone = "+84354595056", email ="dothingocanh89@gmail.com";
        driver.findElement(By.id("billing_first_name")).sendKeys(firstname);
        driver.findElement(By.id("billing_last_name")).sendKeys(lastname);
        driver.findElement(By.id("billing_company")).sendKeys(companyname);
            
       //16. Select country in drop down list 
        Select dropcountry = new Select (driver.findElement(By.id("billing_country")));
        dropcountry.selectByVisibleText("Vietnam");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            
        driver.findElement(By.id("billing_address_1")).sendKeys("My home \n Chu Huy Man \n Son Tra \n Da Nang");
        driver.findElement(By.id("billing_city")).sendKeys(town);
            
       //17. Select State in dropdown list
       /*Select dropstate = new Select (driver.findElement(By.id("billing_state")));
        //dropstate.selectByVisibleText("Colorado");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */

        driver.findElement(By.id("billing_postcode")).sendKeys(zipcode);
        driver.findElement(By.id("billing_phone")).sendKeys(phone);
        driver.findElement(By.id("billing_email")).sendKeys(email);
        driver.findElement(By.id("wc_constant_contact_subscribe")).click();
        driver.findElement(By.id("order_comments")).sendKeys("Testing testing testing \n I buy 2 \n Please asap");
            
      //17. Select Privacy Policy
      //driver.findElement(By.id("privacy_policy")).click();
            
      //18. Select Place Order
      //driver.findElement(By.id("place_order")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
      //19. Back to product detail or category to choose different product and change quantity
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		
      //20. Change quantity is greater than inventory and update card
        driver.findElement(By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).clear();
    	driver.findElement(By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).sendKeys("19");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//button[@name='update_cart']")).click();
    	//driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		
      //21. Verify the error message is displayed when having quantity is greater than inventory
    	/*Alert alert = driver.switchTo().alert(); // switch to alert
    	String alertMessage= driver.switchTo().alert().getText(); // capture alert message
    	System.out.println(alertMessage); // Print Alert Message
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    	String err = driver.findElement(By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).getAttribute("name");
    	System.out.println (err);
    	var js = (JavascriptExecutor)driver;
        String getNotificationText = null;
		var notification = js.executeAsyncScript(getNotificationText);
    	Assert.assertEquals("Value must be less than or equal to 18", notification);
    	System.out.println (getNotificationText);  */
    	
     //22. Navigate to the checkout page, clear all and add new data.
        driver.findElement(By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).clear();
    	driver.findElement(By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).sendKeys("3");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
     //23. Click Checkout
    	driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
     //24. Clear form & user re-fills in checkout form
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys(firstname);
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys(lastname);
        driver.findElement(By.id("billing_company")).clear();
        driver.findElement(By.id("billing_company")).sendKeys(companyname);
            
      //25. Select country in drop down list 
        Select dropcountry1 = new Select (driver.findElement(By.id("billing_country")));
        dropcountry1.selectByVisibleText("Vietnam");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("billing_address_1")).clear();    
        driver.findElement(By.id("billing_address_1")).sendKeys("My home \n Chu Huy Man \n Son Tra \n Da Nang");
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys(town);
            
       //26. Select State in dropdown list. This state will depend on the selected country
       /*Select dropstate = new Select (driver.findElement(By.id("billing_state")));
        dropstate.selectByVisibleText("Colorado");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */
        
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys(zipcode);
        driver.findElement(By.id("billing_phone")).clear();
        driver.findElement(By.id("billing_phone")).sendKeys(phone);
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys(email);
        driver.findElement(By.id("wc_constant_contact_subscribe")).clear();
        driver.findElement(By.id("wc_constant_contact_subscribe")).click();
        driver.findElement(By.id("order_comments")).clear();
        driver.findElement(By.id("order_comments")).sendKeys("Testing testing testing \n I buy 2 \n Please asap");
            
      //27. Select Privacy Policy
      //driver.findElement(By.id("privacy_policy")).click();
            
      //28. Select Place Order
      //driver.findElement(By.id("place_order")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
      //30. Close & Quit Browser
        driver.quit();
        driver.close();
        
	}

}

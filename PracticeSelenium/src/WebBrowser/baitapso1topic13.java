package WebBrowser;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class baitapso1topic13 {
public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//1. Setting the driver path
		System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
								
		//2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
								
		//3. Navigate to web page
		String url = "https://jqueryui.com/tooltip/";
		driver.get(url);
				
		//4. Maximizing window
		driver.manage().window().maximize();
						
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//6. Switch to Frame
		driver.switchTo().frame(0);
		
		//7. Scroll to element 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
		//8. Get text of tooltip
		WebElement yourage = driver.findElement(By.xpath("//input[@id='age']"));
		String youragetooltip = yourage.getAttribute("title");
		System.out.println ("Tooltip text is:  " + youragetooltip);
		
		//9. Hover Yourage text
		Actions hoveryourage = new Actions(driver);
		hoveryourage.moveToElement(yourage).perform();
		System.out.println("Hover successfully");
		
		//10. Verify tooltip's text
		String expectedtooltip = "We ask for your age only for statistical purposes.";
		Assert.assertEquals(youragetooltip,expectedtooltip);
		System.out.println ("Tooltip text is correct!");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//11. Close & Exit browser
	     //driver.quit();
	     //driver.close();
	
		
	    }

}

package WebBrowser;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Bai2WebBrowser {

	public static void main(String[] args) {
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
		System.out.println("Case 1a - Mecox's title is " + driver.getTitle());
		
		//7. Verify Mecox's title is correct
		String expectedtitle1 = "Mecox Gardens Homepage - Mecox Gardens";
		String actualtitle1 = driver.getTitle();
		if (expectedtitle1.equals(actualtitle1))
		{
			System.out.println("7.a - Mecox's title is correct");	
		}
		else
		{
			System.out.println("7.b - Mecox's title is not correct");
		}
		
		//8. Select Mecox Collection category
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[contains(text(),'MECOX COLLECTION')]"))).perform();
		driver.findElement(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[contains(text(),'MECOX COLLECTION')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//9. Print title of Mecox Collection 
		System.out.println("9 - Mecox's Collection title is " + driver.getTitle());
		//10. Verify Mecox's title is correct
		String expectedtitle2 = "Mecox Collection - Mecox Gardens";
		String actualtitle2 = driver.getTitle();
		if (expectedtitle2.equals(actualtitle2))
		{
			System.out.println("10.a - Mecox's Collection title is correct");	
		}
		else
		{
			System.out.println("10.b - Mecox's Collection title is not correct");
		}
		
		//11. Select TUCKER ROPE CONSOLE WITH ARCHED BASE (Mecox Collection > click choose item > detail item)
		action.moveToElement(driver.findElement(By.xpath("//h2[contains(text(),'Tucker Rope Console with Arched Base')]"))).perform();
		driver.findElement(By.xpath("//h2[contains(text(),'Tucker Rope Console with Arched Base')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//12. Add to cart button
		driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//13. Click Cart shopping 
        driver.findElement(By.xpath("//a[contains(text(),'View cart')]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
		
		//14. Print the product's title
		System.out.println("Case 3a - The product's title is " + driver.getTitle());
		//15. Verify the product's title is correct
		String expectedtitle3 = "Cart - Mecox Gardens";
		String actualtitle3 = driver.getTitle();
		if (expectedtitle3.equals(actualtitle3))
		{
			System.out.println("Case 3b - The product's title is correct");	
		}
		else
		{
			System.out.println("Case 3b - The product's title is not correct");
		}
		
		//16. Close & Quit Browser
		driver.close();
	    driver.quit();
		

	}

}

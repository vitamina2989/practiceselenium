package WebBrowser;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class baitapso3topic1112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Setting the driver path
	    System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
						
	    //2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
						
		//3. Navigate to web page
		String url = "https://material.angular.io/components/radio/examples";
		driver.get(url);
		
		//4. Maximizing window
		driver.manage().window().maximize();
				
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//6. Close the popup
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-button mat-button-base mat-primary']")).click();
		
		//7. Move to the Rain Sensor checbox
		Actions action = new Actions(driver);
      	action.moveToElement(driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-5']"))).perform();
      	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//7. Verify that Autumn season checkbox is check or not
		WebElement autumn = driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-5']"));
		autumn.click();
		System.out.println ("Autumn season is selected: " + autumn.isDisplayed());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		if (autumn.isDisplayed())
		 {
		    System.out.println ("Autumn season is selected");
		 }
		 else
		 {
			 System.out.println ("Autumn season not selected");
			
		 }
				
		//8. Get text at the selected radio button
		String actualtext = autumn.getText();
		System.out.println("Your chosen season is " + autumn.getText());
		
		//9. Compare with text result
		String resulttext = "Your favorite season is: Autumn";
		AssertJUnit.assertEquals(actualtext,resulttext);
		
        
		
	}

}

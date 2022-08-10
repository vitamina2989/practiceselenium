package WebBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class baiso1topic1112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Setting the driver path
	    System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
						
	    //2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
						
		//3. Navigate to web page
		String url = "https://demos.telerik.com/kendo-ui/checkbox/index";
		driver.get(url);
		
		//4. Maximizing window
		driver.manage().window().maximize();
				
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//6. Accept cookies
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//7. Move to the Rain Sensor checkbox
		Actions action = new Actions(driver);
      	action.moveToElement(driver.findElement(By.xpath("//ul//input[@id='eq6']"))).perform();
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//8. Check the Rain Sensor checkbox & Verify that a checkbox is selected or not
		WebElement checkbox = driver.findElement(By.xpath("//ul//input[@id='eq6']"));
		checkbox.click();
		System.out.println("The checkbox is selected: " + checkbox.isSelected());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//9. Uncheck the Rain Sensor check box by clicking the checkbox again
		checkbox.click();
		
		//10. Verify the checkbox is not selected
		System.out.println("The checkbox is selected: " + checkbox.isSelected());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//11. Close & Quit
		driver.close();
		driver.quit();
		
	}

}

package WebBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class baiso2topic1112 {

	public static void main(String[] args) {
		        // TODO Auto-generated method stub
				//1. Setting the driver path
			    System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
								
			    //2. Creating WebDriver instance
				WebDriver driver = new ChromeDriver();
								
				//3. Navigate to web page
				String url = "https://demos.telerik.com/kendo-ui/radiobutton/index";
				driver.get(url);
				
				//4. Maximizing window
				driver.manage().window().maximize();
						
				//5. Putting implicit wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//6. Accept cookies
				driver.findElement(By.id("onetrust-accept-btn-handler")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				//7. Move to the Rain Sensor checbox
				Actions action = new Actions(driver);
		      	action.moveToElement(driver.findElement(By.xpath("//ul//input[@id='engine2']"))).perform();
		      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				//8. Check the 2nd radio button and Verify it's selected or not
				WebElement radio2 = driver.findElement(By.xpath("//ul//input[@id='engine2']"));
				radio2.click();
				System.out.println ("Radio 2 is selected: " + radio2.isSelected());
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
				//9. Uncheck the 2nd radio button by selecting the 3rd radio button
				WebElement radio3 = driver.findElement(By.xpath("//ul//input[@id='engine3']"));
				radio3.click();
				System.out.println ("Radio 3 is selected: " + radio3.isSelected());
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
			   //10. Verify the 2nd radio button is selected or not
				System.out.println ("Radio 2 is selected: " + radio2.isSelected());
				
			   //11. Close & Exit Browser
				driver.close();
				driver.quit();

	}

}

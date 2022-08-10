package WebBrowser;

import java.util.concurrent.TimeUnit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baitapso2topic13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Setting the driver path
				System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
										
				//2. Creating WebDriver instance
				WebDriver driver = new ChromeDriver();
										
				//3. Navigate to web page
				String url = "https://mecoxcloud.flywheelstaging.com/";
				driver.get(url);
						
				//4. Maximizing window
				driver.manage().window().maximize();
								
				//5. Putting implicit wait
				driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
				
				//6. Hover "About" section (//span[contains(text(),'ABOUT')])[1]
				//Actions action = new Actions(driver);
				//action.moveToElement(driver.findElement(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[@xpath='1']"))).perform();
				//driver.findElements(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[@xpath='1']")).click();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			    List<WebElement> elements = driver.findElements(By.xpath("(//div[contains(@class,'horizontal')])//ul[@id='menu-header-menu-right']//span[@xpath='1']"));
			    System.out.println("Number of elements:" +elements.size());

			   // for (int i=0; i<elements.size();i++){
			    //  System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));

	}


}

package WebBrowser;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baitapso7topic112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Setting the driver path
		System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
												
		//2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
												
		//3. Navigate to web page
		String url = "http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/";
		driver.get(url);
								
		//4. Maximizing window
		driver.manage().window().maximize();
										
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//6. Verify Login button is disabled 
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        if (loginbutton.isEnabled())
        {
        	System.out.println("Login button is enabled");
        }
        else
        {
        System.out.println("Login button is not enabled");
        }
        
        //7. Input data to username, password fields
        String email = "today1905@mailinator.com", password = "Vitamin@1234";
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		
		//8. Verify Login button is enable 
		if (loginbutton.isEnabled())
        {
        	System.out.println("Login button is enabled");
        }
        else
        {
        System.out.println("Login button is not enabled");
        }
		
		//9. Verify Login button has blue in background-color
		String expectedbackgroundcolor = "rgba(56, 112, 245, 1)";
		String logincssValue = loginbutton.getCssValue("background-color");	
		AssertJUnit.assertEquals(expectedbackgroundcolor, logincssValue);
		System.out.println("Login's background color is " + logincssValue);
		
		//10. Quit & Close browser
		driver.quit();
		driver.close();
}
}
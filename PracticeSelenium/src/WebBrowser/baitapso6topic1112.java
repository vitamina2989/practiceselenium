package WebBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baitapso6topic1112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Setting the driver path
		System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
										
		//2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
										
		//3. Navigate to web page
		String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm3";
		driver.get(url);
						
		//4. Maximizing window
		driver.manage().window().maximize();
								
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//6. Click Try it button
		driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//7. Verify the message shown in the alert (Mess: "Hello! I am an alert box!"). Then accept it.
		/*Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
        System.out.println ("Alert text is: " + textOnAlert);*/
		

	}

}

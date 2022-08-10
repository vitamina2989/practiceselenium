package WebBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baiso4topic1112 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//1. Setting the driver path
		System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
								
		//2. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
								
		//3. Navigate to web page
		String url = " https://material.angular.io/components/checkbox/examples";
		driver.get(url);
				
		//4. Maximizing window
		driver.manage().window().maximize();
						
		//5. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		//6. Click checkbox: Checked, Indeterminate
		WebElement checkbox1 = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']"));
		checkbox1.click();
		System.out.println ("Checked item is selected: " + checkbox1.isDisplayed());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement checkbox2 = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-2']"));
		checkbox2.click();
		System.out.println ("Indeterminate item is selected: " + checkbox2.isDisplayed());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//7. Uncheckbox: Checked, Indeterminate
		checkbox1.click();
		System.out.println ("Checked item is selected: " + checkbox1.isSelected());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		checkbox2.click();
		System.out.println ("Indeterminate item is selected: " + checkbox1.isSelected());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//8. Close & Quit Driver
		driver.quit();
		driver.close();	

	}

}

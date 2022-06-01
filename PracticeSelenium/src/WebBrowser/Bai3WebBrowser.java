package WebBrowser;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai3WebBrowser {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
		
	    //1. Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
						
		//2. Navigate to web page
		String url = "http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/";
		driver.get(url);
		
		//3. Maximizing window
		driver.manage().window().maximize();
		
		//4. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//5. Print url of JuggleFish page and Verify the user is on the correct Juggle Fish page
		System.out.println("5. The Juggle Fish url is " + driver.getCurrentUrl());
		
		String expectedurl1 = "http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/";
		String actualurl1 = driver.getCurrentUrl();
		if (expectedurl1.equals(actualurl1))
		{
			System.out.println("5.a Juggle Fish url is correct");	
		}
		else
		{
			System.out.println("5.b Juggle Fish url is not correct");
		}
		
		
		//6. Click Sign up button
		driver.findElement(By.xpath("//div[@class='Header__Wrapper-sbgmwl-0 iQimcS']//button[2]")).click();
		
		//7. Verify Sign up form name
		String signupformname = driver.findElement(By.xpath("(//div[@class='SignupForm__Title-ux6vfh-2 dtDYVx'])")).getText();
		System.out.println("7. The current form name is " + signupformname);
		
		//8. Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//9. Click Back to Login page
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//10. Verify Login form name
		String formname = driver.findElement(By.xpath("//div[@class='Authentication__Title-m0mmlm-2 hJmCmu']")).getText();
		System.out.println("10. The current form name after back from Sign up form is " + formname);
		
       //11. Close & Quit Browser
		driver.close();
		driver.quit();
				
	}
}


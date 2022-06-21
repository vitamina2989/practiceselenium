package WebBrowser;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class bai9 {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		// TODO Auto-generated method stub
				//1. Setting the driver path
			    System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver.exe");
								
			    //2. Creating WebDriver instance
				WebDriver driver = new ChromeDriver();
								
				//3. Navigate to web page
				String url = "http://www.demo.guru99.com/V4/";
				driver.get(url);
				
				//4. Maximizing window
				driver.manage().window().maximize();
						
				//5. Putting implicit wait
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
			   //6. Login
				String userid = "mngr416659" , password = "upAtEze";
				driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userid);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
							
				//7. Putting implicit wait
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		      //8. Navigate to New Customer
				driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
			  //9. Register a new customer
				String name = "Anh Do", dateofbirth = "2/9/1989", 
			    city = "Da Nang", state = "California", pino = "What is",
			    tel =  "0357709999", email = "anh.do@mailinator.com", pass = "Vitamin@1234";
				driver.findElement(By.xpath ("//input[@name='name']")).sendKeys (name);
				driver.findElement(By.xpath ("//input[@value='f']")).click();
				//driver.findElement(By.xpath ("//input[@value='m']")).click();
				driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dateofbirth);
				
				// Print error when entering special characters to address field
				driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("My Villa \n Chu Huy Man,\n Son Tra,\n Da Nang ");
				String actualerrorspecialchacaddress = driver.findElement(By.xpath("//label[@id='message3']")).getText();
				System.out.println ("Error message when entering special characters to address field: " + actualerrorspecialchacaddress);
				String expectederrorspecialchacaddress= "Special characters are not allowed";
				Assert.assertEquals(actualerrorspecialchacaddress,expectederrorspecialchacaddress);
				
							
				driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
				driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
				
				
				// Print error when entering characters instead numeric to PINCODE field
				driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pino);
				String actualpin1errormessage = driver.findElement(By.xpath("//label[@id='message6']")).getText();
				System.out.println ("Error message when entering wrong format to PIN CODE field is : " + actualpin1errormessage);
				String expectepin1errormessage = "Characters are not allowed";
				Assert.assertEquals(actualpin1errormessage,expectepin1errormessage);
				
				
				driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(tel);
				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
								
				//driver.findElement(By.xpath("//input[@value='Reset']")).click();
				//driver.findElement(By.xpath("//input[@name='sub']")).click();
				
				
				//11. Clear name field & Verify error message is displayed when name field is blank
				driver.findElement(By.xpath ("//input[@name='name']")).clear();
				String actualnameerrormessage = driver.findElement(By.xpath("//label[@id='message']")).getText();
				System.out.println ("Error message when leaving name field blank is: " + actualnameerrormessage);
				String expectednameerrormessage = "Customer name must not be blank";
				Assert.assertEquals(actualnameerrormessage,expectednameerrormessage);
				
				//12. Clear Date of birth field & Verify error message is displayed when DOB field is blank
				driver.findElement(By.xpath ("//input[@id='dob']")).clear();
				String actualdoberrormessage = driver.findElement(By.xpath("//label[@id='message24']")).getText();
				System.out.println ("Error message when leaving dob field blank is: " + actualdoberrormessage);
				String expecteddoberrormessage = "Date Field must not be blank";
				Assert.assertEquals(actualdoberrormessage,expecteddoberrormessage);
				
				//13. Clear address & Verify error message is displayed when address is blank
				driver.findElement(By.xpath ("//textarea[@name='addr']")).clear();
				String actualaddresserrormessage = driver.findElement(By.xpath("//label[@id='message3']")).getText();
				System.out.println ("Error message when leaving address field blank is: " + actualaddresserrormessage);
				String expectedaddresserrormessage = "Address Field must not be blank";
				Assert.assertEquals(actualaddresserrormessage,expectedaddresserrormessage);
				
				//14. Clear city & Verify error message is displayed when city is blank
				driver.findElement(By.xpath ("//input[@name='city']")).clear();
				String actualcityserrormessage = driver.findElement(By.xpath("//label[@id='message4']")).getText();
				System.out.println ("Error message when leaving city field blank is: " + actualcityserrormessage);
				String expectedcityerrormessage = "City Field must not be blank";
				Assert.assertEquals(actualcityserrormessage,expectedcityerrormessage);
				
				//14. Clear state & Verify error message is displayed when stage is blank
				driver.findElement(By.xpath ("//input[@name='state']")).clear();
				String actualstateserrormessage = driver.findElement(By.xpath("//label[@id='message5']")).getText();
				System.out.println ("Error message when leaving state field blank is: " + actualstateserrormessage);
				String expectestateerrormessage = "State must not be blank";
				Assert.assertEquals(actualstateserrormessage,expectestateerrormessage);
				
				//15. Clear PINCOde & Verify error message is displayed when PINCODE is blank
				driver.findElement(By.xpath ("//input[@name='pinno']")).clear();
				String actualpinserrormessage = driver.findElement(By.xpath("//label[@id='message6']")).getText();
				System.out.println ("Error message when leaving PIN CODE field blank is: " + actualpinserrormessage);
				String expectepinerrormessage = "PIN Code must not be blank";
				Assert.assertEquals(actualpinserrormessage,expectepinerrormessage);
				
				//16. Clear Mobile & Verify error message is displayed when Mobile is blank
				driver.findElement(By.xpath ("//input[@name='telephoneno']")).clear();
				String actualmobserrormessage = driver.findElement(By.xpath("//label[@id='message7']")).getText();
				System.out.println ("Error message when leaving Mobile field blank is: " + actualmobserrormessage);
				String expectemoberrormessage = "Mobile no must not be blank";
				Assert.assertEquals(actualmobserrormessage,expectemoberrormessage);
				
				//17. Clear Email & Verify error message is displayed when email is blank
				driver.findElement(By.xpath ("//input[@name='emailid']")).clear();
				String actualemailserrormessage = driver.findElement(By.xpath("//label[@id='message9']")).getText();
				System.out.println ("Error message when leaving Email field blank is: " + actualemailserrormessage);
				String expecteemailerrormessage = "Email-ID must not be blank";
				Assert.assertEquals(actualemailserrormessage,expecteemailerrormessage);
				
				//18. Clear Password & Verify error message is displayed when password is blank
				driver.findElement(By.xpath ("//input[@name='password']")).clear();
				String actualpassserrormessage = driver.findElement(By.xpath("//label[@id='message18']")).getText();
				System.out.println ("Error message when leaving Password field blank is: " + actualpassserrormessage);
				String expectepasserrormessage = "Password must not be blank";
				Assert.assertEquals(actualpassserrormessage,expectepasserrormessage);
				
				//19. Quit & Close
			    driver.quit();
			    driver.close();
	}

}

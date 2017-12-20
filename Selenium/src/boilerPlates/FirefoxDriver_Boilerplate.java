package boilerPlates;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxDriver_Boilerplate {
	FirefoxDriver driver; 
	
	
	@BeforeMethod
	public void bmet()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe"); //required b/c selenium is dumb
		driver = new FirefoxDriver(); 
		driver.get("https://qa.brainpop.com");
	}
	
	@Test
	public void tcase4() 
	{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementById("login_button").click();
		System.out.println("User name visibility: " + driver.findElementByXPath("//*[@id=\"username\"]").isDisplayed());
	
		driver.findElementById("username").sendKeys("somethingsomething");
		driver.findElementById("password").sendKeys("darkside");
		driver.findElementById("perform_login").click();
		driver.findElementById("user_menu");
		driver.findElementById("keyword").sendKeys("Nouns");
		
		
		// Confirm web page navigation
		String actualURL = driver.getCurrentUrl();
		if(actualURL.startsWith("https://qa.brainpop.com/my-brainpop/teacher-registration/"))
		{
			System.out.println("Title verified!");
		}
		else
		{
			System.out.println("You're not in teacher registration.");
		}

	}
	
	@AfterMethod
	public void amet()
	{
		driver.quit();
	}
}
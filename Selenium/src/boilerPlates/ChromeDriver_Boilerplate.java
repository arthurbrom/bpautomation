package boilerPlates;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeDriver_Boilerplate {
	ChromeDriver driver; 
	
	
	@BeforeMethod
	public void bmet()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe"); //required b/c selenium is dumb
		driver = new ChromeDriver(); 
		driver.get("https://qa.brainpop.com");
	}
	
	@Test
	public void tcase4() 
	{

		driver.findElementById("login_button").click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
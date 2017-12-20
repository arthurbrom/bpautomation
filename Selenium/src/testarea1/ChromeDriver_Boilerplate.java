package testarea1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeDriver_Boilerplate {
	ChromeDriver driver; 
	
	// This is a comment just for the sake of editing 
	
	@BeforeMethod
	public void bmet()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe"); //required b/c selenium is dumb
		driver = new ChromeDriver(); 
		driver.get("https://qa.brainpop.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test
	public void tcase1() 
	{

		System.out.println("This is total test.");

	}
	
	@AfterMethod
	public void amet()
	{
		driver.quit();
	}
}
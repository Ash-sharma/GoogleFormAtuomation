package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class BaseClass {
	

	public String baseURL = "https://docs.google.com/forms/d/e/1FAIpQLSdOAFfCsdXsQCOiqejWcxHoPlopDjsA4TDmXTRbSQ__pM2xvQ/viewform";
	public static WebDriver driver;
	
	String os = System.getProperty("os.name").toLowerCase();
	
	@BeforeMethod
	public void setup()
	{
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver");
		}
		else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
		}
			
		driver = new ChromeDriver();
		
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	

	public String baseURL = "https://docs.google.com/forms/d/e/1FAIpQLSdOAFfCsdXsQCOiqejWcxHoPlopDjsA4TDmXTRbSQ__pM2xvQ/viewform";
	public static WebDriver driver;
	
//	String os = System.getProperty("os.name").toLowerCase();
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver");
//		if(os.contains("mac")) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver");
//		}
//		else {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
//		}
			
		driver = new ChromeDriver();
		
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@AfterClass 
	public void tearDown()
	{
		driver.quit();
	}
	
}

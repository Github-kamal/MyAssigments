package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void precondition()
	{
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--disable-notifications");	
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Load the URL 
		
		driver.get("https://login.salesforce.com");
			
	}
	@AfterMethod
	public void postcondition()
		{
		driver.close();

}
	}

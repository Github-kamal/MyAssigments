package week5.assignments;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class StaticParameterization {
	public RemoteWebDriver driver;
	@Parameters({"url","username","password"})
	@Test
	
	public void optimizingTestCase (String url, String username, String password) {
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		//login 
		driver.findElement(By.id("Login")).click();
		//Toggle Button Menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//viewall
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click legal entities
		WebElement element = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", element);
		//Click new
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		// Enter name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf");
		// Enter name
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf Ltd");
		//Enter Description as Salesforces
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Salesforces");
		//Select Active
		WebElement status = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", status);
		driver.findElement(By.xpath("//span[@title='Active']")).click();
		
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	
		
		//Get Text
		String alrtTxt = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']//following::a")).getText();
		System.out.println(alrtTxt);
		driver.close();

	}

}

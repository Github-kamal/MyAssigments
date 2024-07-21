package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) {
		// Initialize the WebDriver (ChromeDriver)
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Enter a username and password
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("demosalesmanager");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("crmsfa");
				
		//Click on Submit Button
		WebElement submitButton = driver.findElement(By.className("decorativeSubmit"));
		submitButton.click();
						
		// Click on the "CRM/SFA" link
		driver.findElement(By.xpath("(//div[@class='crmsfa'])/a")).click();

						
		//Click on the "Leads" tab.
		driver.findElement(By.linkText("Leads")).click();	

		//Click on the "Create Lead" button.
		driver.findElement(By.linkText("Create Lead")).click();
		
		
		//Enter a FirstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("KAMAL");
		
		//Enter a LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
		
		//Enter a CompanyName
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("EXPLEO");
		
		//Enter a Title
		driver.findElement(By.xpath("//input[@name='generalProfTitle']")).sendKeys("MR");
		
		
		//Click the "Create Lead" button.
		driver.findElement(By.className("smallSubmit")).click();
		
		//Verify that the Title is displayed correctly.
		String leadId = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Lead created "+leadId);
		
		System.out.println("page titile :"+driver.getTitle());
		
		//close the window
		driver.close();
		

	}

}

package week2.homeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		//Initialize the WebDriver (ChromeDriver).
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String aName = "Kamalesh";
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/");
		
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
		Thread.sleep(1000);
		
		//Click on the "Accounts" tab
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();	
		Thread.sleep(1000);
		
		//Click on the "Create Account" button.
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		
		//Enter an account name.
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys(aName);
		
		//Enter a description as "Selenium Automation Tester."
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		
		
		//- Select "ComputerSoftware" as the industry. 
		Select industry = new Select (driver.findElement(By.xpath("//Select[@name='industryEnumId']")));
		industry.selectByValue("IND_SOFTWARE");
		
		
		//- Select "S-Corporation" as ownership using SelectByVisibleText.
		Select ownership = new Select (driver.findElement(By.xpath("//Select[@name='ownershipEnumId']")));
		ownership.selectByVisibleText("S-Corporation");
		
		//- Select "Employee" as the source using SelectByValue. 
		Select source = new Select (driver.findElement(By.xpath("//Select[@name='dataSourceId']")));
		source.selectByValue("LEAD_EMPLOYEE");
		
		//- Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
		Select campaign = new Select (driver.findElement(By.xpath("//select[@id='marketingCampaignId']")));
		campaign.selectByIndex(6);
		//- Select "Texas" as the state/province using SelectByValue. 
		Select state = new Select (driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']")));
		state.selectByValue("TX");
		//- Click the "Create Account" button. 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		//- Verify that the account name is displayed correctly. 
		String accname = driver.findElement(By.xpath("(//span[text()=\"Account Name\"])/following::span[1]")).getText();
		
		if (accname.contains(aName))
		{
			System.out.println("Account created sucessfully for :"+accname);
		}
		else
			System.out.println("Account not created ");
		//- Close the browser window.
		
		
		driver.close();
		
		
		
		
	}
}

package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class CreateAccountSF {
	public static void main(String[] args) {
		

	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://login.salesforce.com");
	//User name 
	driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");	
	//Password
	driver.findElement(By.id("password")).sendKeys("testleaf@2024");
	//Clicl login
	driver.findElement(By.id("Login")).click();

	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	driver.findElement(By.xpath("//button[text()='View All']")).click();

	WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
	driver.executeScript("arguments[0].click();", sales);

	WebElement acc = driver.findElement(By.xpath("//span[text()='Accounts']"));
	driver.executeScript("arguments[0].click();", acc);

	WebElement newAcc = driver.findElement(By.xpath("//div[@title='New']"));
	driver.executeScript("arguments[0].click();", newAcc);

	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Kamalesh");

	WebElement ownership = driver.findElement(By.xpath("//label[text()='Ownership']/following::button"));
	driver.executeScript("arguments[0].click();", ownership);
	WebElement ownershipType = driver.findElement(By.xpath("//span[text()='Public']"));
	driver.executeScript("arguments[0].click();", ownershipType);
	

	WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
	driver.executeScript("arguments[0].click();", save);


	System.out.println("Account created successfully");
	
	driver.close();
	
	}

}

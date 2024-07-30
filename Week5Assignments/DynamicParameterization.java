package week5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicParameterization {
	
	@Test(dataProvider="sendData")
	public void DynamicParameterization(String cname,String fname, String lname) {
		
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Load the URL 
		driver.get("https://login.salesforce.com");
		//User name 
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");	
		//Password
		driver.findElement(By.id("password")).sendKeys("testleaf@2024");
		
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
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by "+fname);
		// Enter Compamyname
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(cname);
		//Enter Description as 'Salesforces'.
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys(lname);
		//Select Active
		WebElement status = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", status);
		driver.findElement(By.xpath("//span[@title='Active']")).click();
		
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	
		
		
		//Get Text
		 //driver.switchTo().alert();
		//Alert alert = driver.switchTo().alert();
		String alrtTxt = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']//following::a")).getText();
		System.out.println(alrtTxt);
		driver.close();
		
		
		}
	@DataProvider
	public String[][] sendData() {
		String[][] data = new String[2][3];	
		
		data[0][0] = "BOFA";
		data[0][1] = "KAMAL";
		data[0][2] = "BASKAR";
		
		data[1][0] = "EXPLEO";
		data[1][1] = "KAMALESH";
		data[1][2] = "B";
		
		return data;
		
	
	}

}

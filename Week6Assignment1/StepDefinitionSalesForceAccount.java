package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionSalesForceAccount  extends ProjectSpecificMethod{

		
	@Given("Login to Salesforce")
	public void login_to_salesforce() {
		
		//User name 
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");	
		//Password
		driver.findElement(By.id("password")).sendKeys("testleaf@2024");
		driver.findElement(By.id("Login")).click();

	}	 

	@Given("Click on toggle menu button")
	public void click_on_toggle_menu_button() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}

	@Given("Click view All")
	public void click_view_all() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();

	}

	@Given("click Sales from App Launcher")
	public void click_sales_from_app_launcher() 
	{
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].click();", sales);
		}

	@Given("Click on Accounts tab")
	public void click_on_accounts_tab() 
	{
		WebElement acc = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", acc);
		}

	@Given("Click on New button")
	public void click_on_new_button() {
		WebElement newAcc = driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();", newAcc);
	}

	@Given("Enter {string} as account name")
	public void enter_as_account_name(String uname) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(uname);
		}

	@Given("Select Ownership as Public")
	public void select_ownership_as_public() {
		WebElement ownership = driver.findElement(By.xpath("//label[text()='Ownership']/following::button"));
		driver.executeScript("arguments[0].click();", ownership);
		WebElement ownershipType = driver.findElement(By.xpath("//span[text()='Public']"));
		driver.executeScript("arguments[0].click();", ownershipType);

	}

	@When("Click on save")
	public void click_on_save() {
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();", save);
	
;	}

	@Then("verify Account name")
	public void verify_account_name() {
		WebElement accName = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']//div"));
		System.out.println("Account created successfully:" +accName.getText());

	}

}

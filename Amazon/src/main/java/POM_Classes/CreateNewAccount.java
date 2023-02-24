package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewAccount 
{
	@FindBy (xpath = "//span[text()='Account & Lists']")
	private WebElement accountLists;
	
	@FindBy (xpath = "(//a[text()='Start here.'])[1]")
	private WebElement starthere;
	
	@FindBy (xpath = "//input[@name='customerName']")
	private WebElement firstName;
	
	@FindBy (xpath = "//span[contains(text(), 'IN +91')]")
	private WebElement countryCode;
	
	@FindBy (xpath = "//option[@value='IN']")
	private WebElement india;
	
	@FindBy (xpath = "//input[@type='tel']")
	private WebElement mobile;
	
	@FindBy (xpath = "//input[@type='email']")
	private WebElement email;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continue2;
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	public CreateNewAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void clickOnStartHereButton()
	{
		wait.until(ExpectedConditions.visibilityOf(accountLists));
		act.moveToElement(accountLists).build().perform();
		act.moveToElement(starthere).build().perform();
		starthere.click();
	}
	
	public void sendFirstName()
	{
		firstName.click();
		firstName.sendKeys("Neha");
	}
	
	public void sendMobile()
	{
		if(countryCode.equals(india))
		{
			mobile.click();
			mobile.sendKeys("8600921238");
		}
		else
		{
			india.click();
			mobile.click();
			mobile.sendKeys("8600921238");
		}
	}
	
	public void sendEmail()
	{
		email.click();
		email.sendKeys("neha.gaikwad1993@gamil.com");
	}
	
	public void sendPassword()
	{
		password.click();
		password.sendKeys("nehacker");
	}
	

	public void clickOnContinue2Button()
	{
		continue2.click();
	}
	
}

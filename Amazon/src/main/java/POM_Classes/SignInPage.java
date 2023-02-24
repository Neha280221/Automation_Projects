package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage 
{
	@FindBy (xpath = "//input[@type='email']")
	private WebElement emailOrPhoneNo;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy (xpath = "//a[@id='createAccountSubmit']")
	private WebElement createNewAccount;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//a[contains(text(),'Forgot')]")
	private WebElement forgotPassword;
	
	@FindBy (xpath = "//span[contains(text(),'OTP')]")
	private WebElement getOTP;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signIn;
	
	@FindBy (xpath = "//span[text()='Account & Lists']")
	private WebElement accountLists;
	
	@FindBy (xpath = "//span[(text()='Sign in')]")
	private WebElement sign;
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnSignInButton()
	{
		wait.until(ExpectedConditions.visibilityOf(accountLists));
		act.moveToElement(accountLists).build().perform();
		act.moveToElement(sign).build().perform();
		sign.click();
	}
	
	public void sendEmailOrPhoneNo()
	{
		emailOrPhoneNo.click();
		emailOrPhoneNo.sendKeys("neha.gaikwad1993@gmail.com");
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void sendPassword()
	{
		password.click();
		password.sendKeys("nehar280221");
	}
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public void createNewAccount()
	{
		createNewAccount.click();
	}
	
	public void forgotPassword()
	{
		forgotPassword.click();
	}
	
	public void getAnOTP()
	{
		getOTP.click();
	}
	
}

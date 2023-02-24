package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage 
{

	// Variable : WebElement : Login Or Sing Up Page
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement emailOrPhoneNo;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//a[contains(text(), 'Forgotten')]")
	private WebElement forgotPassword;
	
	@FindBy (xpath = "//a[contains(text(), 'account')]")
	private WebElement createNewAccount;
	
	@FindBy (xpath = "//a[contains(text(), 'Create a Page')]")
	private WebElement createAPage;
	
	// Constructor : Initialization of WebElement : Login Or Sing Up Page
	
	public LoginOrSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods : Action on WebElement : Login Or Sing Up Page
	
	public void sendEmailOrPhoneNo(String data)
	{
		emailOrPhoneNo.click();
		emailOrPhoneNo.sendKeys(data);
	}
	
	public void sendPassword(String data)
	{
		password.click();
		password.sendKeys(data);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void clickOnForgotPassword()
	{
		forgotPassword.click();
	}
	
	public void openSignUpForm()
	{
		createNewAccount.click();
	}
	
	public void clickOnCreateAPage()
	{
		createAPage.click();
	}
	
	public void login()
	{
		emailOrPhoneNo.sendKeys("neha.gaikwad1993@gmail.com");
		password.sendKeys("nehar280221");
		loginButton.click();
	}
	
}

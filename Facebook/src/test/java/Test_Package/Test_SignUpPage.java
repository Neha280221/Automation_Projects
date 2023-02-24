package Test_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.LoginOrSignUpPage;
import POM_Classes.SignUpPage;

public class Test_SignUpPage 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.openSignUpForm();
		
		Thread.sleep(7000);
		
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.sendFirstName();
		signUpPage.sendLastName();
		signUpPage.sendmobileOrEmail();
		signUpPage.sendReEnterEmail();
		signUpPage.sendNewPassword();
		signUpPage.selectDateOfBirth();
		//Thread.sleep(2000);
		signUpPage.selectMonthOfBirth();
		//Thread.sleep(2000);
		signUpPage.selectYearOfBirth();
		signUpPage.selectGender();
		//signUpPage.clickOnSignUp();
		
		signUpPage.clickOnTermsLink();
		signUpPage.childBrowser();
	
		signUpPage.clickOnPrivacyPolicyLink();
		signUpPage.childBrowser();
		
		signUpPage.clickOnCookiesPolicyLink();
		signUpPage.childBrowser();
		
	}
	
}

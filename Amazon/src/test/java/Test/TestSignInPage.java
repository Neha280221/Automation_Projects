package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.SignInPage;


public class TestSignInPage 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		SignInPage signInPage = new SignInPage(driver);
		
		signInPage.clickOnSignInButton();
		Thread.sleep(2000);
		signInPage.sendEmailOrPhoneNo();
		signInPage.clickOnContinueButton();
		Thread.sleep(2000);
		signInPage.sendPassword();
		signInPage.clickOnSignIn();
		Thread.sleep(2000);
		driver.close();

	}	

}

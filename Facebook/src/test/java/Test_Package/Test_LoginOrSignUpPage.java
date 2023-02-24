package Test_Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.LoginOrSignUpPage;

public class Test_LoginOrSignUpPage 
{
	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		
		loginOrSignUpPage.login();
		loginOrSignUpPage.clickOnForgotPassword();	
		loginOrSignUpPage.openSignUpForm();
		loginOrSignUpPage.clickOnCreateAPage();
			
	}

}

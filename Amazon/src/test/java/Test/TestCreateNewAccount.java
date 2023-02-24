package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.CreateNewAccount;
public class TestCreateNewAccount 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		CreateNewAccount createNewAccount = new CreateNewAccount(driver);
		createNewAccount.clickOnStartHereButton();
		Thread.sleep(3000);
		createNewAccount.sendFirstName();
		createNewAccount.sendMobile();
		//createNewAccount.sendEmail();
		createNewAccount.sendPassword();
		createNewAccount.clickOnContinue2Button();
		Thread.sleep(2000);
		driver.close();
	}
		
}

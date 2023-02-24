package TestNG_Package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM_Classes.LoginOrSignUpPage;
import POM_Classes.SignUpPage;
import Utils.Utility;

public class TestNG_SignUpPage 
{
	WebDriver driver;
	LoginOrSignUpPage loginOrSignUpPage;
	SignUpPage signUpPage;
	private String testID;
	
	@Parameters ("browser")
	@BeforeTest
	
	public void launchBrowser(String browserName)
	{
		System.out.println(browserName);
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@BeforeClass
	
	public void cretePOMObjects()
	{
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		signUpPage = new SignUpPage(driver);
	}
	
	@BeforeMethod
	public void gotoSignUpPage() throws IOException
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");	
	
		loginOrSignUpPage.openSignUpForm();
		
	}
	
	@Test
	public void verifyTermsLink() throws InterruptedException
	{
		testID = "Terms";
		//SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickOnTermsLink();
		
		// Child Browser

		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		// For storing Actual url ie. url from UI

		String url = driver.getCurrentUrl();
		
		// Comparison of actual url and expected url ie. url.equals(expected url)
		
		if(url.equals("https://www.facebook.com/legal/terms/update"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver.close();
		driver.switchTo().window(addr.get(0));
		
	}
	
	
	@Test
	public void verifyPrivacyPolicyLink() throws InterruptedException
	{
		testID = "Privacy";
		//SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickOnPrivacyPolicyLink();		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String url = driver.getCurrentUrl();
		
		if(url.equals("https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver.close();
		driver.switchTo().window(addr.get(0));
	}
	
	@Test
	public void verifyCookiesPolicyLink() throws InterruptedException
	{
		testID = "Cookies";
		//SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickOnCookiesPolicyLink();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String url = driver.getCurrentUrl();
		
		// This test case is done intentionally fail
		if(url.equals("https://www.facebook.com/privacy/policies/cookies1/?entry_point=cookie_policy_redirect&entry=0"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver.close();
		driver.switchTo().window(addr.get(0));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException
	{
		System.out.println("After Method");
		String methodname = result.getName().toString().trim();
		System.out.println(methodname);
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, testID);
		}
		
	}
	
	@AfterClass
	public void clearPOMObjects()
	{
		signUpPage = null;
		loginOrSignUpPage = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		
		System.gc();    // Garbage collector
	}

}

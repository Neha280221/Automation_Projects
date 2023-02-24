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
import Utils.Utility;

public class TestNG_LoginOrSignUpPage 
{
	WebDriver driver;
	LoginOrSignUpPage loginOrSignUpPage;
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
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@BeforeClass
	
	public void cretePOMObjects()
	{
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
	}
	
	@BeforeMethod
	public void gotoSignUpPage() throws IOException
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");	
	
	}
	
	@Test
	public void verifyLogin() throws InterruptedException, IOException
	{
		testID = "Login";

		String data = Utility.getDataFromExcelSheet("TestData", 3, 0);
		loginOrSignUpPage.sendEmailOrPhoneNo(data);
		
		data = Utility.getDataFromExcelSheet("TestData", 3, 1);
		loginOrSignUpPage.sendPassword(data);
		
		loginOrSignUpPage.login();
		
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
	public void verifyForgotPassword() throws InterruptedException, IOException
	{
		testID = "ForgotPass";

		loginOrSignUpPage.clickOnForgotPassword();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		// For storing Actual url ie. url from UI

		String url = driver.getCurrentUrl();
		
		// Comparison of actual url and expected url ie. url.equals(expected url)
		
		if(url.equals("https://www.facebook.com/login/identify/?ctx=recover&"
				+ "ars=facebook_login&from_login_screen=0"))
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
	public void verifyCreateAPage() throws InterruptedException, IOException
	{
		testID = "CreatePage";

		loginOrSignUpPage.clickOnCreateAPage();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		// For storing Actual url ie. url from UI

		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		// Comparison of actual url and expected url ie. url.equals(expected url)
		
		if(url.equals("https://www.facebook.com/pages/create/?ref_type=registration_form"))
		{				
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	//	driver.close();
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
	//	loginOrSignUpPage = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
	//	driver.quit();
	//	driver = null;
		
		System.gc();    // Garbage collector
	}

}




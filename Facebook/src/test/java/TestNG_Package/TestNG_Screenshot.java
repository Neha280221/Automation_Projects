package TestNG_Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.Utility;

public class TestNG_Screenshot 
{
	WebDriver driver;
	private String testID;
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
	}
	
	@Test 
	public void testA()
	{
		testID = "A1";
		System.out.println("TestA");
		System.out.println("Pass");
	}
	
	@Test 
	public void testB()
	{
		testID = "B1";
		System.out.println("TestB");
		//Assert.fail();
	//	System.out.println("Fail");
	}
	
	@Test 
	public void testC() throws IOException
	{
		testID = "C1";
		System.out.println("TestC");
		System.out.println("Pass");
		
		String data = Utility.getDataFromExcelSheet("TestData", 1, 0);
		System.out.println(data);
		data = Utility.getDataFromExcelSheet("TestData", 1, 1);
		System.out.println(data);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException
	{
		System.out.println("After Method");
//		String methodname = result.getName();
//		System.out.println(methodname);
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, testID);
		}
		
    }
	
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}

}

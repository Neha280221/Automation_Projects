package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup 
{
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
		
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
		
	public static WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
		
}

/*public class TestNG_OpenBrowser 
{
	WebDriver driver;
	
	@Parameters ("browser")
	@BeforeTest
	
	public void launchBrowser(String browserName)
	{
		System.out.println(browserName);
		
		if(browserName.equals("Chrome"))
		{
			driver = BrowserSetup.openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = BrowserSetup.openFirefoxBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = BrowserSetup.openEdgeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}*/

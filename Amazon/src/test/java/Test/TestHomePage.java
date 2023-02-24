package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.HomePage;

public class TestHomePage 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neha\\Desktop\\Velocity Class\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
	
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnSelectAddress();
		homePage.clickOnSearchTab();
		homePage.clickOnSubmitSearchIcon();
		homePage.clickOnLanguageSelectIcon();
		homePage.clickOnAccountAndLists();
		homePage.clickOnReturnAndOrders();
		homePage.clickOnCart();
		homePage.clickOnDownloadApp();
		homePage.clickOnAllMenu();
		homePage.clickOnAmazonMiniTV();
		homePage.clickOnSell();
		homePage.clickOnBestSellers();
		homePage.clickOnMobiles();
		homePage.clickOnCustomerService();
		homePage.clickOnTodaysDeal();
		homePage.clickOnElectronics();
		homePage.clickOnAmazonPay();
		homePage.clickOnPrime();
		
	}

}

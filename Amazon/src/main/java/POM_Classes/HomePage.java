package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	@FindBy (xpath = "//div[@id='nav-global-location-slot']")
	private WebElement selectAddress;
	
	@FindBy (xpath = "//div[@class='nav-search-field ']")
	private WebElement searchTab;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement submitSearch;
	
	@FindBy (xpath = "//a[@id='icp-nav-flyout']")
	private WebElement language;
	
	@FindBy (xpath = "//a[@id='nav-link-accountList']")
	private WebElement accountAndList;
	
	@FindBy (xpath = "//a[@id='nav-orders']")
	private WebElement returnsAndOrders;
	
	@FindBy (xpath = "//a[@id='nav-cart']")
	private WebElement cart;
	
	@FindBy (xpath = "//div[@id='nav-swmslot'] ")
	private WebElement downloadApp;
	
	@FindBy (xpath = "//a[@aria-label='Open Menu']")
	private WebElement allMenu;
	
	@FindBy (xpath = "//a[text()='Amazon miniTV']")
	private WebElement amazonMiniTV;
	
	@FindBy (xpath = "//a[text()='Sell']	")
	private WebElement sell;
	
	@FindBy (xpath = "//a[text()='Best Sellers']")
	private WebElement bestSellers;
	
	@FindBy (xpath = "//a[text()='Mobiles']")
	private WebElement mobiles;
	
	@FindBy (xpath = "//a[text()='Customer Service']")
	private WebElement customerService;
	
	@FindBy (xpath = "//a[text()='Today's Deals']	")
	private WebElement todaysDeal;
	
	@FindBy (xpath = "//a[text()=' Electronics ']")
	private WebElement electronics;
	
	@FindBy (xpath = "//a[text()='Amazon Pay']")
	private WebElement amazonPay;
	
	@FindBy (xpath = "//span[text()='Prime']")
	private WebElement prime;
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void clickOnSelectAddress()
	{
		selectAddress.click();
		act.moveToElement(selectAddress).build().perform();
	}

	public void clickOnSearchTab()
	{
		searchTab.click();
		act.moveToElement(searchTab).build().perform();
	}
	
	public void clickOnSubmitSearchIcon()
	{
		submitSearch.click();
		act.moveToElement(submitSearch).build().perform();
	}
	
	public void clickOnLanguageSelectIcon()
	{
		language.click();
		act.moveToElement(language).build().perform();
	}
	
	public void clickOnAccountAndLists()
	{
		accountAndList.click();
		act.moveToElement(accountAndList).build().perform();
	}
	
	public void clickOnReturnAndOrders()
	{
		returnsAndOrders.click();
		act.moveToElement(returnsAndOrders).build().perform();
	}
	
	public void clickOnCart()
	{
		cart.click();
		act.moveToElement(cart).build().perform();
	}
	
	public void clickOnDownloadApp()
	{
		downloadApp.click();
		act.moveToElement(downloadApp).build().perform();
	}
	
	public void clickOnAllMenu()
	{
		allMenu.click();
		act.moveToElement(allMenu).build().perform();
	}
	
	public void clickOnAmazonMiniTV()
	{
		amazonMiniTV.click();
		act.moveToElement(amazonMiniTV).build().perform();
	}
	
	public void clickOnSell()
	{
		sell.click();
		act.moveToElement(sell).build().perform();
	}
	
	public void clickOnBestSellers()
	{
		bestSellers.click();
		act.moveToElement(bestSellers).build().perform();
	}
	
	public void clickOnMobiles()
	{
		mobiles.click();
		act.moveToElement(mobiles).build().perform();
	}
	
	public void clickOnCustomerService()
	{
		customerService.click();
		act.moveToElement(customerService).build().perform();
	}
	
	public void clickOnTodaysDeal()
	{
		todaysDeal.click();
		act.moveToElement(todaysDeal).build().perform();
	}
	
	public void clickOnElectronics()
	{
		electronics.click();
		act.moveToElement(electronics).build().perform();
	}
	
	public void clickOnAmazonPay()
	{
		amazonPay.click();
		act.moveToElement(amazonPay).build().perform();
	}
	
	public void clickOnPrime()
	{
		prime.click();
		act.moveToElement(prime).build().perform();
	}
	
}

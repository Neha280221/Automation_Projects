package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAddToCart 
{
	@FindBy (xpath = "(//div[@data-normaliseheight='false']/div)[1]")
	private WebElement firstMobile;
	
	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
	@FindBy (xpath = "//span[text()=' Cart ']")
	private WebElement cartButton;
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	public ProductAddToCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnFirstMobile()
	{
	//	wait.until(ExpectedConditions.visibilityOf(accountLists));
	//	act.moveToElement(accountLists).build().perform();
	//	act.moveToElement(sign).build().perform();
		firstMobile.click();
	}
	
	public void clickOnAddToCartButton()
	{
		addToCart.click();
	}
	
	public void clickOnCartButton()
	{
		cartButton.click();
	}
	
	
	
	
}

package POM_Classes;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage 
{
	// Variable : WebElement : Login Or Sing Up Page
	
		@FindBy (xpath = "//input[@name='firstname']")
		private WebElement firstName;
		
		@FindBy (xpath = "//input[@name='lastname']")
		private WebElement lastName;
		
		@FindBy (xpath = "//input[@name='reg_email__']")
		private WebElement mobileOrEmail;
		
		@FindBy (xpath = "//input[@aria-label='Re-enter email address']")
		private WebElement reEnterEmail;
		
		@FindBy (xpath = "//input[@autocomplete='new-password']")
		private WebElement newPassword;
		
		@FindBy (xpath = "//select[@id='day']")
		private WebElement day;
//		@FindBy (xpath = "//option[text()='21']")
//		private WebElement selectDay;
		
		@FindBy (xpath = "//select[@id='month']")
		private WebElement month;
//		@FindBy (xpath = "//option[text()='Sep']")
//		private WebElement selectMonth;
		
		@FindBy (xpath = "//select[@id='year']")
		private WebElement year;
//		@FindBy (xpath = "//option[text()='1993']")
//		private WebElement selectYear;
		
		@FindBy (xpath = "//button[@name='websubmit']")
		private WebElement signUp;
		
		@FindBy (xpath = "//span[@data-type=\"radio\"]")
		private WebElement gender;
		
		@FindBy (xpath = "//label[text()='Female']")
		private WebElement female;
		
		@FindBy (xpath = "//a[@id='terms-link']")
		private WebElement terms;
		
		@FindBy (xpath = "//a[@id='privacy-link']")
		private WebElement privacy;
		
		@FindBy (xpath = "//a[@id='cookie-use-link']")
		private WebElement cookies;
		
		private WebDriver driver;
		private Actions act;
		private WebDriverWait wait;
		
		// Constructor : Initialization of WebElement : Login Or Sing Up Page
		
		public SignUpPage(WebDriver driver)  // 
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;                     // Initialize the global driver
			wait = new WebDriverWait(driver, 20); // 20 sec--\*-
			act = new Actions(this.driver);
			// Or
			// act = new Actions(driver);
			
		}
		
		// Methods : Action on WebElement : Login Or Sing Up Page
		
		public void sendFirstName()
		{
			firstName.click();
			firstName.sendKeys("Neha");
		}
		
		public void sendLastName()
		{
			lastName.click();
			lastName.sendKeys("Kenjale");
		}
		
		public void sendmobileOrEmail()
		{
			mobileOrEmail.click();
			mobileOrEmail.sendKeys("neha.gaikwad1993@gmail.com");			
		}
		
		public void sendReEnterEmail()
		{
			reEnterEmail.click();
			reEnterEmail.sendKeys("neha.gaikwad1993@gmail.com");			
		}
		
		public void sendNewPassword()
		{
			newPassword.click();
			newPassword.sendKeys("nehar280221");
		}
		
		public void selectDateOfBirth()
		{
			Select s = new Select(day);
			s.selectByValue("21");
		}
		
		public void selectMonthOfBirth()
		{
			Select s = new Select(month);
			s.selectByVisibleText("Sep");
		}
		
		public void selectYearOfBirth()
		{
			Select s = new Select(year);
			s.selectByValue("1993");
		}
		
		public void selectGender()
		{
			if(gender.isSelected())
			{
				// Actions act = new Actions(driver);
				act.moveToElement(female).click().build().perform();
			}
			// Actions act = new Actions(driver);
			act.moveToElement(female).click().build().perform();
		}
		
		public void clickOnSignUp()
		{
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(signUp));
			// Actions act = new Actions(driver);
			act.moveToElement(signUp).click().build().perform();
		}
		
		public void clickOnTermsLink()
		{
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(terms));
			// Actions act = new Actions(driver);
			act.moveToElement(terms).click().build().perform();
		}
		
		public void clickOnPrivacyPolicyLink()
		{
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(privacy));
			// Actions act = new Actions(driver);
			act.moveToElement(privacy).click().build().perform();
		}
		
		public void clickOnCookiesPolicyLink()
		{
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(cookies));
			// Actions act = new Actions(driver);
			act.moveToElement(cookies).click().build().perform();
		}
		
		public void childBrowser() throws InterruptedException 
		{
			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			Thread.sleep(5000);
			driver.close();
			driver.switchTo().window(addr.get(0));
		}
		
}

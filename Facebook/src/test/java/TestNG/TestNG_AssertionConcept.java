package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_AssertionConcept 
{
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	SoftAssert soft;
	
	@Test 
	public void HardAssert()
	{
		System.out.println("HardAssert");
		String actualUrl = "https://www.facebook.com/";
		String expectedUrl = "https://www.facebook.com/";
		
		String actualTitle = "Facebook - Login or Sign Up";
		String expectedTitle = "Facebook - Login or Sign Up/home";
		
		String actualName = "Submit";
		String expectedName = "Submit";
		
		Assert.assertEquals(actualUrl, expectedUrl, "Homepage URL is not found");
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage Title is not found");
		Assert.assertEquals(actualName, expectedName, "Submit button text is wrong");
		
	} 
	
	@Test 
	public void SoftAssert()
	{
		soft = new SoftAssert();
		System.out.println("SoftAssert");
		String actualUrl = "https://www.facebook.com/";
		String expectedUrl = "https://www.facebook.com/home";
		
		String actualTitle = "Facebook - Login or Sign Up";
		String expectedTitle = "Facebook - Login or Sign Up";
		
		String actualName = "Submit";
		String expectedName = "Submit123";
		
		soft.assertEquals(actualUrl, expectedUrl, "Homepage URL is not found");
		soft.assertEquals(actualTitle, expectedTitle, "Homepage Title is not found");
		soft.assertEquals(actualName, expectedName, "Submit button text is wrong");

		soft.assertAll();
		
	} 
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}

}

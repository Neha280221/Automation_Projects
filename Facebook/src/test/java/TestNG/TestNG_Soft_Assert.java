package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Soft_Assert 
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
	
	// If one of the assertion is failed from the whole test case then 
	// whole test result is failed
	// In Soft assert we have to create of object of SoftAssert Class
	// To apply the result on test methods we have to call everytime assertall() function
	
	// We can only initialize reference as global otherwise 
	// Test cases should not be executed assertions get failed due to not creating object locally
	
	//SoftAssert soft = new SoftAssert(); 
	
	SoftAssert soft;
	
	@Test (priority = 0)
	public void testA()
	{
		soft = new SoftAssert();
		System.out.println("TestA");
		String actualUrl = "https://www.facebook.com/";
		String expectedUrl = "https://www.facebook.com/";
		
		// 1. To compare the data
		// 2. To create the result
		
		// If actual data is EQUALS to expected data then test case is PASSED
		// If actual data is NOT EQUALS to expected data then test case is FAILED
		
		soft.assertEquals(actualUrl, expectedUrl);
		
		// Assert method with message
		
		soft.assertEquals(actualUrl, expectedUrl, "Homepage URL is not found");
		
		soft.assertAll();
	}
	
	@Test (priority = 2)
	public void testB()
	{
		soft = new SoftAssert();
		System.out.println("TestB");
		String actualTitle = "Facebook - Login or Sign Up";
		String expectedTitle = "Facebook - Login or Sign Up123";
		
		// 1. To compare the data
		// 2. To create the result
		
		// If actual data is NOT EQUALS to expected data then test case is PASSED
		// If actual data is EQUALS to expected data then test case is FAILED
					
		soft.assertNotEquals(actualTitle, expectedTitle, "Homepage Title is not found");
		
		// Assert method with message 
					
		soft.assertNotEquals(actualTitle, expectedTitle);
		
		soft.assertAll();
	}
	
	@Test  (priority = -2)
	public void testC()
	{
		soft = new SoftAssert();
		System.out.println("TestC");
		String actualName = "Submit";
		String expectedName = "Submit123";
		
		boolean result = actualName.equals(expectedName);
		
		// 2. Create the result
		
		// If result == true then test case is PASEED
		// If result == false then test case is FAILED
		
		soft.assertTrue(result);
		
		// Assert method with message
		
		soft.assertTrue(result, "Submit button text is wrong");
		
		soft.assertAll();
		
	}
	
	@Test  (priority = 1)
	public void testD()
	{
		soft = new SoftAssert();
		System.out.println("TestD");
		String actualUrl = "https://www.facebook.com/";
		String expectedUrl = "https://www.facebook.com/home";
		
		boolean result = actualUrl.equals(expectedUrl);
		
		// 2. Create the result
		
		// If result == false then test case is PASEED
		// If result == true then test case is FAILED
					
		soft.assertFalse(result, "Homepage URL is not found");
		
		// Assert method with message 
					
		soft.assertFalse(result);
		soft.assertAll();
	}
	
	@Test  (priority = 1)
	public void testE()
	{
		soft = new SoftAssert();
		System.out.println("TestE");
		String actualUrl = "https://www.facebook.com/";
		String expectedUrl = "https://www.facebook.com/";
		
		boolean result = actualUrl.equals(expectedUrl);
		
		if(result == true)
		{
			System.out.println("Test case is Passed");
		}
		else
		{
			//soft.fail(); // Forcefully fail the test method
		}
		
	}
	
	@Test  (priority = -3)
	public void testF()
	{
		soft = new SoftAssert();
		System.out.println("TestF");
		String actualUrl = "https://www.facebook.com/";
		String expectedUrl = "https://www.facebook.com/";
		
		String actualTitle = "Facebook - Login or Sign Up";
		String expectedTitle = "Facebook - Login or Sign Up";
		
		String actualName = "Submit";
		String expectedName = "Submit";
		
		soft.assertEquals(actualUrl, expectedUrl, "Homepage URL is not found");
		soft.assertEquals(actualTitle, expectedTitle, "Homepage Title is not found");
		soft.assertEquals(actualName, expectedName, "Submit button text is wrong");

		soft.assertAll();
		
		// True will be printed if and only if all of the above assertion results are TRUE
		// True will not be printed if any one of the above assertion result is FALSE
		
		System.out.println("True");  // assertall(); function concept
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
		//soft.assertall();      // We can't call here it will give failed configuration error
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}
	
}

package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class TestNG_Hard_Assert 
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
		
		@Test (priority = 0)
		public void testA()
		{
			System.out.println("TestA");
			String actualUrl = "https://www.facebook.com/";
			String expectedUrl = "https://www.facebook.com/";
			
			// 1. To compare the data
			// 2. To create the result
			
			// If actual data is EQUALS to expected data then test case is PASSED
			// If actual data is NOT EQUALS to expected data then test case is FAILED
			
			Assert.assertEquals(actualUrl, expectedUrl);
			
			// Assert method with message
			
			Assert.assertEquals(actualUrl, expectedUrl, "Homepage URL is not found");
		}
		
		@Test (priority = 2)
		public void testB()
		{
			System.out.println("TestB");
			String actualTitle = "Facebook - Login or Sign Up";
			String expectedTitle = "Facebook - Login or Sign Up123";
			
			// 1. To compare the data
			// 2. To create the result
			
			// If actual data is NOT EQUALS to expected data then test case is PASSED
			// If actual data is EQUALS to expected data then test case is FAILED
						
			Assert.assertNotEquals(actualTitle, expectedTitle, "Homepage Title is not found");
			
			// Assert method with message 
						
			Assert.assertNotEquals(actualTitle, expectedTitle);
		}
		
		@Test  (priority = -2)
		public void testC()
		{
			System.out.println("TestC");
			String actualUrl = "https://www.facebook.com/";
			String expectedUrl = "https://www.facebook.com/home";
			
			boolean result = actualUrl.equals(expectedUrl);
			
			// 2. Create the result
			
			// If result == true then test case is PASEED
			// If result == false then test case is FAILED
			
			Assert.assertTrue(result);
			
			// Assert method with message
			
			Assert.assertTrue(result, "Homepage URL is not found");
		}
		
		@Test  (priority = 1)
		public void testD()
		{
			System.out.println("TestD");
			String actualUrl = "https://www.facebook.com/";
			String expectedUrl = "https://www.facebook.com/home";
			
			boolean result = actualUrl.equals(expectedUrl);
			
			// 2. Create the result
			
			// If result == false then test case is PASEED
			// If result == true then test case is FAILED
						
			Assert.assertFalse(result, "Homepage URL is not found");
			
			// Assert method with message 
						
			Assert.assertFalse(result);
		}
		
		@Test  (priority = 1)
		public void testE()
		{
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
				Assert.fail(); // Forcefully fail the test method
			}
			
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




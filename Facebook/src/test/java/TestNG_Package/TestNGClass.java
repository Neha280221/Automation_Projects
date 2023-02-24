package TestNG_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGClass 
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
	
	// priority keyword is used to maintain the execution (default priority = 0)
	// Sequence of test method
	// Priority can be any number positive or negative
	
	// invocationCount is used to repeat the test method multiple times (default invocationCount = 1)
	
	// If priority of 2 or more test methods are same then execution in between that method 
	// will be depends on alphabetical order of that method name
	
	@Test (priority = 0, invocationCount = 2)
	public void testA()
	{
		System.out.println("TestA");
	}
	
	@Test (priority = 2)
	public void testB()
	{
		System.out.println("TestB");
	}
	
	@Test  (priority = -2)
	public void testC()
	{
		System.out.println("TestC");
	}
	
	@Test  (priority = 1)
	public void testD()
	{
		System.out.println("TestD");
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

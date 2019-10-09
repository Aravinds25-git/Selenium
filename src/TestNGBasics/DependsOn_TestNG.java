package TestNGBasics;

import org.testng.annotations.Test;

public class DependsOn_TestNG {

	@Test
	public void LoginTest()
	{
		int a;
		a=10/0;
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void Search()
	{
		System.out.println("search");
	}

	
}

package TestNGBasics;

import org.testng.annotations.Test;

public class InvocationCountTest {

	/*@Test(invocationCount=5)
	public void add()
	{
		int a=5;
		int b=10;
		int c=a+b;
		System.out.println();
	}*/
	
	@Test(timeOut=2000)
	public void timeout()
	{
		int i=1;
		while(i==1)
		{
			System.out.println(i);
		}
	}
	
	
}

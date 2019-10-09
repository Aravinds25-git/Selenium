package TestNGBasics;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	
	//If hard assertion failed remaining code will not execute--immediately testcase will be marked as failure
	//assertall-very import to write then only we will know the error
	//softassertion-- if a soft assertion is getting failed -->will  be marked as paased as well as next line will executed
	//assertAll()--to mark the testcase as failed--if any soft assertion failed
	@Test
	public void test1()
	{
		
		SoftAssert asrt=new SoftAssert();
		System.out.println("open browser");
		System.out.println("login");
		//Assert.assertEquals(true, false);//hard assertion
		asrt.assertEquals(true, false);
		System.out.println("Payment");
		asrt.assertEquals(true, false);
		System.out.println("Close browser");
		asrt.assertAll();
	}
}


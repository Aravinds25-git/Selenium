package TestNGBasics;

import org.testng.annotations.Test;

public class ExpectedException {

	@Test(expectedExceptions=NumberFormatException.class)
	public void numberformat()
	{
		String a="100A";
		int s=Integer.parseInt(a);
		System.out.println(s);
	}
}

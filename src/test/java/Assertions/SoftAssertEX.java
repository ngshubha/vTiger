package Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEX {
	@Test
	public void m1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(true, true);
		System.out.println("Step 3");
		System.out.println("Step 4");
		soft.assertAll();
	}

}

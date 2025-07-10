package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HardAssert {
	
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, true);
		System.out.println("Step3");
		System.out.println("Step4");
		
	}
	
	public void m2()
	{
		String actData="TCS";
		String expData="TCS";
		Assert.assertEquals(actData, expData);
		System.out.println("TestCase is Passed");
	}
	@Test
	public void m3()
	{
		 int a=10;
		 int b=10;
		 Assert.assertEquals(a, b,"ASSERT FAIL");
		 System.out.println("ASSERT PASS");
		
	}
	@Test
	public void m4()
	{
		float a=(float) 10.0;
		float b=(float) 20.0;
		Assert.assertEquals(a, b,"ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	
	@Test
	public void m5()
	{
		String actData="Qspiders";
		String expData="JSpiders";
		Assert.assertNotEquals(actData, expData,"ASSERT PASS");
		System.out.println("ASSERT FAIL");
	}
	
	@Test
	public void m6()
	{
		String actData="Qspiders";
		String expData="QSpiders";
		Assert.assertNotEquals(actData, expData,"ASSERT PASS");
		System.out.println("ASSERT FAIL");
	}
	@Test
	public void m7()
	{
		String actData="Shubha";
		String expData="Shubha";
		Assert.assertTrue(actData.equals(expData), "ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	@Test
	public void m8()
	{
		String actData="Shubha";
		String expData="ShubhA";
		Assert.assertTrue(actData.equals(expData), "ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	@Test
	public void m9()
	{
		String actData="Hello";
		String expData="HELLO";
		Assert.assertFalse(actData.equals(expData), "ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	@Test
	public void m10()
	{
		String actData="Hello";
		String expData="Hello";
		Assert.assertFalse(actData.equals(expData), "ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	
	@Test
	public void m11()
	{
		String actData="TCS";
		Assert.assertNull(actData,"ASSERT PASS");
		System.out.println("ASSERT FAIL");
	}
	
	@Test
	public void m12()
	{
		String actData=null;
		Assert.assertNull(actData,"ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	

	@Test
	public void m13()
	{
		String actData="TCS";
		Assert.assertNotNull(actData,"ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	

	@Test
	public void m14()
	{
		String actData=null;
		Assert.assertNotNull(actData,"ASSERT PASS");
		System.out.println("ASSERT FAIL");
	}
	
	@Test
	public void m15()
	{
		int act=10;
		int exp=10;
		Assert.assertNotSame(act, exp, "ASSERT PASS");
		System.out.println("ASSERT FAIL");
	}
	
	@Test
	public void m16()
	{
		int act=10;
		int exp=20;
		Assert.assertNotSame(act, exp, "ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	
	@Test
	public void m17()
	{
		int act=10;
		int exp=10;
		Assert.assertSame(act, exp, "ASSERT FAIL");
		System.out.println("ASSERT PASS");
	}
	
	@Test
	public void m18()
	{
		int act=10;
		int exp=20;
		Assert.assertSame(act, exp, "ASSERT PASS");
		System.out.println("ASSERT FAIL");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

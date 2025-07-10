package vTigerPOMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductvalidationPage {
	
	
	public ProductvalidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to validate the campaign
	 * @param driver
	 * @param expData
	 */
	public void validateprod(WebDriver driver,String expData)
	
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		//if (actData.equals(expData)) {
			//System.out.println("Product  is Created");
	//	} else {
			//System.out.println("Product is not created");
		//}
		
		Assert.assertEquals(actData, expData, "Product Name is not Craeted");
		System.out.println("Product Name is created");
	}
}



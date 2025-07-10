package vTigerPOMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ValidationCampaignPage {
	
	public ValidationCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to validate the campaign
	 * @param driver
	 * @param expData
	 */
	public void validateCamp(WebDriver driver,String expData)
	
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		//if (actData.equals(expData)) {
			//System.out.println("campaign Name is Created");
		//} else {
			//System.out.println("Campaign name is not created");
		//}
		
		//Assert.assertEquals(actData, expData,"Campaign Name is not Created");
		//System.out.println("Campaign Name is Created");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expData, actData,"Campaign Name is not created");
		System.out.println("Campaign Name is Created");
		soft.assertAll();
		
	}
}
 



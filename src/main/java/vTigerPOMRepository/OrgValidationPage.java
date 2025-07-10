package vTigerPOMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrgValidationPage {
	
	public OrgValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
			
	/**
	* This method is used to validate the campaign
    * @param driver
	* @param expData
	*/
	public void validateOrg(WebDriver driver,String expData)
			
			{
				String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

				//if (actData.equals(expData)) {
				//	System.out.println("Organisation  is Created");
				//} else {
				//	System.out.println("Organisation is not created");
				//}
				
				Assert.assertEquals(expData, actData,"Organisation is not Created");
				System.out.println("Organisation is Created");
			}
		}

	



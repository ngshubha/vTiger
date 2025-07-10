package vTigerCamapignsModule;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTigerGenericUtilities.BaseClass;
import vTigerGenericUtilities.Excel_Utility;
import vTigerGenericUtilities.Java_Utility;
import vTigerPOMRepository.CampLookUpImgPage;
import vTigerPOMRepository.CreateCampaignPage;
import vTigerPOMRepository.CreateOrganisationPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.OrgLookUpImgPage;
import vTigerPOMRepository.OrgValidationPage;
import vTigerPOMRepository.ValidationCampaignPage;


//@Listeners(vTigerGenericUtilities.ListenerImp.class)
@Listeners(vTigerGenericUtilities.ExtentReportImp.class)
public class CreateCampaignOpTest extends BaseClass{
	@Test(groups="smokeTest")
	public void CreateCampaignOpTest() throws Throwable
	{
		HomePage homePage=new HomePage(driver);
		homePage.clickCampaignsLink();
		
		CampLookUpImgPage cliPage=new CampLookUpImgPage(driver);
		cliPage.clickLookUpImg();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum=jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String campName=elib.readDataFromExcelSheet("Campaign", 0, 0)+ranNum;
	
		CreateCampaignPage campPage=new CreateCampaignPage(driver);
		campPage.enterCampNAme(campName);
		campPage.clickSaveButton();
		
		//Assert.fail();
		
		ValidationCampaignPage valCampPage=new ValidationCampaignPage(driver);
		valCampPage.validateCamp(driver, campName);
	}
	
	@Test
	public void m2()
	{
		System.out.println("Example for running a particular method inside a class using commandline");
	}
	
	

}

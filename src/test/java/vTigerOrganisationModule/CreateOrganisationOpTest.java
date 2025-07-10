package vTigerOrganisationModule;

import org.testng.Assert;
import org.testng.annotations.Listeners;



import org.testng.annotations.Test;

import vTigerGenericUtilities.BaseClass;
import vTigerGenericUtilities.Excel_Utility;
import vTigerGenericUtilities.Java_Utility;
import vTigerPOMRepository.CreateOrganisationPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.OrgLookUpImgPage;
import vTigerPOMRepository.OrgValidationPage;


//@Listeners(vTigerGenericUtilities.ListenerImp.class)




public class CreateOrganisationOpTest extends BaseClass
{
	
	@Test(retryAnalyzer=vTigerGenericUtilities.RetryAnalyserImp.class)
	public void CreateOrganisationOpTest() throws Throwable
	{
	Java_Utility jlib=new Java_Utility();
	int ranNum=jlib.getRandomNum();
	
	HomePage homePage=new HomePage(driver);
	homePage.clickOrgLink();
	
	OrgLookUpImgPage oliPage= new OrgLookUpImgPage(driver);
	oliPage.clickLookUpImg();
	
	Excel_Utility elib=new Excel_Utility();
	String orgName=elib.readDataFromExcelSheet("Organization", 0, 0)+ranNum;
	String phno=elib.readDataFromExcelUsingDataProvider("Organization", 1, 0);
	String email=elib.readDataFromExcelUsingDataProvider("Organization", 2, 0);
	
	CreateOrganisationPage crtOrgPage=new CreateOrganisationPage(driver);
	crtOrgPage.createOrganisation(orgName, phno, email);
	
	//Assert.fail();
	OrgValidationPage orgValPage=new OrgValidationPage(driver);
	orgValPage.validateOrg(driver, orgName);
	}
}

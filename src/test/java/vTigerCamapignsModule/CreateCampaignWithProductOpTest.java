package vTigerCamapignsModule;

import org.testng.annotations.Test;

import vTigerGenericUtilities.BaseClass;
import vTigerGenericUtilities.Excel_Utility;
import vTigerGenericUtilities.Java_Utility;
import vTigerGenericUtilities.WebDriverUtility;
import vTigerPOMRepository.CampLookUpImgPage;
import vTigerPOMRepository.CreateCampaignPage;
import vTigerPOMRepository.CreateProductPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.ProdLookUpImgPage;
import vTigerPOMRepository.ProductsPage;
import vTigerPOMRepository.ProductvalidationPage;
import vTigerPOMRepository.ValidationCampaignPage;

@Test(groups="smokeTest")
public class CreateCampaignWithProductOpTest extends BaseClass{
	
	public void CreateCampaignWithProductOpTest() throws Throwable
	{
WebDriverUtility wlib=new WebDriverUtility();
		
		
		Java_Utility jlib=new Java_Utility();
		int ranNum=jlib.getRandomNum();
		
		//Step 3 : Create a Product
		
		HomePage homePage=new HomePage(driver);
		homePage.clickProductLink();
		
		ProdLookUpImgPage pliPage=new ProdLookUpImgPage(driver);
		pliPage.clickLookUpImg();
		
		Excel_Utility elib=new Excel_Utility();
		String prdName=elib.readDataFromExcelSheet("Product", 0, 0)+ranNum;
		
		CreateProductPage prodpage=new CreateProductPage(driver);
		prodpage.createProduct(prdName);
		prodpage.clickSaveButton();
		
		ProductvalidationPage valProdPage=new ProductvalidationPage(driver);
		valProdPage.validateprod(driver, prdName);
		
		//Step 4 : Create a new Campaign
		
		homePage.clickCampaignsLink();
		
		CampLookUpImgPage cliPage=new CampLookUpImgPage(driver);
		cliPage.clickLookUpImg();
		
		CreateCampaignPage campPage=new CreateCampaignPage(driver);
		
		String campName=elib.readDataFromExcelSheet("Campaign", 0, 0)+ranNum;
		
		campPage.enterCampNAme(campName);
		campPage.clickprdLookUpImg();
		
		wlib.swithToWindow(driver,"Products&action");
		
		ProductsPage proPage=new ProductsPage(driver);
		proPage.searchProdName(prdName);
		proPage.clicksearchBtn();
		
		
		proPage.selectProduct(driver, prdName);
				
		wlib.swithToWindow(driver, "Campaigns&action");
		campPage.clickSaveButton();
		
		
		ValidationCampaignPage valCamPage=new ValidationCampaignPage(driver);
		valCamPage.validateCamp(driver, campName);
	}

}

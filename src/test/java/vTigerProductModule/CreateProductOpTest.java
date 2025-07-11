package vTigerProductModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTigerGenericUtilities.BaseClass;
import vTigerGenericUtilities.Excel_Utility;
import vTigerGenericUtilities.Java_Utility;
import vTigerPOMRepository.CreateOrganisationPage;
import vTigerPOMRepository.CreateProductPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.OrgLookUpImgPage;
import vTigerPOMRepository.OrgValidationPage;
import vTigerPOMRepository.ProdLookUpImgPage;
import vTigerPOMRepository.ProductvalidationPage;
@Test(groups={"smokeTest","regressionTest"})
public class CreateProductOpTest extends BaseClass{
	
	//Engineer 1-- I am pushing the code
	public void CreateProductOpTest() throws Throwable
	{
	
	Java_Utility jlib=new Java_Utility();
	int ranNum=jlib.getRandomNum();
	
	HomePage homePage=new HomePage(driver);
	homePage.clickProductLink();
	
	ProdLookUpImgPage pliPage=new ProdLookUpImgPage(driver);
	pliPage.clickLookUpImg();
	
	Excel_Utility elib=new Excel_Utility();
	String prdName=elib.readDataFromExcelSheet("Product",0,0)+ranNum;
	
	CreateProductPage crtProdPage=new CreateProductPage(driver);
	crtProdPage.createProduct(prdName);
	crtProdPage.clickSaveButton();
	
	//Assert.fail("Intentionally Failing the test Script");
	ProductvalidationPage prodValPage=new ProductvalidationPage(driver);
	prodValPage.validateprod(driver, prdName);
	}

	
	
}

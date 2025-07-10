package vTigerCamapignsModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vTigerGenericUtilities.BaseClass;
import vTigerGenericUtilities.Excel_Utility;
import vTigerGenericUtilities.File_Utility;
import vTigerGenericUtilities.Java_Utility;
import vTigerGenericUtilities.WebDriverUtility;
import vTigerPOMRepository.CampLookUpImgPage;
import vTigerPOMRepository.CreateCampaignPage;
import vTigerPOMRepository.CreateProductPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.LoginPage;
import vTigerPOMRepository.ProdLookUpImgPage;
import vTigerPOMRepository.ProductsPage;
import vTigerPOMRepository.ProductvalidationPage;
import vTigerPOMRepository.ValidationCampaignPage;
@Test
public class CreateCampaignWithProduct extends BaseClass {

	public  void CreateCampaignWithProductTest() throws Throwable {
		
		//step 1: Get the FilePath Connection and Load all the Keys
		/*File_Utility flib=new File_Utility();
		String BROWSER=flib.getKeyAndValueData("browser");
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");


		//WebDriver driver;
		
		WebDriverUtility wlib=new WebDriverUtility();
		
				
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		
		/*driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		
		//Step 2 : Login to the Application
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD); */
		
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
		
	
		
		//homePage.logoutApp();
		
		
		
		
		
		
		
		
		
		
		

	}

}

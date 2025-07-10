package vTigerProductModule;

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
import vTigerPOMRepository.CreateProductPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.LoginPage;
import vTigerPOMRepository.ProdLookUpImgPage;
import vTigerPOMRepository.ProductvalidationPage;
@Test
public class CreateAndDeleteProduct  {

	public void CreateAndDeleteProduct() throws Throwable {
		
		File_Utility flib=new File_Utility();
		String BROWSER=flib.getKeyAndValueData("browser");
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		WebDriverUtility wlib=new WebDriverUtility();
		
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		
		Java_Utility jlib=new Java_Utility();
		int ranNum=jlib.getRandomNum();
		
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		
				
		HomePage homePage=new HomePage(driver);
		homePage.clickProductLink();
		
		ProdLookUpImgPage pliPage=new ProdLookUpImgPage(driver);
		pliPage.clickLookUpImg();
		
		Excel_Utility elib=new Excel_Utility();
		String prdName=elib.readDataFromExcelSheet("Product",0,0)+ranNum;
		
		CreateProductPage crtProdPage=new CreateProductPage(driver);
		crtProdPage.createProduct(prdName);
		crtProdPage.clickSaveButton();
		
		ProductvalidationPage prodValPage=new ProductvalidationPage(driver);
		prodValPage.validateprod(driver, prdName);
		
		homePage.clickProductLink();
		crtProdPage.selProdToDel(driver, prdName);
		crtProdPage.deleteProduct(driver);
		
		driver.switchTo().alert().accept();
		
		crtProdPage.valProdDel(driver, prdName);
		
		homePage.logoutApp();

	}

}

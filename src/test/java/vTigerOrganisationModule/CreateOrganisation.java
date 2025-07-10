package vTigerOrganisationModule;

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
import vTigerPOMRepository.CreateOrganisationPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.LoginPage;
import vTigerPOMRepository.OrgLookUpImgPage;
import vTigerPOMRepository.OrgValidationPage;

@Test
public class CreateOrganisation extends BaseClass{

	public void CreateOrganisationTest() throws Throwable {
		
		/*File_Utility flib=new File_Utility();
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
		
		
		
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);*/
		
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
		
		OrgValidationPage orgValPage=new OrgValidationPage(driver);
		orgValPage.validateOrg(driver, orgName);
		
		//homePage.logoutApp();
		
		

	}

}

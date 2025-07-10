package vTigerCamapignsModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vTigerGenericUtilities.BaseClass;
import vTigerGenericUtilities.Excel_Utility;
import vTigerGenericUtilities.File_Utility;
import vTigerGenericUtilities.Java_Utility;
import vTigerPOMRepository.CampLookUpImgPage;
import vTigerPOMRepository.CreateCampaignPage;
import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.LoginPage;
import vTigerPOMRepository.ValidationCampaignPage;
@Test
public class CreateCampaign extends BaseClass {

	public  void CreateCampaignTest() throws Throwable {
		// TODO Auto-generated method stub

		/*File_Utility flib=new File_Utility();
		String BROWSER=flib.getKeyAndValueData("browser");
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) 
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
		}
		
		driver.get(URL);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD); */
		
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
		
		ValidationCampaignPage valCampPage=new ValidationCampaignPage(driver);
		valCampPage.validateCamp(driver, campName);
		
		//homePage.logoutApp();
		
	}

}

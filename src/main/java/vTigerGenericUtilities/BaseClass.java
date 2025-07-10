package vTigerGenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vTigerPOMRepository.HomePage;
import vTigerPOMRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smokeTest", "regressionTest"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}

	@BeforeTest(groups= {"smokeTest", "regressionTest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest", "regressionTest"})
	//public void BC(String BROWSER) throws Throwable
	public void BC() throws Throwable
	{
		System.out.println("Browser Launching");
		File_Utility flib=new File_Utility();
		String BROWSER=flib.getKeyAndValueData("browser");
		
		//String BROWSER=System.getProperty("browser");
		
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
		
		sdriver=driver;
	}
	
	//@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups= {"smokeTest", "regressionTest"})
	//public void BM(String URL, String USERNAME, String PASSWORD) throws Throwable
	public void BM() throws Throwable
	{
		System.out.println("Login to the Application");
		File_Utility flib=new File_Utility();
		
		//String BROWSER=System.getProperty("browser");
		//String URL=System.getProperty("url");
		//String USERNAME=System.getProperty("username");
		//String PASSWORD=System.getProperty("password");
		
		String BROWSER=flib.getKeyAndValueData("browser");
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		driver.get(URL);

		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		
		//Step 2 : Login to the Application
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups= {"smokeTest", "regressionTest"})
	public void AM()
	{
		HomePage homepage=new HomePage(driver);
		homepage.logoutApp();
		System.out.println("Logout from the appliction");
	}
	
	@AfterClass(groups= {"smokeTest", "regressionTest"})
	public void AC()
	{
		System.out.println("Close the Browser");
		driver.quit();
	}
	
	@AfterTest(groups= {"smokeTest", "regressionTest"})
	public void AT()
	{
		System.out.println("Stop the Parallel execution");
	}
	
	@AfterSuite(groups= {"smokeTest", "regressionTest"})
	public void AS()
	{
		System.out.println("close the Database connection");
	}
}

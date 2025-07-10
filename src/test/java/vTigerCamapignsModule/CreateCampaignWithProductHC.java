package vTigerCamapignsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaignWithProductHC {

	public static void main(String[] args) throws Throwable 
	{
		
		 		/*1.Login to vtiger application
		 		2.mouseOverOn more Link
		 		3.click on campaigns
		 		4.click on create campaign lookup image
		 		5.Enter campaignName
		 		6.Click on Product plus img
		 		7.Handle the PopUp
		 		8.Product name should be added to campaign createpage
		 		9.click on save Btn
		 		10.verify whether the campaign name is created in campaign Information page and Logout from the application.*/
		
			
		
				// step1:- get the file path connection
				FileInputStream fis = new FileInputStream("./src/test/resources/CommonData2.properties");

				// step2:- load all the keys
				Properties pro = new Properties();
				pro.load(fis);

				// step3:- read key value
				String BROWSER = pro.getProperty("browser");
				String URL = pro.getProperty("url");
				String USERNAME = pro.getProperty("username");
				String PASSWORD = pro.getProperty("password");

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
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(By.linkText("Products")).click();

				driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

				// To Avoid Duplicates
				Random ran = new Random();
				int ranNum = ran.nextInt(1000);

				// Step1:-get the connection of physical file
				FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

				// step2:- open workbook in read mode
				Workbook book = WorkbookFactory.create(fis1);

				// step3:-get control of the Sheet
				Sheet sheet = book.getSheet("Product");

				// step4:-get control of the row
				Row row = sheet.getRow(0);

				// step5:-get control of the cell
				Cell cel = row.getCell(0);

				// //step6:-read cell value
				String PrdName = cel.getStringCellValue() + ranNum;
				System.out.println(PrdName);

				driver.findElement(By.name("productname")).sendKeys(PrdName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//-----------------------------------------------------------------------------------------------------------
				// Navigating to campaign Module
				WebElement moreLink = driver.findElement(By.linkText("More"));

				Actions act = new Actions(driver);
				act.moveToElement(moreLink).perform();
				driver.findElement(By.linkText("Campaigns")).click();
				driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();

				FileInputStream fes = new FileInputStream(
						"./src/test/resources/TestData.xlsx");
				// step2:- open workbook in read mode
				Workbook book1 = WorkbookFactory.create(fes);

				// step3:-get control of the Sheet
				Sheet sheet1 = book1.getSheet("Campaign");

				// step4:-get control of the row
				Row row1 = sheet1.getRow(0);

				// step5:-get control of the cell
				Cell cel1 = row1.getCell(0);

				// //step6:-read cell value
				String CampName = cel1.getStringCellValue() + ranNum;
				System.out.println(CampName);

				driver.findElement(By.name("campaignname")).sendKeys(CampName);
				
				//Click on + sign To Navigate Product Table
				driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
				
				Set<String> allWins = driver.getWindowHandles();//win1//win2
				Iterator<String> it = allWins.iterator();
			
				while (it.hasNext())
				{
					String win = it.next();
					driver.switchTo().window(win);
					String title = driver.getTitle();
				if(title.contains("Products&action"))
				{
					break;
				}
				}
			driver.findElement(By.name("search_text")).sendKeys(PrdName);
			driver.findElement(By.cssSelector("[name=\"search\"]")).click();
			
			//Dynamic Xpath
			driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
			
			Set<String> allWins1 = driver.getWindowHandles();
			Iterator<String> it1 = allWins1.iterator();

			while (it1.hasNext())
			{
				String win1 = it1.next();
				driver.switchTo().window(win1);
				String title1 = driver.getTitle();
			if(title1.contains("Campaigns&action"))
			{
				break;
			}
			}
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

				if(actData.contains(CampName))
				{
					System.out.println("Campaigns Name is Created");
				}
				else
				{
					System.out.println("Campaigns name not created");
				}


				String actData1 = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
				if (actData1.equals(PrdName)) {
					System.out.println("Product Name is Created");
				} else {
					System.out.println("Product name is not created");
				}

				WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

				//Logout
				act.moveToElement(AmdLink).perform();
				driver.findElement(By.linkText("Sign Out")).click();
			
			}



	}



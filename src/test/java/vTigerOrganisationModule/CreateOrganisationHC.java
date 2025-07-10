package vTigerOrganisationModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

public class CreateOrganisationHC {

	public static void main(String[] args) throws Throwable {
		
		/*1. Login to vtiger application
		2.click on organizations link
		3.click on create organization lookup image
		4.Enter organisation name,phone number and email
		5.click on save Btn
		6.verify whether the organization is created in Organization Information page and Logout from the application.*/
		
		
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
				
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

				//To Avoid Duplicates
				Random ran = new Random();
				int ranNum = ran.nextInt(1000);
				
				
				// Step1:-get the connection of physical file
				FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

				// step2:- open workbook in read mode
				Workbook book = WorkbookFactory.create(fis1);

				// step3:-get control of the Sheet
				Sheet sheet = book.getSheet("Organization");

				// step4:-get control of the row
				Row row = sheet.getRow(0);

				// step5:-get control of the cell
				Cell cel = row.getCell(0);

				// //step6:-read cell value
				String OrgName = cel.getStringCellValue()+ranNum;
				System.out.println(OrgName);
				driver.findElement(By.name("accountname")).sendKeys(OrgName);
				// --------------------------------------------------------------------------------------------

				// step4:-get control of the row
				Row row1 = sheet.getRow(1);

				// step5:-get control of the cell
				Cell cel1 = row1.getCell(0);

				DataFormatter format = new DataFormatter();
				String PhoneNum = format.formatCellValue(cel1);
				System.out.println(PhoneNum);
				driver.findElement(By.id("phone")).sendKeys(PhoneNum);
				
				//------------------------------------------------------------------------------------------
				Row row2 = sheet.getRow(2);

				// step5:-get control of the cell
				Cell cel2 = row2.getCell(0);

				// //step6:-read cell value
				String Email = cel2.getStringCellValue();
				System.out.println(Email);
				driver.findElement(By.id("email1")).sendKeys(Email);
				//-------------------------------------------------------------------------------------------
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
				
				if(actData.contains(OrgName))
				{
					System.out.println("Organization Name is Created");
				}
				else
				{
					System.out.println("Organization name not created");
				}
				
				WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				
				Actions act = new Actions(driver);
				act.moveToElement(AmdLink).perform();
				driver.findElement(By.linkText("Sign Out")).click();
		}


	}



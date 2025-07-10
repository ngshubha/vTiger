package vTigerProductModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

public class CreateAndDeleteProductHC {

	public static void main(String[] args) throws Throwable {
		
		/*1.Login to vtiger application
		2.click on products link
		3.click on create product lookup image
		4.Enter product name
		5.click on save Btn
		6.verify whether the product is created in product Information page
		7.click on product link
		8.navigate to product table page
		9.select the product created checkbox
		10.click on delete
		11.Handle the Alert popup and verify product deleted or not and Logout from the application.*/
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData2.properties");

		// step2:- load all the keys from properties file
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- get keys from properties file
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		// Random Approach
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		// step1:- connecting the excel file
		FileInputStream file = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet("Product");

		// step4:- navigate into row
		Row row = sheet.getRow(0);

		// step5:-navigate into cell
		Cell cell = row.getCell(0);

		String PrdName = cell.getStringCellValue() + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if (actdata.contains(PrdName)) {
			System.out.println("Product name is created");
		} else {
			System.out.println("Product name is not created");
		}
		driver.findElement(By.linkText("Products")).click();

//	driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product Name']/../preceding-sibling::td[@class='lvtCol']//input[@type=\"checkbox\"]")).click();

		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		driver.switchTo().alert().accept();

         List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prd : prdList) {

			String actData = prd.getText();
			if (actData.contains(PrdName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Product name is deleted");
		}

		else {
			System.out.println("Product name is not deleted");
			
	}

	}
}




	



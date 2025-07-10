package vTigerPOMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchtextBox;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	
	
	
	
	public WebElement getSearchtextBox() {
		return searchtextBox;
	}



	public WebElement getSearchButton() {
		return searchButton;
	}



	public void searchProdName(String pname)
	{
		searchtextBox.sendKeys(pname);
	}
	
	public void clicksearchBtn()
	{
		searchButton.click();
	}
	
	public void selectProduct(WebDriver driver,String name)
	{

		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
	}
	
	
	
	

}

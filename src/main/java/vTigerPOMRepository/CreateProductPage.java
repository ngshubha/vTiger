package vTigerPOMRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement prdNameTextFeild;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getPrdNameTextFeild() {
		return prdNameTextFeild;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createProduct(String pname)
	{
		prdNameTextFeild.sendKeys(pname);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	public void selProdToDel(WebDriver driver,String pname)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + pname
				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
	}
	
	public void deleteProduct(WebDriver driver)
	{
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
	}
	
	public void valProdDel(WebDriver driver, String prdName)
	{
		List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		boolean flag=false;
		for(WebElement prd : prdList )
		{
			String actData=prd.getText();
			if(actData.contains(prdName))
			{
				flag=true;
				break;
			}
		}
		if(flag)
			System.out.println("Product is Deleted");
		else
			System.out.println("Product is not deleted");
	}
}
			
		

	

	
	
	
	



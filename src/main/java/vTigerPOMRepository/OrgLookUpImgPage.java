package vTigerPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpImgPage {
	
	public OrgLookUpImgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title='Create Organization...']")
	private WebElement lookUpImg;

	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	/**
	 * This method is used to click on LookUp Img
	 */
	public void clickLookUpImg()
	{
		lookUpImg.click();
	}
	
}




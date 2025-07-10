package vTigerPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campNAme;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;
	

	@FindBy(xpath="//img[@alt='Select']")
	private WebElement prdlookUpImg;
	

	public WebElement getCampNAme() {
		return campNAme;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This method is used to enter campagin Name
	 * @param name
	 */
	public void enterCampNAme(String name)
	{
		campNAme.sendKeys(name);
	}
	
	/**
	 * This method is used to click on save Button
	 */
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	

	public WebElement getPrdlookUpImg() {
		return prdlookUpImg;
	}
		
	public void clickprdLookUpImg()
	{
		prdlookUpImg.click();
	}
	
	
}



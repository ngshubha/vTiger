package vTigerPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameTextFeild;
	
	@FindBy(id="phone")
	private WebElement phoneNumTextFeild;
	
	@FindBy(id="email1")
	private WebElement emailTextFeild;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrgNameTextFeild() {
		return orgNameTextFeild;
	}

	public WebElement getPhoneNumTextFeild() {
		return phoneNumTextFeild;
	}

	public WebElement getEmailTextFeild() {
		return emailTextFeild;
	}
	
	public WebElement getsaveButton()
	{
		return saveButton;
	}
	
	
	public void createOrganisation(String name, String phno, String email)
	{
		orgNameTextFeild.sendKeys(name);
		phoneNumTextFeild.sendKeys(phno);
		emailTextFeild.sendKeys(email);
		saveButton.click();
		
	}
	
	

}

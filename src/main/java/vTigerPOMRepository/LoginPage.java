package vTigerPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	

		//Element initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Elements Declaration
		@FindBy(name = "user_name")
		private WebElement UserTextField;

		@FindBy(name = "user_password")
		private WebElement PassWordTextField;

		@FindBy(id = "submitButton")
		private WebElement loginButton;

		// getter methods
		public WebElement getUserTextField() {
			return UserTextField;
		}

		public WebElement getPassWordTextField() {
			return PassWordTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		public void loginToApp(String un,String pwd)
		{
			UserTextField.sendKeys(un);
			PassWordTextField.sendKeys(pwd);
			loginButton.click();
		}

	}



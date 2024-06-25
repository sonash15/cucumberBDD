package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

	public LogInPage(WebDriver driver) {
		super(driver);

	
	}

	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement clicklogin;
	
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void BtnLogin() {
		clicklogin.click();
	}
	
	

}


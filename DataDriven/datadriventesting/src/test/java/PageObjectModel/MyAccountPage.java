package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgverification;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	//message verify 
	public  boolean isAccountpageExist() {
		try {
		return msgverification.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
	
	public void logout() {
		lnkLogout.click();
	}

}

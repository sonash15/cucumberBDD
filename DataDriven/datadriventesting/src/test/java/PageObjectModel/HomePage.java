package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		
		super(driver);//passign this deriver to basepage class to get pagefactory element
	}

	
	//Locate the Elements
	//for registration 
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myacc;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	//for login page 
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement loginclick;
	
	//Create Method For action
	public void myAccount() throws InterruptedException {
		myacc.click();
		Thread.sleep(2000);
		//register.click();
		
	}
	
	public void login() {
		loginclick.click();
	}
	
	
}

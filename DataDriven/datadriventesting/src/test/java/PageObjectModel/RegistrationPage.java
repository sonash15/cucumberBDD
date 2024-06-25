package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Loacte web elements

	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lname;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement cpass;
	
	@FindBy(xpath ="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnclick;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	
	//create action methods
	public void setAgree() {
		agree.click();
	}

	public void setFname(String name) {
		fname.sendKeys(name);
	}

	public void setLname(String lastname) {
		lname.sendKeys(lastname);	
		}

	public void setEmail(String mail) {
		email.sendKeys(mail);	
		}

	public void setPhone(String number) {
		phone.sendKeys(number);
	}

	public void setPass(String pwd) {
		pass.sendKeys(pwd);
	}

	public void setCpass(String cpwd) {
		cpass.sendKeys(cpwd);
	}

	public void setBtnclick() {
		btnclick.click();
		
		//Btn click with various types
	/*	btnclick.submit();
		
		Actions act = new Actions(driver);
		act.moveToElement(btnclick).click().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnclick);
		
		btnclick.sendKeys(Keys.RETURN);
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnclick)).click();  */
	}
	
	
	

	
	//create action method without using RandomStringUtil class
	
//	public void registration(String firstname,String lastname,String mailid,String number,String password,String confirmpassword) {
//		
//		fname.sendKeys(firstname);
//		lname.sendKeys(lastname);
//		email.sendKeys(mailid);	
//		phone.sendKeys(number);
//		pass.sendKeys(password);
//		cpass.sendKeys(confirmpassword);
//		agree.click();
//		btnclick.click();
//		
//	}
	
	
	public String getConfirmationmsg() {
		
		
		return msgConfirmation.getText();
		
	}

	
	
	
	
	

}

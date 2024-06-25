package stepsDefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountRegistrationPage regpage;

	
	@Given("User navigate to Register Account page")
	public void user_navigate_to_register_account_page() {
		
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
	    
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
	   Map<String, String> datamap = dataTable.asMap(String.class, String.class);
	   regpage=new AccountRegistrationPage(BaseClass.getDriver());
	   regpage.setFirstName(datamap.get("firstName"));
	   regpage.setLastName(datamap.get("lastName"));
	   regpage.setEmail(BaseClass.randomeAlphaNumeric()+"@gmail.com");
	   regpage.setTelephone(datamap.get("telephone"));
	   regpage.setPassword(datamap.get("password"));
	   regpage.setConfirmPassword(datamap.get("password"));
	}

	@When("the user select privacy policy")
	public void the_user_select_privacy_policy() {
	   regpage.setPrivacyPolicy();
	}

	@When("click on continue button")
	public void click_on_continue_button() {
		regpage.clickContinue();
	   
	}

	@Then("User Account Should Create successfully")
	public void user_account_should_create_successfully() {
	   String confmsg = regpage.getConfirmationMsg();
	   Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
}

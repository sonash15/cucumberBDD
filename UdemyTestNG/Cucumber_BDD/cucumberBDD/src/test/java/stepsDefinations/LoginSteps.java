package stepsDefinations;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	List<HashMap<String, String>> datamap;
	
	@Given("the user navigate to login page")
	public void the_user_navigate_to_login_page() {
		BaseClass.getLogger().info("Click on Login");
	    hp=new HomePage(BaseClass.getDriver());
	    hp.clickMyAccount();
	    hp.clickLogin();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
	   BaseClass.getLogger().info("Entering Credentials");
	   lp=new LoginPage(BaseClass.getDriver());
	   lp.setEmail(email);
	   lp.setPassword(pwd);
	}

	@When("the user clicks on the Login Button")
	public void the_user_clicks_on_the_login_button() {
		
		lp.clickLogin();
		BaseClass.getLogger().info("Log in Successful");
	}

	@Then("the user should redirect to the My Account Page")
	public void the_user_should_redirect_to_the_my_account_page() {
		
		macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
	    
	}
	
	
	//Data Driven Test
	@Then("user should redirect to my account page by passing email and password with excel row {string}")
	public void user_should_redirect_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {
	   
		try {
			
			datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int index = Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("res");
		
		lp=new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
		
		lp.clickLogin();
		macc=new MyAccountPage(BaseClass.getDriver());
		
		try {
			
			boolean targetpage=macc.isMyAccountPageExists();
			System.out.println("Target Page "+targetpage);
			
			if(exp_res.equalsIgnoreCase("valid")) {
				if(targetpage==true) {
					
					MyAccountPage myaccpage = new MyAccountPage(BaseClass.getDriver());
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}else {
					
					Assert.assertTrue(false);
				}
			}
			
			if(exp_res.equalsIgnoreCase("Invalid")) {
				
				if(targetpage==true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				}
			}else {
				Assert.assertTrue(true);
			}
			
		} catch (Exception e) {
			
			Assert.assertTrue(false);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

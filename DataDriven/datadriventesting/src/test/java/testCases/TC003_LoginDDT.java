package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.HomePage;
import PageObjectModel.LogInPage;
import PageObjectModel.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseTest {
	
	@Test(dataProvider = "Logindata",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String password,String expected_result) throws InterruptedException {
		
		try {
		//Home page
		HomePage hp=new HomePage(driver);
		hp.myAccount();
		hp.login();
			
		//Login page
		LogInPage lp=new LogInPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.BtnLogin();
		

			
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isAccountpageExist();
		
		if(expected_result.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				macc.logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(expected_result.equalsIgnoreCase("Invalid")) {
			
			if(targetPage==true) {
				macc.logout();
				Assert.assertTrue(false);
			}else {
				assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			Assert.fail("An Exception Occured"+e.getMessage());
		}
		
		logger.info("Data Driven Test Case Pass");
		}

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.HomePage;
import PageObjectModel.LogInPage;
import PageObjectModel.MyAccountPage;

public class TC_002_LoginTest extends BaseTest{
	
	
	@Test
	public void login() throws InterruptedException {
		logger.info("Executing Login Test Case Start");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.myAccount();
		hp.login();
		
		LogInPage lp = new LogInPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.BtnLogin();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean pagemsg = mp.isAccountpageExist();
		Assert.assertTrue(pagemsg);
		//Assert.assertEquals(pagemsg, true,"Login failed");
		
		
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Executing Login Test Case Done");
	}

	
}

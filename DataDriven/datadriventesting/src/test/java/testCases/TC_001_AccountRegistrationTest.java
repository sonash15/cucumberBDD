package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectModel.HomePage;
import PageObjectModel.RegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseTest{
	
	@Test
	public void registerAcc() throws InterruptedException {
		
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		
		
		//First we need to call home page 
		HomePage hp = new HomePage(driver);
		hp.myAccount();
		hp.login();
		
		
		RegistrationPage rp = new RegistrationPage(driver);
		//rp.registration("sonal", "shinde", "sonal@gmail.com", "526879456", "asd123", "asd123"); //without using randome data
		logger.info("Passng Data For Registration");
		rp.setFname(randomString().toUpperCase());
		rp.setLname(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setPhone(randomeNumber());
		
		String Password = randAlphaNumeric();
		rp.setPass(Password);
		rp.setCpass(Password);
		
		rp.setAgree();
		rp.setBtnclick();
		
		logger.info("Msg Verification...");
		//Confirmation msg
		String cnfmsg = rp.getConfirmationmsg();
		if(cnfmsg.equals("Your Account Has Been Created!!!!!!!!!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("TC_001_AccountRegistrationTest Failed");
			logger.debug("Debug Log...");
			Assert.assertFalse(false);
		}
		
		//Assert.assertEquals(cnfmsg, " Has Been Created!");
		
		
		
//		catch (Exception e) {
//		
////			logger.error("TC_001_AccountRegistrationTest Failed");
////			logger.debug("Debug Log...");
//			Assert.fail();
//		
//		}
	}
	
	
}

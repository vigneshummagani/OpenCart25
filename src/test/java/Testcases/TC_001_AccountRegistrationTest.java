package Testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import BaseTests.BaseClass;
import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;


public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void Account_registraion_page()
	{
		try
		{
		logger.info("-----Starting TC_001_AccountRegistrationTest-----");
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.ClicKRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage REGPAGE = new AccountRegistrationPage(driver);
		logger.info("Filling the registration form");
		REGPAGE.setFirstName(randomString().toUpperCase());//Randomly Genetated
		REGPAGE.setLastName(randomString().toUpperCase());//Randomly Genetated
		
		REGPAGE.setEmail(randomString() + "@gmail.com");//Randomly Genetated
		REGPAGE.setMobileNumber(randomNumber());//Randomly Genetated
		
		//randomly passing inputs as same into password&confirmpassowrd
		String password = randomAlphaNumeric();	
		
		
		REGPAGE.setPassword(password);
		REGPAGE.setConfirmPassword(password);
		REGPAGE.ClickNewsLetter();
		REGPAGE.ClickAgree();
		REGPAGE.ClickContinue();
		
		logger.info("Validating the expected message");
		String cnfrmMsg = REGPAGE.getConfirmationMsg();
		
		
		/*if(cnfrmMsg.equals("Your Account Has Been Created!!!!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("debug logs....");
			Assert.assertTrue(false);
		}
		*/
		Assert.assertEquals(cnfrmMsg, "Your Account Has Been Created!");
		}
		
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("-----Finished TC_001_AccountRegistrationTest-----");
	}

	
}

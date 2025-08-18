package Testcases;

import org.testng.annotations.Test;

import BaseTests.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import junit.framework.Assert;

public class TC_004_SearchTest extends BaseClass {
	
	@Test
	public void verify_SearchProuct()
	{
		logger.info("-----Start  verify_SearchProuct-----");
	try {
		
		   //homepage
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin();
			
			//login
			LoginPage lp = new LoginPage(driver);
			lp.inputEmail(p.getProperty("email"));
			lp.inputPassword(p.getProperty("password"));
			lp.clickLoginBtn();
			
			//Search product
			SearchPage sp = new SearchPage(driver);
			//sp.clickinputSearchBox();
			sp.clickinputSearchBox("iphone");
			sp.clickSearchbtn();
			
			boolean targetPage = sp.isIphoneTxtisplayed();
			
			//Assert.assertEquals(targetPage , true, "Login failed");
			Assert.assertTrue(targetPage);
	}
	catch(Exception e) {
		Assert.fail();
	}
	logger.info("-----Fineshed verify_SearchProuct-----");

 }
}
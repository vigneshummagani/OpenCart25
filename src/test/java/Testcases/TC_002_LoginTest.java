package Testcases;

import org.testng.annotations.Test;

import BaseTests.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import junit.framework.Assert;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity","Master"})
	public void verify_Login()
	{
		try
		{
			//homepage
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin();
			
			//login
			LoginPage lp = new LoginPage(driver);
			lp.inputEmail(p.getProperty("email"));
			lp.inputPassword(p.getProperty("password"));
			lp.clickLoginBtn();
			
			//myaccount
			MyAccountPage MACC = new MyAccountPage(driver);
			boolean targetPage = MACC.isMyAccountPagedisplayed();
			
			//Assert.assertEquals(targetPage , true, "Login failed");
			Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}

package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTests.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataProviders;

/*Data is valid login success - test pass logout
Data is valid -- login failed - test fail
Data is invalid - login success - test fail - logout
Data is invalid login failed test pass I
*/
public class TC_003_LoginDataDrivenTesting extends BaseClass
{

	@Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class,groups= {"DataDriven"})//getting data from diffrent
	public void verify_loginDDT(String email,String password, String exp)
	{
		logger.info("-----Starting TC_003_LoginDataDrivenTesting-------");
		try {
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.inputEmail(email);
		lp.inputPassword(password);
		lp.clickLoginBtn();
		
		//myaccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPagedisplayed();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
		{
				macc.ClickLogout();
				Assert.assertTrue(true);
		}
			else
			{
				Assert.assertTrue(false);
				}
			}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.ClickLogout();
				Assert.assertTrue(false);
				}
			else
			{
				Assert.assertTrue(true);
				}
			}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("-----Fineshed TC_003_LoginDataDrivenTesting-------");
	}
	
}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement myAccountText;
	
	
	//@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement LnkLogout;
	//@FindBy(linkText="Logout") WebElement LnkLogout;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/aside[1]/div[1]/a[13]") WebElement LnkLogout;
	
	
	public boolean isMyAccountPagedisplayed() 
	{
		try
		{
			return(myAccountText.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	/*public void ClickMyAccount() {
		MyAccount.click();
	}*/
	public void ClickLogout()
	{
		LnkLogout.click();
	}
}

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
	//@FindBy(className="list-group-item")WebElement myAccountText;
	//@FindBy(xpath="//a[@title='My Account']")
	
	@FindBy(xpath="//a[@title='My Account']") WebElement MyAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")WebElement LnkLogout;
	
	//@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement LnkLogout;
	
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
	public void ClickMyAccount() {
		MyAccount.click();
	}
	public void ClickLogout()
	{
		LnkLogout.click();
	}
}

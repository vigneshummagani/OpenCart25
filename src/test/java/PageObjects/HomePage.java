package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user']") WebElement MyAccount;
	@FindBy(xpath= "//a[normalize-space()='Register']") WebElement Register;
	@FindBy(xpath= "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement Login;
	
	
	public void ClickMyAccount()
	{
		MyAccount.click();
	}
	
	public void ClicKRegister()
	{
		Register.click();
	}

	public void ClickLogin()
	{
		Login.click();
	}
}

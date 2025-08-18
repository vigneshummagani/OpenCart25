package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath= "//input[@id='input-firstname']") WebElement TextFirstName;
	@FindBy(xpath= "//input[@id='input-lastname']") WebElement TextLastName;
	@FindBy(xpath= "//input[@id='input-email']") WebElement TextEmail;
	@FindBy(xpath= "//input[@id='input-telephone']") WebElement NbrTelephone;
	@FindBy(xpath= "//input[@id='input-password']") WebElement TextPassword;
	@FindBy(xpath= "//input[@id='input-confirm']") WebElement TextConfirmPassword;
	@FindBy(xpath= "//input[@value='0']") WebElement NewLetterButton;
	@FindBy(xpath= "//input[@name='agree']") WebElement AgreeButton;
	@FindBy(xpath= "//input[@value='Continue']") WebElement ContinueButton;
	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	public void setFirstName(String FirstName)
	{
		TextFirstName.sendKeys(FirstName);
	}
	public void setLastName(String LastName)
	{
		TextLastName.sendKeys(LastName);
	}
	public void setEmail(String Email)
	{
		TextEmail.sendKeys(Email);
	}
	public void setMobileNumber(String Mobilenbr)
	{
		NbrTelephone.sendKeys(Mobilenbr);
	}
	public void setPassword(String Pswd)
	{
		TextPassword.sendKeys(Pswd);
	}
	public void setConfirmPassword(String cnfmPswd)
	{
		TextConfirmPassword.sendKeys(cnfmPswd);
	}
	public void ClickNewsLetter()
	{
		NewLetterButton.click();
	}
	public void ClickAgree()
	{
		AgreeButton.click();
	}
	public void ClickContinue()
	{
		ContinueButton.click();
		//sol2
		//btnContinue.submit();

		//sol3
		//Actions act = new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();

		//sol4
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);

		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);

		//Sol6
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	public String getConfirmationMsg() {
	 try 
	 {
		 return (msgConfirmation.getText());
	 } 
	 catch (Exception e) 
	 {
		return (e.getMessage());
	 }
 }

}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	//@FindBy(name="search") WebElement SearchBox;
	@FindBy(xpath="//input[@placeholder='Search']")WebElement SearchBox;
	@FindBy(xpath="//i[@class='fa fa-search']")WebElement SearchButton;
	@FindBy(xpath= "//h1[normalize-space()='Search - iphone']") WebElement ConfirmIphone;
	
	public void clickinputSearchBox(String productName)
	{
		//SearchBox.click();
		SearchBox.sendKeys(productName);
	}
	public void clickSearchbtn()
	{
		SearchButton.click();
	}
	public boolean isIphoneTxtisplayed() 
	{
		try
		{
			return(ConfirmIphone.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

}

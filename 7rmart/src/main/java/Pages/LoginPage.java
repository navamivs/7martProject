package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//Mandatory then only pagefactory approach will work
	}
	
	@FindBy (xpath="//input[@placeholder='Username']") WebElement usernamefield;
	@FindBy (xpath="//input[@placeholder='Password']") WebElement passwordfield;
	@FindBy (xpath="//*[@type='submit']") WebElement LoginField;
	@FindBy (xpath="//*[text()=' Alert!']") WebElement alert;
	@FindBy (xpath="(//*[text()='Manage Pages'])[2]") WebElement dashboardelement;
	
	public LoginPage enterUsernameOnUserNameField(String username)
	{
		usernamefield.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);
		return this;
	}
	
	
	public LoginPage clickOnLoginButton()
	{
		LoginField.click();
		return this;
	}
	
	public boolean dashboardpage()

	{
		boolean dasboardstatus=dashboardelement.isDisplayed();
		return dasboardstatus;
	}
	public boolean presenceOfAlert()
	{
		boolean alertstatus=alert.isDisplayed();
		return alertstatus;
	}
	
	

}

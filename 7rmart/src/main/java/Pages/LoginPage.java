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
	
	@FindBy (xpath="//input[@placeholder='Username']")private WebElement usernamefield;
	@FindBy (xpath="//input[@placeholder='Password']")private WebElement passwordfield;
	@FindBy (xpath="//*[@type='submit']")private WebElement LoginField;
	@FindBy (xpath="//*[text()=' Alert!']")private WebElement alert;
	@FindBy (xpath="(//*[text()='Manage Pages'])[2]")private WebElement dashboardelement;
	
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
	
	
	public AdminUserPage clickOnLoginButton()
	{
		LoginField.click();
		return new AdminUserPage(driver);
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

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=' New']") WebElement newfield;
	@FindBy(xpath="//input[@id='username']") WebElement adminusernamefield;
	@FindBy(xpath="//input[@id='password']") WebElement adminpasswordfield;
	@FindBy(xpath="//button[@name='Create']") WebElement savefield;
	@FindBy(xpath="//select[@id='user_type']") WebElement selectfield;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alertfield;
	
	 public AdminUserPage navigation(String url)
	 {
		 driver.navigate().to(url);
		 return this;
	 }
	
	public AdminUserPage addNewUser(String username,String password)	
	{
		newfield.click();
		adminusernamefield.sendKeys(username);
		adminpasswordfield.sendKeys(password);
		PageUtility pageutility=new PageUtility();
		pageutility.selectAValueUsingSelectByIndex(selectfield, 2);	
		savefield.click();
		return this;
	}
	
	public boolean userCreationAlert()
	{
		boolean alert=alertfield.isDisplayed();
		return alert;
	}
	
	
	

}

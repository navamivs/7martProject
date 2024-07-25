package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

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
	@FindBy(xpath="//a[@class='page-link']") List<WebElement >pagelength;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement deletealert;
	@FindBy(xpath="//tbody//tr") List<WebElement >rowlength;
	@FindBy(xpath=" //h5[normalize-space()='Alert!']" )WebElement statusalertfield;
	
	
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
	
	public AdminUserPage deleteUser(String usernamedelete)
	{
		PageUtility pageutility=new PageUtility();
		int pages=pagelength.size();
		int rowsize=rowlength.size();
		String deleteusername = null;
		for(int j=1;j<=pages;j++)
		{
			if(j>1)
			{
				WebElement eachtablenumber=driver.findElement(By.xpath("//a[normalize-space()="+j+"]"));
				pageutility.forceClickUsingJavaScriptExecutor(driver, eachtablenumber);
			}
			for(int i=1;i<rowsize;i++)
			{
			
			WebElement deleteuser=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]"));
			deleteusername=deleteuser.getText();
			if(deleteusername.equals(usernamedelete))
			{
				
				WebElement deletebutton=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]//a[3]"));
				pageutility.forceClickUsingJavaScriptExecutor(driver, deletebutton);
				pageutility.AcceptNormalOrConfirmationAlert(driver);
				break;
			}
			
			}
			if(usernamedelete.equals(deleteusername))
			{
				break;
			}
		}
		return this;
	}
	
	public boolean deleteAlert()
	{
		boolean delete=deletealert.isDisplayed();
		return delete;
		
	}

	public AdminUserPage changeUserStatus(String usernameforstatuschange)
	{
		PageUtility pageutility=new PageUtility();
		int pages=pagelength.size();
		int rowsize=rowlength.size();
		String username = null;
		for(int j=1;j<=pages;j++)
		{
			if(j>1)
			{
				WebElement eachtablenumber=driver.findElement(By.xpath("//a[normalize-space()="+j+"]"));
				pageutility.forceClickUsingJavaScriptExecutor(driver, eachtablenumber);
			}
			for(int i=1;i<rowsize;i++)
			{
			
			WebElement usernamefield=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]"));
			username=usernamefield.getText();
			if(username.equals(usernameforstatuschange))
			{
				System.out.println(usernameforstatuschange);
				WebElement statusbutton=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]//a[1]"));
				pageutility.forceClickUsingJavaScriptExecutor(driver, statusbutton);
				System.out.println(usernameforstatuschange);
				break;
			}
			
			}
			if(usernameforstatuschange.equals(username))
			{
				break;
			}
			
		}
		return this;
	}
	
	public boolean statusAlert()
	{
		boolean alert=statusalertfield.isDisplayed();
		return alert;
	}	
}

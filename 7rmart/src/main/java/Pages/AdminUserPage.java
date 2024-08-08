package Pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//a[text()=' New']") private WebElement newfield;
	@FindBy(xpath="//input[@id='username']")private WebElement adminusernamefield;
	@FindBy(xpath="//input[@id='password']")private WebElement adminpasswordfield;
	@FindBy(xpath="//button[@name='Create']")private WebElement savefield;
	@FindBy(xpath="//select[@id='user_type']")private WebElement selectfield;
	@FindBy(xpath="//h5[text()=' Alert!']") private WebElement alertfield;
	@FindBy(xpath="//a[@class='page-link']") private List<WebElement >pagelength;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement deletealert;
	@FindBy(xpath="//tbody//tr")private List<WebElement >rowlength;
	@FindBy(xpath="//h5[normalize-space()='Alert!']" )private WebElement statusalertfield;
	
	
	public String fakername()
	{
		PageUtility pageutility=new PageUtility();
		String name=pageutility.fakerNameStrings();
		return name;
	}
	
	 public AdminUserPage navigation(String url)
	 {
		 driver.navigate().to(url);
		 return this;
	 }
	
	public AdminUserPage newFieldClick()	
	{
		newfield.click();
		return this;
	}
	
	public AdminUserPage selectOption()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectAValueUsingSelectByIndex(selectfield, 2);	
		return this;
	}
	public AdminUserPage save()
	{
	savefield.click();
	return this;
	}
	public AdminUserPage sendUserName(String username)
	{
		adminusernamefield.sendKeys(username);
		return this;
	}
	
	public AdminUserPage sendPassword(String password)
	{
		adminpasswordfield.sendKeys(password);
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
		int flag=0;
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
				flag=1;
				break;
			}
			
			}
			if(flag==1)
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
		int flag=0;
		String username = null;
		for(int j=1;j<=pages;j++)
		{
			if(j>1)
			{
				WebElement eachtablenumber=driver.findElement(By.xpath("//a[normalize-space()="+j+"]"));
				pageutility.forceClickUsingJavaScriptExecutor(driver, eachtablenumber);
			}
			for(int i=1;i<=rowsize;i++)
			{
			
			WebElement usernamefield=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]"));
			username=usernamefield.getText();
			if(username.equals(usernameforstatuschange))
			{
				WebElement statusbutton=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]//a[1]"));
				pageutility.forceClickUsingJavaScriptExecutor(driver, statusbutton);
				flag=1;
				break;
			}
			
			}
			if(flag==1)
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

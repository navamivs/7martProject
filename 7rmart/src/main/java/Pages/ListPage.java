package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.Constants;
import utilities.FileUtility;
import utilities.PageUtility;

public class ListPage {
	WebDriver driver;
	public ListPage(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newfield;
	@FindBy(xpath="//input[@id='title']")private WebElement tittlefield;
	@FindBy(xpath="//div[@role='textbox']//p") private WebElement descriptionfield;
	@FindBy(xpath="//input[@id='page']") private WebElement pagefield;
	@FindBy(xpath="//input[@id='main_img']")private WebElement choosefilefield;
	@FindBy(xpath="//button[@name='create']")private WebElement savefield;
	@FindBy(xpath="//li[@class='page-item active'or@class='page-item']")private List< WebElement> nooftablepages;
	@FindBy(xpath="//tbody//tr")private List< WebElement> rowcount;
	@FindBy(xpath="//*[@data-dismiss='alert']") private WebElement creationalert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement search;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alredypaegeexistalert;
	@FindBy(xpath="//input[@placeholder='Title']")private WebElement tittlesearchdield;
	@FindBy(xpath="//button[@name='Search']")private WebElement tittlesearch;
	
	 public ListPage navigation(String url)
	 {
		 driver.navigate().to(url);
		 return this;
	 }
	 public ListPage newFieldClick()
	 {
		 FileUtility fileutility=new FileUtility();
		 newfield.click();
		 return this;
	 }
	 public ListPage sendTittle(String tittle)
	 {
		 tittlefield.sendKeys(tittle);
		 return this;
	 }
	 public ListPage descriptionfield(String description)
	 {
		 descriptionfield.sendKeys(description);
		 return this;
	 }
	 public ListPage sendKeys(String pagename)
	 {
		 pagefield.sendKeys(pagename);
		 return this;
	 }
	 
	 
	 public ListPage fileUpload()
	 {
		 FileUtility fileutility=new FileUtility();
		 fileutility.fileUpload(choosefilefield,Constants.iphonefile);
		 return this;
	 }
		 
	 public ListPage saveField()
	 {
		 savefield.click();
		 return this;
	 }
	 
	 public boolean alertForListCreation() 
	 {
		driver.navigate().back();//need a navigate back for alert may the issue with the page
		 boolean alert;
		alert= creationalert.isDisplayed();
		return alert;
	 }
	 
	 public boolean alertForDuplicatePage() 
	 {
		 boolean alert;
		alert=alredypaegeexistalert.isDisplayed();
		return alert;
	 }
	 public  void searchWithTittleName(String pagename)
	 {
		 search.click();
		 tittlesearchdield.sendKeys(pagename);
		 tittlesearch.click(); 
	 }
	 	 
	 
	public boolean validateTheCreatedNewListPage(String tittlename)
	 {
		 //ListPage listpage=new ListPage(driver);
		 boolean status=false;
		 String actualtittle= null;
		int pagesize= nooftablepages.size();
		int flag=0;
		int rownumber= rowcount.size();
		for(int i=1;i<=pagesize;i++)
			
		{
			if(i>1)
			{
				driver.findElement(By.xpath("//a[normalize-space()="+i+"]")).click();
			}
			for(int j=1;j<=rownumber;j++)
			{
				actualtittle=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[1]")).getText();
				if(tittlename.equals(actualtittle))
				{
					status = true;
					flag=1;
					break;
					
				}
			}
			if(flag==1)
			{
				break;
			}
		}
		return status;
	 }
	 
}

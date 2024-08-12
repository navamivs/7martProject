package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Constants.Constants;
import utilities.FileUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ListSubCategoriesPage {
	WebDriver driver;
	public ListSubCategoriesPage(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
     }
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][normalize-space()='More info']") private WebElement moreinfo ;
	@FindBy(xpath="//i[@class=' fa fa-search']") WebElement search;
	@FindBy(xpath="//*[@id='un']")WebElement selectfield;
	@FindBy(xpath="//button[@name='Search']") WebElement insidesearchfield;
	@FindBy(xpath="//tbody/tr[1]/td[2]") WebElement categoryfield;
	@FindBy(xpath="//tbody/tr[1]/td[5]/a[1]/i[1]")WebElement editfield;
	@FindBy(xpath="//*[@id='main_img']") WebElement fileuploadfield;
	@FindBy(xpath="//button[@name='update']")WebElement updatefield;
	@FindBy(xpath="//h5[normalize-space()='Alert!']")WebElement alert;
	public ListSubCategoriesPage moreinfoclick()
	{
		moreinfo.click();
		return this;
	}
	public ListSubCategoriesPage searchclick()
	{
		search.click();
		return this;
	}
	public ListSubCategoriesPage selectCategory()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectAValueUsingSelectByIndex(selectfield, 3);
		return this;
	}
	public ListSubCategoriesPage insidesearchclick()
	{
		insidesearchfield.click();
		return this;
	}
	public boolean validateCategory(String expectedcategory)
	{
		String actualcategory=categoryfield.getText();
		if(expectedcategory.equals(actualcategory))
		{
			return true;
		}
		
		else
			return false;
	}
	
	public ListSubCategoriesPage clickOnedit()
	{
		editfield.click();
		return this;
	}
	public ListSubCategoriesPage clickFileUpload() 
	{
		
		PageUtility pageutility=new PageUtility();
		pageutility.forceClickUsingJavaScriptExecutor(driver, fileuploadfield);
		return this;
	}
	public ListSubCategoriesPage uploadFile()
	{
		FileUtility fileutility=new FileUtility();
		fileutility.fileUpload(fileuploadfield,Constants.iphonefile);
		return this;
	}
	public ListSubCategoriesPage clickOnUpdate()
	{
		updatefield.click();
		return this;
	}
	public boolean validateAlert()
	{
		boolean status=alert.isDisplayed();
		return status;
	}
	
	
	
}

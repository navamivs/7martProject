package testScripts;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ListPage;
import Pages.LoginPage;
import utilities.ExcelReadUtility;

public class ListTest extends Base
{
	
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="New Tittle Creation")
	public void verifyWhetherNewTittleNameIsAbleToAdd()
	{
	String username=ExcelReadUtility.getString(1, 0,"LoginPage");
	String password=ExcelReadUtility.getString(1, 1,"LoginPage");
	String url= ExcelReadUtility.getString(1, 0,"ListPage");                        
	String tittle=ExcelReadUtility.getString(1, 1,"ListPage"); //change it if you create again                   
	String description= ExcelReadUtility.getString(1, 2,"ListPage");                   
	String pagename= ExcelReadUtility.getString(1, 3,"ListPage");                          
	LoginPage loginpages=new LoginPage(driver);
	loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
	ListPage listpage=new ListPage(driver);
	listpage.navigation(url).newFieldClick().sendTittle(tittle).descriptionfield(description).sendKeys(pagename).fileUpload().saveField();
	boolean status=listpage.alertForListCreation();
	assertTrue(status,"Error Occoured ,New Tittle  name is unable to add ");
    }
	
	@Test(retryAnalyzer=retry.Retry.class,description="The field should not allow to add duplicate tittle")
	public void verifyWhetherDuplicateTittleIsNotEnabledToAdd()
	{
	String username=ExcelReadUtility.getString(1, 0,"LoginPage");
	String password=ExcelReadUtility.getString(1, 1,"LoginPage");
	String url=ExcelReadUtility.getString(1, 0,"ListPage");  
	String tittle=ExcelReadUtility.getString(1, 1,"ListPage"); 
	String description="";
	String pagename= ExcelReadUtility.getString(2, 3,"ListPage"); //you can change if you need
	LoginPage loginpages=new LoginPage(driver);
	loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
	ListPage listpage=new ListPage(driver);
	listpage.navigation(url).newFieldClick().sendTittle(tittle).descriptionfield(description).sendKeys(pagename).fileUpload().saveField();
	boolean status=listpage.alertForDuplicatePage();
	assertTrue(status,"The field allowed to add duplicate tittle name which is an unexpected functionality");
    }
	
	@Test(groups= {"Smoke"},retryAnalyzer=retry.Retry.class,description="Searching using tittle name")
	public void verifyWhetherSearchTabAllowsToSearchValidTittlesName()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");
		String url="https://groceryapp.uniqassosiates.com/admin/list-page";
		String tittlename=ExcelReadUtility.getString(1, 4,"ListPage");//you can change if you need 
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		ListPage listpage=new ListPage(driver);
		listpage.navigation(url).searchWithTittleName(tittlename);
		boolean status=listpage.validateTheCreatedNewListPage(tittlename);
		assertTrue(status,"Valid tittlename was unable to search");
		
	}
	
	
}









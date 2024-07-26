package testScripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ListPage;
import Pages.LoginPage;

public class ListTest extends Base
{
	
	@Test
	public void verifyWhetherNewTittleNameIsAbleToAdd()
	{
	String username="admin";
	String password="admin";
	String url="https://groceryapp.uniqassosiates.com/admin/list-page";
	String tittle="Iphone 15 pro";	
	String description="Advanced dual-camera system with 12MP Wide and Ultra Wide cameras; Photographic Styles, Smart HDR 4, Night mode, 4K Dolby Vision HDR recording";
	String pagename="Phones";//Change at run
	LoginPage loginpages=new LoginPage(driver);
	loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
	ListPage listpage=new ListPage(driver);
	listpage.navigation(url).createNewListPage(tittle,description,pagename);
	boolean status=listpage.alertForListCreation();
	Assert.assertTrue(status,"Error Occoured ,New Tittle  name is unable to add ");
    }
	
	@Test
	public void verifyWhetherDuplicateTittleIsNotEnabledToAdd()
	{
	String username="admin";
	String password="admin";
	String url="https://groceryapp.uniqassosiates.com/admin/list-page";
	String tittle="Iphone 15 pro";
	String description="";
	String pagename="Best Travel partner12_02_2023_07_57_30";//you can change if you need
	LoginPage loginpages=new LoginPage(driver);
	loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
	ListPage listpage=new ListPage(driver);
	listpage.navigation(url).createNewListPage(tittle,description,pagename);
	boolean status=listpage.alertForDuplicatePage();
	Assert.assertTrue(status,"The field allowed to add duplicate tittle name which is an unexpected functionality");
    }
	
	@Test
	public void verifyWhetherSearchTabAllowsToSearchValidTittlesName()
	{
		String username="admin";
		String password="admin";
		String url="https://groceryapp.uniqassosiates.com/admin/list-page";
		String tittlename="Lavender";//you can change if you need 
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		ListPage listpage=new ListPage(driver);
		listpage.navigation(url).searchWithTittleName(tittlename);
		boolean status=listpage.validateTheCreatedNewListPage(tittlename);
		Assert.assertTrue(status,"Valid tittlename was unable to search");
		
	}
	
	
}









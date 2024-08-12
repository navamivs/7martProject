package testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import Pages.ListSubCategoriesPage;
import Pages.LoginPage;
import utilities.ExcelReadUtility;

public class ListSubCategoriesTest extends Base
{
	
	@Test(retryAnalyzer=retry.Retry.class,description="The field should search electronics category")
	public void verifySearchCategory()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");                       
		String category=ExcelReadUtility.getString(1, 1,"ListSubCat");                                           
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		ListSubCategoriesPage listsubcategories=new ListSubCategoriesPage(driver);
		listsubcategories.moreinfoclick().searchclick().selectCategory().insidesearchclick();
		boolean status=listsubcategories.validateCategory(category);
		assertTrue(status,"Searched category doesnot match");
	}
	
	@Test(retryAnalyzer=retry.Retry.class,description="The field should update the image of electronics category")
	public void verifyImageFieldUpatedForSearchedCategory() 
	{
		String username = ExcelReadUtility.getString(1, 0, "LoginPage");
		String password = ExcelReadUtility.getString(1, 1, "LoginPage");
		String category = ExcelReadUtility.getString(1, 1, "ListSubCat");
		LoginPage loginpages = new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		ListSubCategoriesPage listsubcategories = new ListSubCategoriesPage(driver);
		listsubcategories.moreinfoclick().searchclick().selectCategory().insidesearchclick().clickOnedit()
				.clickFileUpload().uploadFile().clickOnUpdate();
		boolean status=listsubcategories.validateAlert();
		assertTrue(status,"Error Occoured ,Image field couldnot update");
	}

}

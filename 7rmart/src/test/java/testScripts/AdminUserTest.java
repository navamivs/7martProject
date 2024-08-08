package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.AdminUserPage;
import Pages.LoginPage;
import utilities.ExcelReadUtility;

public class AdminUserTest extends Base {

	@Test(groups= {"Smoke"},retryAnalyzer=retry.Retry.class,description="New User Creation")
	public void verifyWhetherAnewUserIsAbleToBeCreated()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");
		String url=ExcelReadUtility.getString(1, 0,"AdminUser");
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		String adminusername=adminuserpage.fakername();
		String adminpassword=ExcelReadUtility.getString(1, 1,"AdminUser");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		adminuserpage.navigation(url).newFieldClick().sendUserName(adminusername).sendPassword(adminpassword).selectOption().save();
		boolean alertstatus=adminuserpage.userCreationAlert();
		assertTrue(alertstatus,"Error occoured,Unable to create new User");
	}
	
	@Test(retryAnalyzer=retry.Retry.class,description="User Deletion")
	public void verifyWhetherAuserIsableToBeDeleted()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");
		String deleteuser=ExcelReadUtility.getString(1, 2,"AdminUser");//change value at each run
		String url=ExcelReadUtility.getString(1, 0,"AdminUser");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.navigation(url).deleteUser(deleteuser);
		boolean deletestatus=adminuserpage.deleteAlert();
		assertTrue(deletestatus,"Error Occoured,Unable to delete the  user");
	}
	
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="Checking the status change" )
	public void verifyWhetherAuserStatusIsableToChange()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");
		String userforstatuschange=ExcelReadUtility.getString(1, 3,"AdminUser");//change value at each run
		String url=ExcelReadUtility.getString(1, 0,"AdminUser");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.navigation(url).changeUserStatus(userforstatuschange);
		boolean statusalert=adminuserpage.statusAlert();
		assertTrue(statusalert,"Error Occoured,Unable change the user status");
	}	
}

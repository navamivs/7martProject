package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.AdminUserPage;
import Pages.LoginPage;

public class AdminUserTest extends Base {

	@Test
	public void verifyWhetherAnewUserIsAbleToBeCreated()
	{
		String username="admin";
		String password="admin";
		String url="https://groceryapp.uniqassosiates.com/admin/list-admin";
		Faker faker = new Faker();
		String adminusername=faker.address().firstName();
		String adminpassword="imavan";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.navigation(url).addNewUser(adminusername, adminpassword);
		boolean alertstatus=adminuserpage.userCreationAlert();
		Assert.assertTrue(alertstatus,"Error occoured,Unable to create new User");
	}
	
	@Test
	public void verifyWhetherAuserIsableToBeDeleted()
	{
		String username="admin";
		String password="admin";
		String deleteuser="Bijith Frieda";//change value at each run
		String url="https://groceryapp.uniqassosiates.com/admin/list-admin";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.navigation(url).deleteUser(deleteuser);
		boolean deletestatus=adminuserpage.deleteAlert();
		Assert.assertTrue(deletestatus,"Error Occoured,Unable to delete the  user");
	}
	
	@Test
	public void verifyWhetherAuserStatusIsableToChange()
	{
		String username="admin";
		String password="admin";
		String userforstatuschange="clientbjkbkbkbihl";//change value at each run
		String url="https://groceryapp.uniqassosiates.com/admin/list-admin";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.navigation(url).changeUserStatus(userforstatuschange);
		boolean statusalert=adminuserpage.statusAlert();
		Assert.assertTrue(statusalert,"Error Occoured,Unable change the user status");
	}	
}

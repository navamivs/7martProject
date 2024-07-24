package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends Base{
	
	
	
	@Test
	public void verifyUserIsAbleToLoginWithCorrectCredentials()
	{
		String username="admin";
		String password="admin";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean dashboardstatus=loginpages.dashboardpage();
		Assert.assertTrue(dashboardstatus,"User is unable to login with correct Credentials");
			
	}
	
	@Test
	public void verifyUserIsAbleToLoginWithWrongUsernameCorrectPassword()
	{
		String username="navami";
		String password="admin";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean alertstatus=loginpages.presenceOfAlert();
		Assert.assertTrue(alertstatus,"User is able to login with Wrong Username & CorrectPassword");
		
	}
	
	
	@Test
	public void verifyUserIsAbleToLoginWithCorrectUsernameWrongPassword()
	{
		String username="admin";
		String password="navamivs";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean alertstatus=loginpages.presenceOfAlert();
		Assert.assertTrue(alertstatus,"User is able to login with Correct Username & WrongPassword");
		
	}
	@Test
	public void verifyUserIsAbleToLoginWithIncorrectUserNameAndIncorrectPassword()
	{

		String username="admin123";
		String password="navamivs";
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean alertstatus=loginpages.presenceOfAlert();
		Assert.assertTrue(alertstatus,"User is able to login with Wrong Username & Wrong Password");
	}
	
	
	
	

}

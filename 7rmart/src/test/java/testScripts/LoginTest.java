package testScripts;

import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utilities.ExcelReadUtility;

public class LoginTest extends Base{
	
	
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToLoginWithCorrectCredentials()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean dashboardstatus=loginpages.dashboardpage();
		assertTrue(dashboardstatus,"User is unable to login with correct Credentials");
			
	}
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToLoginWithWrongUsernameCorrectPassword()
	{
		String username=ExcelReadUtility.getString(2, 0,"LoginPage");
		String password=ExcelReadUtility.getString(2, 1,"LoginPage");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean alertstatus=loginpages.presenceOfAlert();
		assertTrue(alertstatus,"User is able to login with Wrong Username & CorrectPassword");
		
	}
	
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToLoginWithCorrectUsernameWrongPassword()
	{
		String username=ExcelReadUtility.getString(3, 0,"LoginPage");
		String password=ExcelReadUtility.getString(3, 1,"LoginPage");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean alertstatus=loginpages.presenceOfAlert();
		Assert.assertTrue(alertstatus,"User is able to login with Correct Username & WrongPassword");
		
	}
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToLoginWithIncorrectUserNameAndIncorrectPassword()
	{

		String username=ExcelReadUtility.getString(4, 0,"LoginPage");
		String password=ExcelReadUtility.getString(4, 1,"LoginPage");
		LoginPage loginpages=new LoginPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		boolean alertstatus=loginpages.presenceOfAlert();
		assertTrue(alertstatus,"User is able to login with Wrong Username & Wrong Password");
	}
	
	
	
	

}

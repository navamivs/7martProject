package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ManageProductPage;
import utilities.ExcelReadUtility;

public class ManageProductTest extends Base {

	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="List count updation verification")
	public void verfifywhetherListProductsCountUpdatesWhenAProductIsDeleted()
	{
		String username=ExcelReadUtility.getString(1, 0,"LoginPage");
		String password=ExcelReadUtility.getString(1, 1,"LoginPage");
		LoginPage loginpages=new LoginPage(driver);
		ManageProductPage manageproductpage=new ManageProductPage(driver);
		loginpages.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		manageproductpage.moreInfoClick().listProductCountBeforeDeletion().deleteClick().listProductCountAfterDeletion();
		boolean status=manageproductpage.listProductCountAfterDeletion();
		assertTrue(status,"Error Occoured ,List Products Count Not Updated After Deletion");
	}
	

}

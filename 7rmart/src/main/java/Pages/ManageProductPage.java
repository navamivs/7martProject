package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageProductPage {
		WebDriver driver;
		public ManageProductPage(WebDriver driver)
		{
			this.driver=driver;
		    PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][normalize-space()='More info']")private WebElement moreinfofield ;
		@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/section[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[9]/a[2]/i[1]") private WebElement delete;
		@FindBy(xpath="//h4[text()='List Products']/b")private WebElement listproducttext;
		int globalexpectedcount=0;
		public ManageProductPage moreInfoClick()
		{
			moreinfofield.click();
			return this;
		}
		public  ManageProductPage listProductCountBeforeDeletion()
		{
			String beforedeletionstring=listproducttext.getText();
			String textcountsubstring=beforedeletionstring.substring(beforedeletionstring.indexOf("(")+1,beforedeletionstring.indexOf(")"));
			int count=Integer.parseInt(textcountsubstring);
			int expectedcount=count-1;
			globalexpectedcount=expectedcount;
			return this;
		}
		
		public ManageProductPage deleteClick()
		{
			PageUtility pageutility=new PageUtility();
			delete.click();
			pageutility.AcceptNormalOrConfirmationAlert(driver);
			
			return this;
		}
		public boolean listProductCountAfterDeletion()
		{
			String afterdeletionstring=listproducttext.getText();
			String textcountsubstring=afterdeletionstring.substring(afterdeletionstring.indexOf("(")+1,afterdeletionstring.indexOf(")"));
			int count=Integer.parseInt(textcountsubstring);
			if(count==globalexpectedcount)
			{
				return true;
			}
			return false;
		}
		
}

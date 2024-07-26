package testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtility;

public class Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void initialize()
	{
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAITTIME));
		
	}
	
	
   @AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	

}

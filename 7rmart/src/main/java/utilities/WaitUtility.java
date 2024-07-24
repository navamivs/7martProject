package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
public static final long EXPlICITWAITTIME=20;
public static final long IMPLICITWAITTIME=10;
	public void ExplicitWaitUntilElementToBeClickable( WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	public void ExplicitWaitUntilElementToBeVisible( WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) Element));
	}
	public void ExplicitWaitUntilAlertMatches( WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void ExplicitWaitUntilElementToBeSelected( WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.elementToBeSelected(Element));
	}
	
}

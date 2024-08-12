package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
public static final long EXPlICITWAITTIME=10;
public static final long POLLINGWAITTIME=5;
public static final long IMPLICITWAITTIME=30;
	public void ExplicitWaitUntilElementToBeClickable( WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	public void ExplicitWaitUntilElementToBeVisible( WebDriver driver, WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By)Element));	
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
	public void ExplicitWaitUntilPresenceOfAllElementsLocatedBy( WebDriver driver,WebElement Elements)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPlICITWAITTIME));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) Elements));
	}
	
	public WebElement fluentWaitForElementToBePresent(By locator, By element, WebDriver  driver) 
	{
        
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(EXPlICITWAITTIME))          
            .pollingEvery(Duration.ofSeconds(POLLINGWAITTIME))          
            .ignoring(NoSuchElementException.class);      

        
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement parentElement = driver.findElement(locator);
                return parentElement.findElement(element);
            }
        });
    }
	
}

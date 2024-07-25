package utilities;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectAValueUsingSelectByVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectAValueUsingSelectByIndex(WebElement element,int indexnumber)
	{
		Select select=new Select(element);
		select.selectByIndex(indexnumber);
	}
	public void selectAValueUsingSelectByValue(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByValue(text);
	}
public void AcceptNormalOrConfirmationAlert(WebDriver driver) {	
	driver.switchTo().alert().accept();
	}
public void dismissConfirmationAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();	
}
	
public void AcceptPromptingAlert(WebDriver driver,String inputvalue) {
	Alert myalert=driver.switchTo().alert();
	myalert.sendKeys(inputvalue);	
}
public void RejectPromptingAlert(WebDriver driver,String inputvalue) {
	Alert myalert=driver.switchTo().alert();
	myalert.sendKeys(inputvalue);	
}

public void forceClickUsingJavaScriptExecutor(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
	
}
public void ScrollDownUsingJavaScriptExecutorTillElementIsVisible(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);",element);	
}
public void ScrollHorizontallyToLeftUsingJavaScriptExecutor(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollLeft=arguments[0].scrollWidth;",element);	
}
public void switchDriverBetweenBrowserWindows(WebDriver driver,String windowid)
{
	driver.switchTo().window(windowid);
}

public void switchDriverBetweenFrameUsingWebeldment(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
public void switchDriverToDefaultContent(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
public void mouseHoverActionOnaSingleWebElemnt(WebDriver driver,WebElement hoverelement)
{
	Actions actions=new Actions(driver);
	actions.moveToElement(hoverelement).build().perform();
	
}
public void mouseHoverActionOnWebElemntWhileHoveringTheMainWebElement(WebDriver driver,WebElement hoverelement1,WebElement hoverelement2)
{
	Actions actions=new Actions(driver);
	actions.moveToElement(hoverelement1).moveToElement(hoverelement2).build().perform();
	
}
public void mouseActionRightClickOnWebElement(WebDriver driver,WebElement element)
{
	Actions actions=new Actions(driver);
	actions.contextClick(element).build().perform();
}

public void mouseDragAndDrop(WebDriver driver,WebElement sourcewebelement,WebElement destinationwebelement)
{
	Actions actions=new Actions(driver);
	actions.dragAndDrop(sourcewebelement, destinationwebelement).build().perform();
}




}

package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUtility {

	public void fileUpload(WebElement filefield,String filepath)
	{
		filefield.sendKeys(filepath);
	}
	
	
	public void robotFileUpload(String filepath,WebElement element,WebDriver driver) throws AWTException, InterruptedException
	{
		
		WebElement choosefile=element;
		choosefile.click();
		
	try {
		// Create Robot instance
		Robot robot = new Robot();

		// Delay to ensure the dialog is fully loaded
		robot.delay(250);

		

	

		// Type the file path 
		StringSelection filePath = new StringSelection(filepath);
		//copy path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		Thread.sleep(1500);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
		// Paste the file path into the dialog (Cmd + V on macOS)
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);

		robot.delay(250);

		// Press Enter to confirm the file upload
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		
	
}
}
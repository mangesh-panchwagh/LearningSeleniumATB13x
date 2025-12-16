package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CommonToAll{
	
	public WebDriver driver;
	
	public void openBrowser(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		driver.quit();
	}
	
	public WebElement findElementByPartialText(WebDriver driver, String text) {
		return driver.findElement(By.partialLinkText(text));
	}
	
	
}

package ex02_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class TestSelenium14_Close_VS_quit {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		// Write the code
		// Wait
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new RuntimeException(e);	
		}
		
		//driver.close();
		// close - will close the current tab, not the session (not all tabs)
		// session id != null
		
		 driver.quit();
		// It will close all the tabs- session id == null
	}
}

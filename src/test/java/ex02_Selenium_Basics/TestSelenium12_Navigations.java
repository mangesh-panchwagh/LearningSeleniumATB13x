package ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Description;

public class TestSelenium12_Navigations {

	@Description("Open the URL")
	@Test
	public void test_Selenium01() {
		
		WebDriver driver = new FirefoxDriver();
//		driver.get("url"); -> Navigate to URL
		
		driver.get("https://www.google.com/");
//		navigate().to()
		
		// Use navigation methods
		driver.navigate().to("https://www.bing.com/");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
		
		
	}
}

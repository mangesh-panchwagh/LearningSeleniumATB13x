package ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium05_WebDriver {

	public static void main(String[] args) {
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://app.vwo.com");
	}
}

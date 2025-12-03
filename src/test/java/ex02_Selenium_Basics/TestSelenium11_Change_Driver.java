package ex02_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class TestSelenium11_Change_Driver {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver = new FirefoxDriver();
	}
}

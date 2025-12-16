package ex031_Selenium_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLTI {
	
	@Test
	public void test() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		/*
		WebElement checkbox = driver.findElement(By.id(""));
		WebElement checkbox = driver.findElements(By.id(""));
		WebElement checkbox = driver.findElement(By.id(""));
		*/
	}
}

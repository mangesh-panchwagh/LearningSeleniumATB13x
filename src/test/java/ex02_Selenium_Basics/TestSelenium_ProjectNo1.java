package ex02_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium_ProjectNo1 {

	@Test
	public void test_verify_text_katalon() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
		System.out.println(driver.getPageSource());
		
		if(driver.getPageSource().contains("CURA Healthcare Service")) {
			System.out.println("Test case passed");
			Assert.assertTrue(true);
		}else {
			System.out.println("Test case failed");
			Assert.fail();
		}
		driver.quit();
	}
}

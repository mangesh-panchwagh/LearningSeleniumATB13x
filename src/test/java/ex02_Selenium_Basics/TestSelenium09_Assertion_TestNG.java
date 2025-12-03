package ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium09_Assertion_TestNG {

	@Description("Verify that the title is visible. ")
	@Test
	public void test_selenium_assertion() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		// Test NG Assertions
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
		
		// AssertJ
		assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");
		
		// Rest Assured? (ValidatableResponse)
		
		driver.quit();
	}
}

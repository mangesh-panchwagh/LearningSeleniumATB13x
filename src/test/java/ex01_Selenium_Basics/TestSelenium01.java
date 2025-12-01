package ex01_Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium01 {

	@Test
	public void test_code() {
		
		Assert.assertEquals("Mangesh", "Mangesh");
	}
	
	@Test
    public void test_OpenTheTestingAcademy(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://thetestingacademy.com");
    }
}

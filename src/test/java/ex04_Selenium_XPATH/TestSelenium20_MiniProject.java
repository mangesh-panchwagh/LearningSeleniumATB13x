package ex04_Selenium_XPATH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.CommonToAll;

public class TestSelenium20_MiniProject extends CommonToAll{

	@Owner("Mangesh")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify login is working")
	@Test
	public void test_OHRM_login() {
		
		//```
        ////input[@name="username"]
        ////input[@placeholder="Username"]
        //```
        //```
        ////input[@placeholder="Password"]
        //```
        //
        //
        //```
        ////button[normalize-space()="Login"]
        //``
		
		WebElement input_username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()=\"Login\"]"));
        
        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4312");
        button.click();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
}

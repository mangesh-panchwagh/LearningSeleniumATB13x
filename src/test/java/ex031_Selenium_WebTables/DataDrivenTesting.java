package ex031_Selenium_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import utils.UtilExcel;

public class DataDrivenTesting {
	
	@DataProvider
	public Object[][] getData(){
		// READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
		return UtilExcel.getTestDataFromExcel("sheet1");
	}
	
	@Test(dataProvider = "getData")
	public void loginDataDriver(String email, String password) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.vwo.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-password")).sendKeys(password);
		driver.findElement(By.id("js-login-btn")).click();
		String error_message = driver.findElement(By.id("js-notification-box-msg")).getText();
		
		assertThat(error_message).isNotNull().isNotBlank().isNotEmpty();
		Assert.assertEquals(error_message, "Your email, password, IP address or location did not match");
		
		
	}
	
}

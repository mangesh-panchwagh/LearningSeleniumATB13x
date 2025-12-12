package ex031_Selenium_WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test_web_table_OrangeHRM {

	@Test
	public void orangeHTMTble() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
			WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
			
			
			username.sendKeys("Admin");
			password.sendKeys("admin123");
			loginBtn.click();
			Thread.sleep(2000);
			
			WebElement table = driver.findElement(By.xpath("//ul[@class='oxd-main-menu']"));
			
			List<WebElement> rows_table = table.findElements(By.tagName("li"));
			WebElement PIM = driver.findElement(By.xpath("//a[contains(text(),'PIM')]"));
			for(int i=0;i<rows_table.size(); i++) {
				
				List<WebElement> col2 = rows_table.get(i).findElements(By.tagName("a"));
				
				for(WebElement c : col2) {
					System.out.println(c.getText());
					
				}
				
				
			}
			
			

		
	}
}

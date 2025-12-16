package ex031_Selenium_WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class test_web_table_OrangeHRM_Practice {

	@Test
	public void printTableData() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginBtn.click();
		Thread.sleep(2000);
		
		WebElement PIMBtn = driver.findElement(By.xpath("//span[text()='PIM']"));
		wait.until(ExpectedConditions.elementToBeClickable(PIMBtn));
		PIMBtn.click();
		
		// Wait for table to open
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-table-body']")));
		
		
		
		
		// Print table header
		List<WebElement> headers = driver.findElements(By.xpath("//div[@class='oxd-table-header']//div[@role='columnheader']"));
		for(WebElement header : headers) {
			System.out.print(header.getText() + " | ");
		}
		
		// Print table data
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']")); 
		int count = 0;
		for(WebElement row : rows) {
			
			List<WebElement> cols = row.findElements(By.xpath(".//div[@role='cell']"));
			
			for(WebElement col : cols) {
				System.out.print(col.getText() + " | ");
			}
			System.out.println();count++;
		}
		System.out.println("Count of rows : " + count);
		
		// Print only id, first name and last name
		/*
		for (WebElement row : rows) {

		    // Get all cells of a row
		    List<WebElement> cols = row.findElements(By.xpath(".//div[@role='cell']"));

		    for(WebElement col : cols) {
				System.out.print(col.getText() + " | ");
			}
		    
		    String id = cols.get(1).getText();        // Id
		    String firstName = cols.get(2).getText(); // First Name
		    String lastName = cols.get(3).getText();  // Last Name

		    System.out.println(id + " | " + firstName + " | " + lastName);
		}
		*/
	}
}

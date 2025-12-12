package ex03_Selenium_Locators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
Write a script in selenium with Java
1. Launch the url https://www.w3schools.com/tags/att_input_type_checkbox.asp
2. Click Try it yourself, once you click on “Try it yourself”, you will be taken to new tab
3. On the new tab, you will see 3 check boxes, select last two checkboxes
4. Click on submit
5. Assert the message which you get after clicking on Submit button
*/
public class TestProject {

	@Test
	public void openURL() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/att_input_type_checkbox.asp");
		driver.manage().window().maximize();
		
		WebElement tryItButton = driver.findElement(By.xpath("//a[contains(text(),'Try it Yourself »')]"));
		tryItButton.click();
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window : " + parentWindowHandle);
		System.out.println("Switched to : " + driver.getTitle());
		
		Set<String> AllWindowHandles = driver.getWindowHandles();
		
		List<String> allTabString = new ArrayList<>(AllWindowHandles);
		/*
		String tab2 = allTabString.get(1);
		driver.switchTo().window(tab2);
		System.out.println("Swithced to : " + driver.getTitle());
		
		System.out.println("Switched to new tab: " + driver.getTitle());
		
		 driver.switchTo().frame("iframeResult");
		String heading = driver.findElement(By.xpath("//h1[contains(text(),'Show Checkboxes')]")).getText();
		System.out.println("Heading : " + heading);
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='vehicle2']"));
		WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='vehicle3']"));
		
		checkBox2.click();
		checkBox3.click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualText = "Submitted Form Data";
		String expectedText = driver.findElement(By.xpath("//h1[contains(text(),'Submitted Form Data')]")).getText();
		Assert.assertEquals(actualText, expectedText);
		*/
		
		
		for(String handle : AllWindowHandles) {
			
			System.out.println("Switched to : " + driver.getTitle());
			if(!handle.equals(parentWindowHandle)) {
				
				String tab2 = allTabString.get(1);
				driver.switchTo().window(tab2);
				System.out.println("Swithced to : " + driver.getTitle());
				
				System.out.println("Switched to new tab: " + driver.getTitle());
				
				 driver.switchTo().frame("iframeResult");
				String heading = driver.findElement(By.xpath("//h1[contains(text(),'Show Checkboxes')]")).getText();
				System.out.println("Heading : " + heading);
				WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='vehicle2']"));
				WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='vehicle3']"));
				
				checkBox2.click();
				checkBox3.click();
				
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				Thread.sleep(2000);
				String actualText = "Submitted Form Data";
				String expectedText = driver.findElement(By.xpath("//h1[contains(text(),'Submitted Form Data')]")).getText();
				Assert.assertEquals(actualText, expectedText);
			}
	
			
		}
		
		
		
		
		
		
	}
}

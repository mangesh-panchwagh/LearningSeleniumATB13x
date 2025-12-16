package ex031_Selenium_WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class browserstackDemo {

	@Test
	public void dropdownDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bstackdemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//select")).click();
		
		List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
		
		String option="Highest to lowest";
		
		for(int i =0 ; i< allOptions.size(); i++) {
			if(allOptions.get(i).getText().contains(option)) {
				allOptions.get(i).click();
				System.out.println("Clicked");
				break;
			}
		}
	}
}

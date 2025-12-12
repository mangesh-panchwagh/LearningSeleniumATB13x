package ex031_Selenium_WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dropdown {

	@Test
	public void selectDropDownWIthoutSelect() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		// Switch to the iframe first
	    //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'select-dropdown-menu')]")));
	    
		//driver.switchTo().frame(0);

		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'select-dropdown-menu')]")));
		WebElement countryDropDown = driver.findElement(By.tagName("select"));
		countryDropDown.click();
		
		List<WebElement> countries = driver.findElements(By.tagName("options"));
		/*
		for(WebElement c : countries) {
			System.out.println(c.getText());
			
			if(c.getText().equalsIgnoreCase("India")) {
				c.click();
				break;
				
		}
		*/
		
		for (WebElement option : countries) {
	        if (option.getText().equalsIgnoreCase("India")) {
	            option.click();
	            break;
	        }
	    }
//		for(WebElement country : countries) {
//			if(country.getText().equalsIgnoreCase("India")) {
//				country.click();
//				break;
//			}
//		}
		
	}
}


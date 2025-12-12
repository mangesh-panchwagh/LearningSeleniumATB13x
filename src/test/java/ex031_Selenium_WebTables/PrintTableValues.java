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

public class PrintTableValues {

	@Test
	public void printNameValues() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/108793/aus-vs-eng-2nd-test-the-ashes-2025-26");
		driver.manage().window().maximize();
		
		// xpath -
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         // Wait until at least one batting table is visible
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'text-xs')]")));

         List<WebElement> batterRows = driver.findElements(
        	        By.cssSelector("div.scorecard-bat-grid > div.flex.flex-col")
        	);

        	for (WebElement row : batterRows) {

        	    // Extract batter name
        	    String name = "";
        	    try {
        	        name = row.findElement(By.cssSelector("a.text-cbTextLink")).getText().trim();
        	    } catch (Exception e) {
        	        continue; // skip rows without a batter name
        	    }

        	    if (name.isEmpty()) continue;

        	    // Extract Strike Rate (SR)
        	    
        	    String sr = "";
        	    try {
        	        // SR is the 7th numeric column in the flex row
        	        sr = row.findElements(By.cssSelector("div.flex.justify-center")).get(6).getText().trim();
        	    } catch (Exception ignored) {}
				
        	    
        	  //  WebElement srValue = row.findElement(By.xpath("//div[contains(@class,'justify-center')][last()]"));
        	   // String strikeRate = srValue.getText().trim();
        	    System.out.println("Batter: " + name + "   SR: " + sr);
        	    
        	}
             
         
	}
}

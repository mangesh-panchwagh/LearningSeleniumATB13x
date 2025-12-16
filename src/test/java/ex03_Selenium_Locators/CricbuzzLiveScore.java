package ex03_Selenium_Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricbuzzLiveScore {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/117416/ind-vs-rsa-2nd-t20i-south-africa-tour-of-india-2025");

        // Wait for table to load
        Thread.sleep(5000);

        // Locate the batting scorecard blocks
        List<WebElement> battingSections = driver.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-ltst-wgt-hdr"));

        for (WebElement section : battingSections) {

            // Get all rows of batsmen
            List<WebElement> rows = section.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms"));

            for (WebElement row : rows) {
                
                // Get the batter name
                WebElement batter = null;
                try {
                    batter = row.findElement(By.cssSelector("div:nth-child(1)"));
                } catch (Exception e) {
                    continue;
                }

                String batterName = batter.getText();

                // If it's not a batter row, skip
                if (batterName.equals("") || batterName.contains("Extras") || batterName.contains("Total")) {
                    continue;
                }

                // Get SR value (strike rate is 7th child)
                String strikeRate = row.findElement(By.cssSelector("div:nth-child(7)")).getText();

                System.out.println("Batter: " + batterName + " | SR: " + strikeRate);
            }
        }

        driver.quit();
	}
}

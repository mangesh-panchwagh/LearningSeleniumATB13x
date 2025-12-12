package ex031_Selenium_WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w3schooltablePrint {

	static WebDriver driver;

	public static void main(String[] args) {

		//WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		getRowColNumber("Germany");
	}

	public static void getRowColNumber(String name) {

		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

		

		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j <= colCount; j++) {

				String actValue = driver
						.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				System.out.println(actValue);
				if (actValue.equals(name)) {
					System.out.println(i + " : " + j);
					break;
				}
			}
		}
	}
}

package ex031_Selenium_WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_web_table_dynamic {

	@Test
	public void dynamicTable() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://awesomeqa.com/webtable1.html");
		driver.manage().window().maximize();
		
		
		// xpath - //table[@summary='Sample Table']/tbody/tr[2]/td[1]
		
		String firstPart = "//table[@summary='Sample Table']/tbody/tr[";
		String secondPart = "]/td[";
		String thirdPart = "]";
		
		int row = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr")).size();
		int col = driver.findElements(By.xpath("//table[@summary='Sample Table']/thead/tr/th")).size();
		// First Way
		/*
		for(int i=2; i<=row;i++) {
			for(int j = 1;j<=col-1;j++) {
				String dynamicPath = firstPart + i + secondPart + j + thirdPart;
				//System.out.println(dynamicPath);
				String data = driver.findElement(By.xpath(dynamicPath)).getText();
				System.out.print(data + " ");
			}
			System.out.println();
		}
		*/
		// Second Way 
		
		WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
		
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		for(int i=0;i<rows_table.size(); i++) {
			
			List<WebElement> col2 = rows_table.get(i).findElements(By.tagName("td"));
			
			for(WebElement c : col2) {
				System.out.println(c.getText());
			}
		}
	}
}

package ex031_Selenium_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test_web_table_login {

	@Test
	public void asb() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://awesomeqa.com/webtable.html");
		driver.manage().window().maximize();
		
		// xpath
		// //table[@id='customers']/tbody/tr[5]/td[2]
		
		// //table[@id='customers']/tbody/tr[i]/td[j]
		
		// xpath - //table[@id='customers']/tbody/tr[
		// i
		// ]/td[
		// j
		// ]
		
		String firstPart = "//table[@id='customers']/tbody/tr[";
		String secondPart = "]/td[";
		String thirdPart = "]";
		
		int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		
		System.out.println("row : " + row);
		System.out.println("column : " + col);
		
		for(int i = 2; i<=row;i++) {
			for(int j = 1; j<=col;j++) {
				String dynamicPath = firstPart + i + secondPart + j + thirdPart;
				System.out.println(driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).get(j).getText());
				//System.out.println(dynamicPath);
				
				String data = driver.findElement(By.xpath(dynamicPath)).getText();
				//System.out.print(data + " ");
				if(data.contains("Helen Bennett")) {
					String countryPath = dynamicPath + "/following-sibling::td";
					String countryText = driver.findElement(By.xpath(countryPath)).getText();
					System.out.println("-------------");
					System.out.println("Helen Bennett Is in : " + countryText);
				}
			}
			System.out.println();
		}
		
	}
	
}

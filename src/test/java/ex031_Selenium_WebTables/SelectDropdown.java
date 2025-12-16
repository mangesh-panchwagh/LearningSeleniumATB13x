package ex031_Selenium_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropdown {

	@Test
	public void drodown() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("iframeResult");

		WebElement w = driver.findElement(By.xpath("//select[@id='cars']"));
		w.click();
		Select select = new Select(w);

		select.selectByVisibleText("Audi");

	}

	@Test
	public void drodown2() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement courseName = driver.findElement(By.id("course"));
		Select select = new Select(courseName);
		
		// Select by index
		select.selectByIndex(1);
		Thread.sleep(2000);
		System.out.println(select.getFirstSelectedOption().getText());
		
		// Select by value
		select.selectByValue("net");
		Thread.sleep(2000);
		System.out.println(select.getFirstSelectedOption().getText());

		// Select by visible text
		select.selectByVisibleText("Python");
		Thread.sleep(2000);
		System.out.println(select.getFirstSelectedOption().getText());
		
		select.selectByValue("js");
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
	}
	
	
}

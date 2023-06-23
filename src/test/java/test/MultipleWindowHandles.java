package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandles {
	WebDriver driver;
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void handleMultipleWindows() {
		WebElement blinkingLink = driver.findElement(By.className("blinkingText"));
		blinkingLink.click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentId = it.next();
		String childId =  it.next();
		driver.switchTo().window(childId);
		String email = driver.findElement(By.xpath("//strong/a")).getText();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		
	}
}

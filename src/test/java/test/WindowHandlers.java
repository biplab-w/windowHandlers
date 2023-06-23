package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlers {

	WebDriver driver;
	String URL = "https://www.amazon.com";
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		Dimension winDim = driver.manage().window().getSize();
		System.out.println(winDim.height);
		System.out.println(winDim.width);
		driver.get(URL);

		driver.manage().window().maximize();
	}

	@Test
	public void windowHandlers() {
//		nav-link-accountList
		
		Actions ac = new Actions(driver);
		//moves to specific element
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		//
		WebElement searchBar = driver.findElement(By.id("nav-search-bar-form"));
		ac.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("ToothBrush").sendKeys(Keys.RETURN).build().perform();
	}
}

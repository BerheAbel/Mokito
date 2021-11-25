package A;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyBoard {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}
//	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo@techfios.com");
//	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
//	driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
	
	@Test
	public void KeyBoard() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.CONTROL).build().perform();
		action.sendKeys(Keys.ALT).build().perform();
		action.sendKeys(Keys.DELETE).build().perform();
	}
}

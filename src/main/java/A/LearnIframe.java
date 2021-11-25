package A;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIframe {
	WebDriver driver;
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
	}
	@Test
	public void Learnpopup() throws InterruptedException {
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(3000);
		driver.findElement(By.linkText("java.awt")).click();;
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Adjustable")).click();;
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		WebElement BODYOFTHEPAGE = driver.findElement(By.xpath("//h2[contains(text(),'Interface Adjustable')]"));
		Assert.assertEquals("page not found","Interface Adjustable" ,BODYOFTHEPAGE.getText() );
	
	}

}

package A;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {
	WebDriver driver;
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yahoo.com/");
	}
	
	@Test
	public void learnWindow() throws InterruptedException {
//		System.out.println(driver.getTitle());
		String handle1 = driver.getWindowHandle();
//		System.out.println(handle1);
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.partialLinkText("selenium")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		Set<String> handles = driver.getWindowHandles();
		for(String i : handles) {
			System.out.println(i);
			driver.switchTo().window(i);
		}
		//this is to work with popup message
//		WebElement ALERTPOPUP = driver.findElement(By.xpath("//button[@id='prefix-dismissButton']"));
		Thread.sleep(3000);
//		ALERTPOPUP.click();
		
	
	//	driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
		//if we want to navigate back
		driver.switchTo().window(handle1);
	//	String handle = driver.getWindowHandle();
		//driver.switchTo().window("https://www.selenium.dev/")driver.switchTo();
		//driver.findElement(By.linkText("www.selenium.dev")).click();
		
	}
}

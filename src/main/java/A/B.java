package A;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class B {
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
	@Test
	public void launchBrowser() {
		//storing element using webelement
	WebElement USERNAME_ELEMENT  = 	driver.findElement(By.xpath("//*[@id=\"username\"]"));
	WebElement PASSWORD_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"password\"]"));
	WebElement LOGIN_ELEMENT  =  driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
	
	
		//storing element using class
	By USERNAME_FILD = By.xpath("//*[@id=\"username\"]");
	By PASSWORD_FILD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_FILD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	//PERFORM LOGIN
	USERNAME_ELEMENT.clear();
	USERNAME_ELEMENT.sendKeys("demo@techfios.com");
	PASSWORD_ELEMENT.sendKeys("abc123");
	LOGIN_ELEMENT.click();
//	WebElement BANK_CASH_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/a/span[1]"));
//	BANK_CASH_ELEMENT.click();
//	WebElement NEW_ACCOUNT_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a"));
//	NEW_ACCOUNT_ELEMENT.click();
//	WebElement ACCOUNT_TITLE_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"account\"]"));
//	ACCOUNT_TITLE_ELEMENT.sendKeys("ABELHBERHE");
//	WebElement DISCRIPTION_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"description\"]"));
//	DISCRIPTION_ELEMENT.sendKeys("REGISTRATION");
//	WebElement INITIAL_BALANCE_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"balance\"]"));
//	INITIAL_BALANCE_ELEMENT.sendKeys("300");
//	WebElement ACCOUNT_NUMBER_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"account_number\"]"));
//	ACCOUNT_NUMBER_ELEMENT.sendKeys("52839756510");
//	WebElement CONTACT_PERSON_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"contact_person\"]"));
//	CONTACT_PERSON_ELEMENT.sendKeys("RAHEL");
//	WebElement PHONE_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"contact_phone\"]"));
//	PHONE_ELEMENT.sendKeys("415881942");
//	WebElement SUBMIT_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button"));
//	SUBMIT_ELEMENT.click();
	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
	WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='cid']"));
	Select sel = new Select(dropdownElement);
	//sel.selectByVisibleText("Techfios");
	
	
	
	
	
	
	//Assert.assertTrue("Wrong site!!!",WebElement DASHBOARD_ELEMENT.isDisplayed());
	//WebElement DASHBOARD_ELEMENT  =  driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
	//Assert.assertTrue(DASHBOARD_ELEMENT.isDisplayed());
	
	
	
	
	
	}
}

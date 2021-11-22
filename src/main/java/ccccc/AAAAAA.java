package ccccc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AAAAAA {
	WebDriver driver;
	String browser;
	
	By UserName = By.xpath("//*[@id=\"username\"]");
	By PassWord = By.xpath("//*[@id=\"password\"]");
	By Login = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By Customer = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By AddCustomer = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By DashBoard = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	
	String USERNAME = "demo@techfios.com";
	String PASSWORD = "abc123";
	@BeforeClass
	public void resdConfig() {
		
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser type: "+ browser);
			
		}
		catch(IOException e) {e.printStackTrace();
			
		}
	}
	@BeforeMethod
	public void test() {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techfios.com/billing/?ng=admin/");

	}
	String DASHBOARDFILD = driver.findElement(DashBoard).getText();
	@Test (priority = 1)
	public void First_Login_Test() {
		driver.findElement(UserName).sendKeys(USERNAME);
		driver.findElement(PassWord).sendKeys(PASSWORD);
		driver.findElement(Login).click();
		Assert.assertEquals(DASHBOARDFILD, "Dashboard", "Page not found");
	}
	@Test (priority = 2)
	public void AddInfo() {
		driver.findElement(UserName).sendKeys(USERNAME);
		driver.findElement(PassWord).sendKeys(PASSWORD);
		driver.findElement(Login).click();
		driver.findElement(Customer).click();
		driver.findElement(AddCustomer).click();
		
		By FullName = By.xpath("//input[@id = 'account']");
		By CompanyFild = By.xpath("//*[@id=\"cid\"]");
		By Email = By.xpath("//*[@id=\"email\"]");
		By Phone = By.xpath("//*[@id=\"phone\"]");
		By Address = By.xpath("//*[@id=\"address\"]");
		By City = By.xpath("//*[@id=\"city\"]");
		By Rigon = By.xpath("//*[@id=\"state\"]");
		By ZipCode = By.xpath("//*[@id=\"zip\"]");
		By country = By.id("country");
		By Save = By.xpath("//*[@id=\"submit\"]");
		
		String FULLNAME = "NANA COME";
		String COMPANY = "Techfios";
		String EMAIL = "TESL@GMAIL.COM";
		String PHONE = "4159109999";
		String ADDRESS = "415 FULTON ST";
		String CITY = "SAN FRANCISCO";
		String RIGION = "BAY AREA";
		String ZIPCODE = "94991";
		String COUNTRY = "United States";
		
		driver.findElement(FullName).sendKeys(FULLNAME);
		Select sel = new Select(driver.findElement(CompanyFild));
		sel.selectByVisibleText(COMPANY);
		driver.findElement(Email).sendKeys(EMAIL);
		driver.findElement(Phone).sendKeys(PHONE);
		driver.findElement(Address).sendKeys(ADDRESS);
		driver.findElement(City).sendKeys(CITY);
		driver.findElement(Rigon).sendKeys(RIGION);
		driver.findElement(ZipCode).sendKeys(ZIPCODE);
		Select sel1 = new Select(driver.findElement(country));
		sel1.selectByVisibleText(COUNTRY);
		//driver.findElement(Save).click();
	}
		@Test(priority = 3)
	public void CustomerList() {
		By List = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a");
		driver.findElement(UserName).sendKeys(USERNAME);
		driver.findElement(PassWord).sendKeys(PASSWORD);
		driver.findElement(Login).click();
		driver.findElement(Customer).click();
		driver.findElement(List).click();
	}
	@AfterClass
	public void TearDown() {
		driver.close();
		//driver.quit();
	}
	
}

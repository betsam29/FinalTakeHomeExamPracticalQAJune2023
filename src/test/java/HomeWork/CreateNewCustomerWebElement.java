package HomeWork;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewCustomerWebElement {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Logintest() {

		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LOGINSUBMIT_ELEMENT = driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
		USERNAME_ELEMENT.sendKeys("demo@codefios.com ");
		PASSWORD_ELEMENT.sendKeys("abc123");
		LOGINSUBMIT_ELEMENT.click();
		
		WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a"));
		Assert.assertTrue("Daschborard page not found!!", DASHBOARD_HEADER_ELEMENT.isDisplayed());
		WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[1]/a/em"));
		WebElement CUSTOMERS_ELEMENT = driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a"));
		WebElement ADD_CUSTOMER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"customers\"]/li[2]/a/em"));
		CUSTOMERS_ELEMENT.click();
		ADD_CUSTOMER_ELEMENT.click();

	}

	@Test
	public void addCustomer() {
		Logintest();
		WebElement NEW_CUSTOMER_ELEMENT = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div"));
		Assert.assertTrue("Daschborard page not found!!", NEW_CUSTOMER_ELEMENT.isDisplayed());
		WebElement FULL_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input"));
		WebElement COMPANY_ELEMENT = driver.findElement(By.xpath("//select[@name='company_name']"));
		FULL_NAME_ELEMENT.sendKeys("Betty S");
		Select sel = new Select(COMPANY_ELEMENT);
		sel.selectByVisibleText("Techfios");
		COMPANY_ELEMENT.sendKeys("Techfios");
	}
	
	// @After
		public void tearDown() {
			driver.close();
			driver.quit();
		}
}

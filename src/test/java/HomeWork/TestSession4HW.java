package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSession4HW {
	WebDriver driver;

	By USERNAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGINSUBMIT_FIELDT = By.xpath("//*[@id=\"login_submit\"]");
	By DASHBOARD_HEADER_FIELDT = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");
	By DASHBOARD_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[1]/a/em");
	By CUSTOMERS_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a");
	By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/em");
	By FULL_NAME_FIELD = By.xpath("//input[@name='name']");
	By COMPANY_FIELD = By.xpath("//select[@name='company_name']");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// @Test
	public void LoginTest() {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGINSUBMIT_FIELDT).click();
		Assert.assertTrue("Daschborard page not found!!", driver.findElement(DASHBOARD_HEADER_FIELDT).isDisplayed());
	}

	@Test
	public void newCustomer() {
		LoginTest();
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		Assert.assertTrue("Daschborard page not found!!", driver.findElement(ADD_CUSTOMER_FIELD).isDisplayed());
		driver.findElement(FULL_NAME_FIELD).sendKeys("Betty S");

		Select sel = new Select(driver.findElement(COMPANY_FIELD));
		List<WebElement> we = sel.getOptions();
		for (int i = 0; i < we.size(); i++) {
			System.out.println(we.get(i).getText());
		}
		System.out.println("==================================================================");
		for (WebElement a : we) {
			if (a.getText().equals("rimo")) {
				a.click();

				// break;
			}

		}
		System.out.println("Wrong value");

	}

}

package HomeWork;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewCustomerBy {

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
	By EMAIL_FIELD = By.xpath("//input[@name='email']");
	By PHONE_FIELD = By.xpath("//*[@id=\"phone\"]");
	By ADDRESS_FIELD = By.xpath("//input[@name='address']");
	By CITY_FIELD = By.xpath("//input[@name='city']");
	By ZIP_CODE_FIELD = By.xpath("//input[@id='port']");
	By COUNTRY_FIELD = By.xpath("//select[@name='country']");
	By GROUP_FIELD = By.xpath("//select[@id='customer_group']");
	By SAVE_FIELD = By.xpath("//button[@id='save_btn']");
	
	String companyName = "Techfios";
	String countryName = "United States of America";
	String group = "Java";

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
	public void newCustomer() throws InterruptedException {
		LoginTest();
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		Assert.assertTrue("Daschborard page not found!!", driver.findElement(ADD_CUSTOMER_FIELD).isDisplayed());
		driver.findElement(FULL_NAME_FIELD).sendKeys("Selenium");
		selectFormDropdown(driver.findElement(COMPANY_FIELD), companyName);
		driver.findElement(EMAIL_FIELD).sendKeys(generateRandomNo(999) + "bettty01214@gmail.com");
		driver.findElement(PHONE_FIELD).sendKeys("9723490" + generateRandomNo(999));
		driver.findElement(ADDRESS_FIELD).sendKeys("540 Buckingham Rd 1321, Richardson, TX 75081");
		driver.findElement(CITY_FIELD).sendKeys("Dallas");
		driver.findElement(ZIP_CODE_FIELD).sendKeys("75081");
		selectFormDropdown(driver.findElement(COUNTRY_FIELD), countryName);
		selectFormDropdown(driver.findElement(GROUP_FIELD), group);
		driver.findElement(SAVE_FIELD).click();

	}

	private void selectFormDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}
	
	
	private int generateRandomNo(int boundaryNo) {

		Random rmd = new Random();
		int generatedNo = rmd.nextInt(boundaryNo);
		return generatedNo;

	}

	// @After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}

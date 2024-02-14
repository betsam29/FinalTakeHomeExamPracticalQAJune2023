package HomeWork;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoHandle {
WebDriver driver;


By USERNAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
By LOGINSUBMIT_FIELDT = By.xpath("//*[@id=\"login_submit\"]");
By DASHBOARD_HEADER_FIELDT = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");



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
	public void LoginTest() {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGINSUBMIT_FIELDT).click();
		Assert.assertTrue("Daschborard page not found!!", driver.findElement(DASHBOARD_HEADER_FIELDT).isDisplayed());
		driver.switchTo().frame("advertisement");
		
		//driver.switchTo().window(handle);
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		for(String i : handles) {
			System.out.println(i);
			driver.switchTo().window(i);
		}
		
		String title = driver.getTitle();
		System.out.println(title);
	}
}

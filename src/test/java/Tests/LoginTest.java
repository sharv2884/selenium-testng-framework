package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class LoginTest extends BaseClass {
	public WebDriver driver;

	/*
	 * @BeforeMethod public void setup() { driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * driver.get(
	 * "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); }
	 */

	@Test
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("Admin");
		lp.enterPassword("admin123");
		lp.clickLogin();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

	}

	/*
	 * @AfterMethod public void close() { driver.quit(); }
	 */

}

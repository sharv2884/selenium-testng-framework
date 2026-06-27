package Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DataProviderTest {
	WebDriver driver;

	@Parameters("url")
	@BeforeMethod
	public void setup(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		return new Object[][] { { "Admin", "admin123" }, { "Admin", "password" }, { "user", "passwd" } };

	}

	@Test(dataProvider = "loginData")
	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		SoftAssert soft = new SoftAssert();

		boolean isPassed=false;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(username);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		WebElement passwd = driver.findElement(By.name("password"));
		passwd.sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

		System.out.println("Tested with: " + username + " / " + password);
		if (driver.getCurrentUrl().contains("dashboard")) {
	        isPassed = true;
	        System.out.println("Result: PASS");
	    } else {
	        System.out.println("Result: FAIL");
	    }

	    soft.assertTrue(isPassed);
		soft.assertAll();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}

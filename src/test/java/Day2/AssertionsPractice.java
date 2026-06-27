package Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

	}

	@Test(priority = 2)
	public void hardAssert() {
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 1)
	public void softAssert() {
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "OrangeHRM");
		System.out.println(driver.getTitle());
		soft.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println(driver.getCurrentUrl());
		soft.assertAll();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}

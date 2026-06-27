package Tests;

import org.apache.logging.log4j.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import DriverManager.DriverManager;
import Pages.LoginPage;
import Utilities.DataProviderClass;

public class LoginTestClass extends BaseTest {

	private static final Logger log = LogManager.getLogger(LoginTestClass.class);

	@Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void login(String username, String password) {
		log.info("Starting login test with username: " + username);
		LoginPage lp = new LoginPage(DriverManager.getDriver());
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLogin();
		log.info("Current URL: " + DriverManager.getDriver().getCurrentUrl());

		Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("dashboard"));

	}

	@Test
	public void titleCheck(String username, String password) {
		log.info("Starting login page titel verification test");

		LoginPage lp = new LoginPage(DriverManager.getDriver());
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLogin();

		String actualTitle = DriverManager.getDriver().getTitle();
		log.info("Page Title: " + actualTitle);

		Assert.assertEquals(actualTitle, "OrangeHRM", "Title is not matching");

		log.info("Title verification test passed");
	}
}

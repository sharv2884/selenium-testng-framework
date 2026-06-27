package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtil;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement login;

	public void enterUsername(String user) {
		WaitUtil.waitForElementVisibility(driver, username);
		username.sendKeys(user);
	}

	public void enterPassword(String pass) {
		WaitUtil.waitForElementVisibility(driver, password);
		password.sendKeys(pass);
	}

	public void clickLogin() {
		WaitUtil.waitForClickability(driver, login);
		login.click();
	}
}

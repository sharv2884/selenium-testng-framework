package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Config.ConfigReader;

public class DriverManager {

	// ThreadLocal for parallel execution
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Initialize driver based on config
	public static void initDriver() {

		// Read browser name from config file
		String browser = ConfigReader.getProperty("browser");

		// Declare WebDriver
		WebDriver wd = null;

		// Check which browser to launch
		if (browser.equalsIgnoreCase("chrome")) {

			// Launch Chrome browser
			wd = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			// Launch Edge browser
			wd = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			// Launch Firefox browser
			wd = new FirefoxDriver();

		} else {
			// Throw error if browser not supported
			throw new RuntimeException("Browser not supported: " + browser);
		}

		// Assign driver to current thread
		driver.set(wd);
	}

	// Get driver
	public static WebDriver getDriver() {
		return driver.get();
	}

	// Quit driver
	public static void quitDriver() {

		if (driver.get() != null) {

			driver.get().quit();

			driver.remove();
		}
	}
}

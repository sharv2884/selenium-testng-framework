package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Config.ConfigReader;

public class BaseClass {
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--window-size=1920,1080");
		
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("base.url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser not supported: " + browser);
		}

		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}

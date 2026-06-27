package Base;

import DriverManager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Config.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        // Initialize driver based on config
        DriverManager.initDriver();
        
        // Open application URL
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url"));

        // Maximize browser
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        // Quit driver after test
        DriverManager.quitDriver();
    }
}

package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DriverManager.DriverManager;
import Utilities.ExtentManager;
import Utilities.ExtentTestManager;
import Utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();

	@Override
	public void onTestStart(ITestResult result) {

		// Create test entry in report
		ExtentTest test = extent.createTest(result.getName());

		// Store in ThreadLocal
		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// Mark test as pass
		ExtentTestManager.getTest().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			Thread.sleep(1000);

			String testName = result.getName();

			WebDriver driver = DriverManager.getDriver();

			if (driver != null) {
				String path = ScreenshotUtil.takeScreenshot(driver, testName);
				ExtentTestManager.getTest().fail(result.getThrowable());
				ExtentTestManager.getTest().addScreenCaptureFromPath(path);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		// Flush report (write to file)
		extent.flush();
	}
}
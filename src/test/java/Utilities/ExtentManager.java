package Utilities;

// Import Extent classes
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    // Create ExtentReports object
    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            // Create reporter with file path
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extentReport.html");

            // Initialize ExtentReports
            extent = new ExtentReports();

            // Attach reporter
            extent.attachReporter(reporter);
        }

        return extent;
    }
}

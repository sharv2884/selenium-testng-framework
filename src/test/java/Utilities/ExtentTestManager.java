package Utilities;

// Import ExtentTest
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    // ThreadLocal for parallel execution
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
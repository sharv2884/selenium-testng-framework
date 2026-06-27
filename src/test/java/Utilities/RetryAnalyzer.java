package Utilities;

//Import TestNG retry interface
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

 // Counter to track retry attempts
 private int count = 0;

 // Maximum retry limit
 private int maxRetry = 1;

 @Override
 public boolean retry(ITestResult result) {

     // Check if retry count is less than max limit
     if (count < maxRetry) {

         // Increment retry count
         count++;

         // Print retry attempt
         System.out.println("Retrying test: " + result.getName() + " Attempt: " + count);

         // Return true to retry test
         return true;
     }

     // Return false if retry limit reached
     return false;
 }
}
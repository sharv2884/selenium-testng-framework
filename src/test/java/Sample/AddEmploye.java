package Sample;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmploye {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        
        //Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']")); 
        login.click();
        
        
        //Click on PIM in the Dashboard
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/web/index.php/pim/viewPimModule')]")));
        WebElement PIMButton= driver.findElement(By.xpath("//a[contains(@href,'/web/index.php/pim/viewPimModule')]"));
        PIMButton.click();
        
        //Click on Add button 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']")));
        WebElement AddEmployee=driver.findElement(By.xpath("//button[text()=' Add ']"));
        AddEmployee.click();
        
        //Add Employee details
        String firstName = "TEST";
        String lastName = "USER";
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        WebElement firstNameInput= driver.findElement(By.name("firstName"));
        firstNameInput.sendKeys(firstName);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
        WebElement lastNameInput= driver.findElement(By.name("lastName"));
        lastNameInput.sendKeys(lastName);
        
        
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
        save.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(text(),'Personal Details')]")));
        WebElement nameHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")));
        System.out.println("Saved Employee Name: " + nameHeader.getText());
        
        	
        //Display Employee list to validate
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Employee List']")));
        WebElement EmpList= driver.findElement(By.xpath("//a[text()='Employee List']"));
        EmpList.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")));
        WebElement employeeSearch=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        employeeSearch.sendKeys(firstName);
        
        ////button[@type='submit']
        WebElement searchButton= driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
        
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='row']")));

        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));

        boolean found = false;

        for(WebElement row : rows){
            String rowText = row.getText();
            System.out.println("Searching for: " + firstName + " " + lastName);

            System.out.println("Row: " + rowText); // DEBUG

            if(rowText.contains(firstName) && rowText.contains(lastName)){
                found = true;
                break;
            }
        }

        if(found){
            System.out.println("Employee found ✅");
        }else{
            System.out.println("Employee NOT found ❌");
        }
     
        driver.quit();
	}

}
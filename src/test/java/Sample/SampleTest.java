package Sample;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //ChromeDriver is the class and WebDriver is the interface, driver is the variable where the object of ChromeDriver is stored
        driver.manage().window().maximize(); //maximize the window to fit the entire screen
       
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //open the url
        
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        //WebElement userName = driver.findElement(By.name("username"));
        //WebElement userName = driver.findElement(By.cssSelector("input[class='oxd-input oxd-input--active']")); //not working
        WebElement userName = driver.findElement(By.cssSelector("input[name='username']")); 

       
        //WebElement userName = driver.findElement(By.xpath("//input[@name='username']")); 
        //WebElement userName = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]")); //not working
        //WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']")); 
        //WebElement userName = driver.findElement(By.xpath("//input[contains (@name,'username')]")); 
        //WebElement userName = driver.findElement(By.xpath("//input[contains (@placeholder,'Username')]"));
        //WebElement userName = driver.findElement(By.xpath("(//input[contains (@class,'oxd-input oxd-input--active')])[1]"));  //not working

        userName.sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));


        //WebElement password = driver.findElement(By.name("password"));
        //WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        //WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']")); 

        password.sendKeys("admin123");
        
        
        //WebElement password_link= driver.findElement(By.linkText("Forgot your password?"));
        //WebElement password_link= driver.findElement(By.partialLinkText("Forgot "));

       // WebElement password_link = driver.findElement(By.xpath("//p[text()='Forgot your password?']"));
        //password_link.click();
        
        //https://www.linkedin.com/company/orangehrm/mycompany/
        //WebElement linkedin= driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
        //linkedin.click();

        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        //WebElement login = driver.findElement(By.tagName(button));
        //WebElement login = driver.findElement(By.xpath("//button[@type='submit']")); //if there is no id or name 
        //WebElement login = driver.findElement(By.className("orangehrm-login-button")); 
        //WebElement login = driver.findElement(By.xpath("//button[text()=' Login ']"));
        WebElement login = driver.findElement(By.cssSelector("input[type='submit']")); 


        login.click();
        
        
        System.out.println("Login successful page title: " + driver.getTitle());        
        String expectedTitle="OrangeHRM";
        if(expectedTitle.equals(driver.getTitle())) {
        	System.out.println("Title matched. Pass");
        }else {
        	System.out.println("Failed");
        }
        
        //String currentUrl = driver.getCurrentUrl(); //stores the url of the page (dashboard) that opens after login 
        //System.out.println("URL of the current page: " + currentUrl);
        
        driver.quit(); 
    }
}
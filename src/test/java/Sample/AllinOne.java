package Sample;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllinOne{

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // ================== ALERT HANDLING ==================
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        driver.findElement(By.id("alertBox")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmBox")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.id("promptBox")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Reshma");
        driver.switchTo().alert().accept();

        // ================== FRAME HANDLING ==================
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        driver.switchTo().frame("frm1");
        driver.findElement(By.id("course")).sendKeys("Selenium");
        driver.switchTo().defaultContent();

        // ================== DROPDOWN HANDLING ==================
        WebElement dropdown = driver.findElement(By.id("course"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Java");
        Thread.sleep(2000);

        // ================== WINDOW HANDLING ==================
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String parent = driver.getWindowHandle();

        driver.findElement(By.id("newWindowBtn")).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                driver.findElement(By.id("firstName")).sendKeys("Reshma");
                Thread.sleep(2000);
                driver.close();
            }
        }

        driver.switchTo().window(parent);

        Thread.sleep(3000);
        driver.quit();
    }
}
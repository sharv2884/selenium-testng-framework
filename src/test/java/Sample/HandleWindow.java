package Sample;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWindow {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String parent = driver.getWindowHandle();

        // click button
        driver.findElement(By.id("newWindowBtn")).click();

        // wait for new window
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);

                System.out.println("Child: " + driver.getTitle());

                driver.close();
            }
        }

        driver.switchTo().window(parent);
        
        System.out.println("Parent: " + driver.getTitle());

        driver.findElement(By.id("name")).sendKeys("Done");

        driver.quit();
    }
}
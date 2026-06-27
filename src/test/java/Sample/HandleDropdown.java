package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(By.id("course")));
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		
		dropdown.selectByValue("java");
		
		Thread.sleep(2000);
		
		dropdown.selectByVisibleText("Java");
		Thread.sleep(2000);
		driver.quit();
		
	}

}

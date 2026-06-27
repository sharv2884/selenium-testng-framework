package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		WebElement firstDate= driver.findElement(By.id("first_date_picker"));
		firstDate.click();
		
		
		
	}
	
	

}

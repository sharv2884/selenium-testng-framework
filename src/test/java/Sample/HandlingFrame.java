package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.switchTo().frame(0);
		
		System.out.println("System showed frame1");
		
		driver.switchTo().defaultContent();
		System.out.println("The system is in the main page");
		
		driver.switchTo().frame("frm1");
		System.out.println("The system is in frame 1");
		
		driver.switchTo().defaultContent(); 
		System.out.println("The system is in the main page");
		
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		System.out.println("The web element is in frame 1");
		
		driver.quit();

	}

}

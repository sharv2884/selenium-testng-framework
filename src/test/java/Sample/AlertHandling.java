package Sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10)); //explicit wait
		
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alertBox")).click(); //has only one button "OK" (for accepting)
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("confirmBox")).click(); //has "OK" and "Cancel" button (dismiss() used to click on cancel)
		Thread.sleep(2000);
		Alert dismiss=driver.switchTo().alert();
		dismiss.dismiss();
		
		driver.findElement(By.id("promptBox")).click(); //has both buttons along with prompt box to enter text or value
		Thread.sleep(2000);
		Alert prompt= driver.switchTo().alert();
		
		String text=prompt.getText();
		System.out.println("Alert text is: "+ text);
		prompt.accept();
		
		driver.quit();	
	}

}

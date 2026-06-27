package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement doubleClick = driver.findElement(By.id("doubleBtn"));
		actions.doubleClick(doubleClick).perform();
		driver.findElement(By.id("doubleStatus")).getText();

		WebElement rightClick = driver.findElement(By.id("rightBtn"));
		actions.contextClick(rightClick).perform();
		driver.findElement(By.id("doubleStatus")).getText();

		WebElement sourceButton = driver.findElement(By.id("dragItem"));
		WebElement targetButton = driver.findElement(By.id("dropZone"));
		actions.dragAndDrop(sourceButton, targetButton);
		driver.findElement(By.id("doubleStatus")).getText();

		WebElement resetButton = driver.findElement(By.id("resetBtn"));
		actions.click(resetButton).perform();
		driver.findElement(By.id("doubleStatus")).getText();

		WebElement hoverOver = driver.findElement(By.id("tooltipTarget"));
		actions.moveToElement(hoverOver).perform();
		driver.findElement(By.id("doubleStatus")).getText();

		WebElement slider = driver.findElement(By.id("handle_max"));
		actions.clickAndHold(slider).moveByOffset(100, 0).release().perform();
		driver.findElement(By.id("doubleStatus")).getText();

		driver.quit();

	}

}

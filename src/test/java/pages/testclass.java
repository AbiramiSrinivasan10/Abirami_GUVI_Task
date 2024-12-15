package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testclass {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver(); // Initializing the chrome browser

		/// Implicit wait -global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.demoblaze.com/"); // Opening the browser and website
		driver.findElement(By.id("signin2")).click();

		// Entering username
		driver.findElement(By.id("sign-username")).sendKeys("Abirami");
		// Entering password
		driver.findElement(By.id("sign-password")).sendKeys("123s");
		driver.findElement(By.id("signin2")).click();

	}

}

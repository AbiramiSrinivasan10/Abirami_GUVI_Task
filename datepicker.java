package Task10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker {

	public static void main(String[] args) {
		//Invoking Browser
		WebDriver driver=new ChromeDriver();
		
		//implicit wait - global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Maximize the window using maximize() method
		driver.manage().window().maximize();
		
		//Navigates to the URL
		driver.navigate().to("https://jqueryui.com/datepicker/");
		
		//Check how many iframes in the page		
		List<WebElement> iframeEle = driver.findElements(By.tagName("iframe"));
		int n = iframeEle.size();
		System.out.println("Total iframes on the page are : " + n);
		//Switch to frame (0)
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	
	    driver.findElement(By.xpath("//a[@data-date='22']")).click();
	   
	    //print the Selected date
		System.out.println("Selected Date : "+driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value"));
		 //driver.quit();
	}

}

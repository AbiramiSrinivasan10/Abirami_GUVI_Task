package Task10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class DragDrop {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		// Invoking Browser
				WebDriver driver=new ChromeDriver();
				
				//implicit wait - global wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
				
				//Maximize the window using maximize() method
				driver.manage().window().maximize();
				
				//Navigates to the URL
				driver.get("https://jqueryui.com/droppable/");
			
			//Find how many iframes in the page
			List<WebElement> iframeEle = driver.findElements(By.tagName("iframe"));
			int n = iframeEle.size();
			System.out.println("Total iframes on the page are : " + n);
			driver.switchTo().frame(0);
			//using thread.sleep method
			Thread.sleep(2000);
			
			WebElement element1= driver.findElement(By.id("draggable"));
			
			WebElement element2= driver.findElement(By.id("droppable"));
			
			Actions objAct=new Actions(driver);
			objAct.dragAndDrop(element1, element2).build().perform(); // Dragging ele1 and dropping to ele2 
			
			//Check background color are equal using Assert Method
			String x=element2.getText();
			String Color =element2.findElement(By.xpath("//div[@id='droppable']"))
		            .getCssValue("background-color");
			
			Assert.assertEquals("rgba(255, 250, 144, 1)", Color);
				
			//Check the condition using if statement
			
			if (x.equalsIgnoreCase("Dropped!")) {
				System.out.println("Dragdrop Successful");
			}else
				System.out.println("Dragdrop Not successful");
			}
	
		 	
			}



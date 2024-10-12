package Task11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {

	public static void main(String[] args) {
		//invoking browser
		WebDriver driver=new ChromeDriver();
		
		//implicit wait - global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
		//navigate to the URL
		driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");
		
		//Maximize the browser
		driver.manage().window().maximize();
		//create obj for  topFrame
		WebElement topFrame = driver.findElement(By.xpath("//frame[@src='/frame_top']"));
	
		driver.switchTo().frame(topFrame);

		//Check how many frames in the page
		List<WebElement> frameEle = driver.findElements(By.tagName("frame"));
		int n = frameEle.size();
		System.out.println("Total frames on the page are : " + n);
		
		//Switch to leftFrame
		WebElement leftFrame = driver.findElement(By.xpath("//frame[@src='/frame_left']"));
		driver.switchTo().frame(leftFrame);
		String leftFrameText=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		System.out.println("LeftFrame text : "+leftFrameText);
		
		//Switch to topFrame		
		driver.switchTo().parentFrame();
		
		//Switch to middleFrame
		WebElement middleFrame = driver.findElement(By.xpath("//frame[@src='/frame_middle']"));
		driver.switchTo().frame(middleFrame);
		String middleFrameText =driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]")).getText();
		System.out.println("MiddleFrame text : "+middleFrameText);
		
		//Switch to topFrame				
		driver.switchTo().parentFrame();
		
		//Switch to rightFrame
		WebElement rightFrame = driver.findElement(By.xpath("//frame[@src='/frame_right']"));
		driver.switchTo().frame(rightFrame);
		String rightFrameText =driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		System.out.println("RightFrame text : "+rightFrameText);
		
		//Switch to topFrame	
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		//Switch to bottomFrame
		WebElement bottomFrame = driver.findElement(By.xpath("//frame[@src='/frame_bottom']"));
		driver.switchTo().frame(bottomFrame);
		String bottomFrameText =driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		System.out.println("BottomFrame text : "+bottomFrameText);
		
		//Switch to topFrame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(topFrame);
		
		

		

	}

}

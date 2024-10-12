package Task11;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Herokuapp {

	public static void main(String[] args) {
		       //invoking browser
				WebDriver driver=new ChromeDriver();
				
				//implicit wait - global wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
				
				//navigate to the URL
				driver.navigate().to("https://the-internet.herokuapp.com/windows");
				
				//Maximize the browser
				driver.manage().window().maximize();
				
				//click the clicK here button
				driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
				//Creating obj foe parent window
				String mainWindowHandle=driver.getWindowHandle();
				System.out.println(mainWindowHandle);
				
				Set<String> allWindowHandles=driver.getWindowHandles();
				//Itereting the set to go to second window
				Iterator<String> iterator=allWindowHandles.iterator();
				while(iterator.hasNext()) {
					String childwindow=iterator.next();
					
					if(!mainWindowHandle.equals(childwindow)) {
						driver.switchTo().window(childwindow);
						String text=driver.findElement(By.xpath("//div[@class='example']")).getText();
						System.out.println("New window page text : "+text);
						driver.close();
						String mainWindowtitle=driver.switchTo().window(mainWindowHandle).getTitle();
						System.out.println("Original Window Title : "+mainWindowtitle);
						if(mainWindowtitle.contains("The Internet")){
							System.out.println("Original window is Active");
						}
						else {
							System.out.println("Current window is not Active");
						}
		}
	  }
    }
}

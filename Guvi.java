package Task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import java.util.List;


public class Guvi {

	public static void main(String[] args) {
		//Open GoogleChrome browser
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		//Navigate to Guvi Webpage
		driver.navigate().to("https://www.guvi.in/");
		
		
		//Fill Signup form
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Giritharan");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("giriyogan1@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("giri23");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("9677749274");
		driver.findElement(By.xpath("//a[@id='signup-btn']")).click();
		WebElement sel=driver.findElement(By.id("profileDrpDwn"));
		Select profile=new Select(sel);
		
		if (profile.isMultiple()) { 
		profile.selectByIndex(0);
		profile.selectByValue("Student");
		}
		else {
			profile.selectByValue("Student");
		}
		
		WebElement deg=driver.findElement(By.id("degreeDrpDwn"));
		Select degree=new Select(deg);
		
		if(degree.isMultiple()) {
			degree.selectByIndex(1);
			degree.selectByValue("B.E. / B.Tech. ECE");
		}
		else {
			degree.selectByValue("B.E. / B.Tech. ECE");
		}
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2022");
		driver.findElement(By.xpath("//a[@id='details-btn']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Navigate to Gmail login
		driver.findElement(By.xpath("//p[@class='mr-2']")).click();
		driver.findElement(By.xpath("//a[@data-action='sign in']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("giriyogan1@gmail.com");
		driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("Yogan@2012");
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys(Keys.ENTER);
		
		//Check Guvi registration email and activate		
		List<WebElement> email = driver.findElements(By.cssSelector("span[class$='y2']"));
		for(WebElement emailsub : email){
		    if(emailsub.getText().equals("Welcome to GUVI") == true){

		           emailsub.click();
		           break;
		        }
		    }
		driver.findElement(By.cssSelector("span[class='Zt']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Activate Now')]")).click();
		
		//Verify if registration is successful
		Object[] windowHandles=driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[1]);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String loginTitle = driver.getTitle();
		if(loginTitle.contains("GUVI | Learn to code in your native language")) {
			System.out.println("Registration Successful");
		}
		
		//Login to GUVI portal with registered user
		driver.navigate().to("https://www.guvi.in/");
		driver.findElement(By.xpath("//a[@id='login-btn']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("giriyogan1@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("giri123");
		driver.findElement(By.xpath("//a[@id='login-btn']")).click();
		
		//Verify if the login is successful
		driver.findElement(By.xpath("//button[@class='btn dropdown account-box-toggler']")).click();
		String loginId = driver.findElement(By.xpath("//small[contains(.,'giriyogan1@gmail.com')]")).getText();
		if(loginId.contains("giriyogan1@gmail.com")) {
			System.out.println("Login Successful");
		}
		}
	

	}
	



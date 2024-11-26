package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import base.projectSpecification;

public class selectHotelPage extends projectSpecification  {

	WebDriver driver;
	public selectHotelPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(id="radiobutton_1") WebElement rbutton;
	@FindBy(id="continue") WebElement cont;
	@FindBy(id="cancel") WebElement canc;
	
	public void selecthotel(){
		rbutton.click();
		System.out.println("Hotel Selected");
	}
	public void clickcontinue(){
		cont.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		System.out.println("Continue Clicked");
	}
	public void clickcancel(){
		canc.click();
	}
	
	public void validateSearchResult(String expected) {
		System.out.println("actual"+driver.getTitle());
		System.out.println("expected"+expected);
		String actual = driver.getTitle();
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actual, expected);
		assertObj.assertAll();
	}

}

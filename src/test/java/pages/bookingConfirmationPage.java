package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.projectSpecification;
import base.utility;

public class bookingConfirmationPage extends projectSpecification{

	WebDriver driver;
	public bookingConfirmationPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	public void validateBookingResult() {
		String actual = driver.findElement(By.xpath("//input[@id='order_no']")).getText();
		System.out.println("actual:"+actual);
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(!actual.equals(null));
		assertObj.assertAll();
	}
	public void validateBookingName(String expected) {
		String actual = driver.findElement(By.xpath("//input[@id='last_name']")).getText();
		System.out.println("expected:"+expected);
		System.out.println("actual:"+actual);
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(!actual.equals(null));
		assertObj.assertAll();
	}
}

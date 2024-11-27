package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.projectSpecification;
import base.utility;

public class bookedItineraryPage extends projectSpecification {
	
	WebDriver driver;
	public bookedItineraryPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCheckbox(String orderId) {
		System.out.println("OrderId:"+orderId);
		String orderName=driver.findElement(By.cssSelector("input[value*='"+orderId+"']")).getAttribute("name");
		System.out.println("OrderName:"+orderName);
		String[] orderNameSplit = orderName.split("_");
		String checkboxValue = orderNameSplit[2];
		System.out.println("CheckboxValue:"+checkboxValue);
		driver.findElement(By.cssSelector("input[value*='"+checkboxValue+"']")).click();
	}

	public void clickCancelButton(String orderId) {
		driver.findElement(By.cssSelector("input[value*='Cancel "+orderId+"']")).click();
		driver.switchTo().alert().accept();
	}
	
	public void clickCancelSelected() {
		driver.findElement(By.cssSelector("input[value*='Cancel Selected']")).click();
		driver.switchTo().alert().accept();
	}
	
	public boolean validateBookedItinerary(String expected) {
		if( driver.getTitle().contains(expected) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateLogout(String expected) {
		if( driver.getTitle().contains(expected) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateCancelBooking(String orderId) {
		try {
			driver.findElement(By.cssSelector("input[value*='"+orderId+"']")).click();
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public void executeTestCase(String testCase, 
								String result, 
								String expected, 
								String orderId) throws IOException {
		SoftAssert assertObj = new SoftAssert();
		switch(testCase) {
			case "TC_026":
				driver.findElement(By.xpath("//a[normalize-space()='Booked Itinerary']")).click();
				assertObj.assertEquals(driver.getTitle(), expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			case "TC_027":
				driver.findElement(By.xpath("//a[normalize-space()='Booked Itinerary']")).click();
				clickCancelButton(orderId);
				assertObj.assertTrue(validateCancelBooking(orderId));
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			case "TC_028":
				driver.findElement(By.xpath("//a[normalize-space()='Booked Itinerary']")).click();
				selectCheckbox(orderId);
				clickCancelSelected();
				assertObj.assertTrue(validateCancelBooking(orderId));
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			case "TC_029":
				driver.findElement(By.xpath("//a[normalize-space()='Booked Itinerary']")).click();
				String[] orders = orderId.split(",");
				for(int i=0;i<orders.length;i++) {
					selectCheckbox(orders[i]);
				}
				clickCancelSelected();
				for(int i=0;i<orders.length;i++) {
					assertObj.assertTrue(validateCancelBooking(orders[i]));
					assertObj.assertAll();
				}
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			case "TC_030":
				driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
				assertObj.assertTrue(validateLogout(expected));
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
		}
	}
}

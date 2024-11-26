package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.projectSpecification;
import base.utility;

public class searchHotelPage extends projectSpecification {
	WebDriver driver;
	public searchHotelPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
		@FindBy(id="location")WebElement location;
		@FindBy(id="hotels")WebElement Hotel;
		@FindBy(id="room_type")WebElement Roomtype;
		@FindBy(id="room_nos")WebElement RoomNo;
		@FindBy(id="datepick_in")WebElement Checkin;
		@FindBy(id="datepick_out")WebElement Checkout;
		@FindBy(id="adult_room")WebElement Adult;
		@FindBy(id="child_room")WebElement Child;
		@FindBy(id="Submit")WebElement Search;
		@FindBy(id="Reset")WebElement Reset;
		@FindBy(id="username_show")WebElement userName;
		
		public void enterLocation(String value) {
			if(!value.equals(" ")) {
				Select dropdown=new Select(location);
				dropdown.selectByValue(value);
			}
		}
		public void enterHotel(String value) {
			if(!value.equals(" ")) {
				Select dropdown=new Select(Hotel);
				dropdown.selectByValue(value);
			}
		}
		public void selectRoomtype(String value) {
			if(!value.equals(" ")) {
				Select dropdown=new Select(Roomtype);
				dropdown.selectByValue(value);
			}
		}
		public void enterNumberofRooms(String value) {
			if(!value.equals(" ")) {
				Select dropdown=new Select(RoomNo);
				dropdown.selectByValue(value);
			}else {
				Select dropdown=new Select(RoomNo);
				dropdown.selectByVisibleText("- Select Number of Rooms -");
			}
		}
		public void enterCheckindate(String value) {
			if(!value.equals(" ")) {
				Checkin.clear();
				Checkin.sendKeys(value);
			}else {
				Checkin.clear();
			}
		}
		public void enterCheckoutdate(String value) {
			if(!value.equals(" ")) {
				Checkout.clear();
				Checkout.sendKeys(value);
			}else {
				Checkout.clear();
			}
		}
		public void enterNoofAdult(String value) {
			if(!value.equals(" ")) {
				Select dropdown=new Select(Adult);
				dropdown.selectByValue(value);
			}else {
				Select dropdown=new Select(Adult);
				dropdown.selectByVisibleText("- Select Adults per Room -");
			}
		}
		public void enterNoofChild(String value) {
			if(!value.equals(" ")) {
				Select dropdown=new Select(Child);
				dropdown.selectByValue(value);
			}
		}
		public void clickSubmit() {
			Search.click();
		}
		public void validateSuccessfulLogin(String expected) {
			//String actual = userName.getText();
			String actual = driver.getTitle();
			SoftAssert assertObj = new SoftAssert();
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
		}
		public void validateSearch( String testCase, 
									String result, 
									String expected ) throws IOException {
			System.out.println("validation started");
			String actual;
			SoftAssert assertObj = new SoftAssert();
			selectHotelPage selectPage = new selectHotelPage(driver);
			switch(testCase) {
			  case "TC_003":
				actual = driver.findElement(By.xpath("//span[@id='location_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break;
			  case "TC_004":
				actual = driver.findElement(By.xpath("//span[@id='num_room_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break;
			  case "TC_005":
				actual = driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  case "TC_006":
				actual = driver.findElement(By.xpath("//span[@id='checkout_span']")).getText();
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);	
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  case "TC_007":
				actual = driver.findElement(By.xpath("//span[@id='adults_room_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  case "TC_008":
				try {
					actual = driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();	
					assertObj.assertEquals(actual, expected);
					assertObj.assertAll();
					test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				}
				catch (org.openqa.selenium.NoSuchElementException e) {
				    System.out.println("actual:"+driver.getTitle());
					System.out.println("expected:"+expected);
					test.fail(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				}
				break;
			  case "TC_009":
				actual = driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  case "TC_010":
				selectPage.validateSearchResult(expected);
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  case "TC_011":
				selectPage.validateSearchResult(expected);
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  case "TC_012":
				selectPage.validateSearchResult(expected);
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
			  default:
			    // code block
			}
		}
		/*public void Reset() {
			Reset.click();
			}*/

}

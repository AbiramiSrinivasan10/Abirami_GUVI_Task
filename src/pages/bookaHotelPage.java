package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.projectSpecification;
import base.utility;
import pages.bookingConfirmationPage;

public class bookaHotelPage extends projectSpecification {
	WebDriver driver;
	public bookaHotelPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")WebElement firstname;
	@FindBy(id="last_name")WebElement lastname;
	@FindBy(id="address")WebElement address;
	@FindBy(id="cc_num")WebElement cardNo;
	@FindBy(id="cc_type")WebElement cardtype;
	@FindBy(id="cc_exp_month")WebElement expmonth;
	@FindBy(id="cc_exp_year")WebElement expyear;
	@FindBy(id="cc_cvv")WebElement cvvno;
	@FindBy(id="book_now")WebElement booknow;
	@FindBy(id="cancel")WebElement cancel;
	
	public void EnterFirstname(String fname) {
		if(!fname.equals(" ")) {
			firstname.sendKeys(fname);
		}
	}
	public void EnterLastname(String lname) {
		if(!lname.equals(" ")) {
			lastname.sendKeys(lname);
		}
	}
	public void EnterAddress(String add) {
		if(!add.equals(" ")) {
			address.sendKeys(add);
		}
	}
	public void EntercardNo(String cardno) {
		if(!cardno.equals(" ")) {
			cardNo.sendKeys(cardno);
		}
	}
	public void Selectcardtype(String value) {
		if(!value.equals(" ")) {
			Select dropdown=new Select(cardtype);
			dropdown.selectByValue(value);
		}
	}
	public void Selectexpmonth(String value) {
		if(!value.equals(" ")) {
			Select dropdown=new Select(expmonth);
			dropdown.selectByValue(value);
		}
	}
	
	public void Selectexpyear(String value) {
		if(!value.equals(" ")) {
			Select dropdown=new Select(expyear);
			dropdown.selectByValue(value);
		}
	}
	public void Entercvvno(String cvno) {
		if(!cvvno.equals(" ")) {
			cvvno.sendKeys(cvno);
		}
	}
	public void book() {
		System.out.println("Book clicked");
		booknow.click();
	}
	public void validateHotelSelection(String testCase, 
										String result, 
										String expected ) throws IOException  {
		
			System.out.println("actual"+driver.getTitle());
			System.out.println("expected"+expected);
			String actual = driver.getTitle();
			SoftAssert assertObj = new SoftAssert();
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
	}

	public void validateBookhotel( String testCase, 
									String result, 
									String expected ) throws IOException {
		System.out.println("validation started");
		String actual;
		SoftAssert assertObj = new SoftAssert();
		selectHotelPage selectPage = new selectHotelPage(driver);
		switch(testCase) {
			case "TC_013":
				actual = driver.findElement(By.xpath("//label[@id='first_name_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
		   case "TC_014":
				actual = driver.findElement(By.xpath("//label[@id='last_name_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break;
		   case "TC_015":
				actual = driver.findElement(By.xpath("//label[@id='address_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break;   
		   case "TC_016":
				actual = driver.findElement(By.xpath("//label[@id='cc_num_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break;   
		   case "TC_017":
				actual = driver.findElement(By.xpath("//label[@id='cc_type_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break; 
		   case "TC_018":
				actual = driver.findElement(By.xpath("//label[@id='cc_expiry_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break; 
		   case "TC_019":
				actual = driver.findElement(By.xpath("//label[@id='cc_expiry_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break; 
		   case "TC_020":
				actual = driver.findElement(By.xpath("//label[@id='cc_cvv_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break; 
		   case "TC_021":
				actual = driver.findElement(By.xpath("//label[@id='cc_num_span']")).getText();	
				System.out.println("actual:"+actual);
				System.out.println("expected:"+expected);
				assertObj.assertEquals(actual, expected);
				assertObj.assertAll();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			    break;   
		   case "TC_022":
			   try {
					actual = driver.switchTo().alert().getText();	
					System.out.println("actual:"+actual);
					System.out.println("expected:"+expected);
					assertObj.assertEquals(actual, expected);
					assertObj.assertAll();
					test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
					break;   
			   } catch (org.openqa.selenium.NoAlertPresentException e) {
				   	test.fail(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
			   }
		   
		}
	}
}
	
	

//first_name_span
////label[@id='cc_expiry_span']
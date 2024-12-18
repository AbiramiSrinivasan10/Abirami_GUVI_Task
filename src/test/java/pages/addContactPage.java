package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;


public class addContactPage extends projectSpecification {
WebDriver driver;
	
	public addContactPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="firstName")WebElement contactFirstName;
	@FindBy(id="lastName")WebElement  contactLastName;
	@FindBy(id="birthdate")WebElement birthdate;
	@FindBy(id="email")WebElement contactEmail;
	@FindBy(id="phone")WebElement phoneNo;
	@FindBy(id="street1")WebElement street1;
	@FindBy(id="street2")WebElement street2;
	@FindBy(id="city")WebElement cityName;
	@FindBy(id="stateProvince")WebElement stateName;
	@FindBy(id="postalCode")WebElement postalCode;
	@FindBy(id="country")WebElement countryName;
	@FindBy(id="submit")WebElement submit;
	
	public void enterFirstName(String fname) {
		if(!fname.equals(" ")) {
			contactFirstName.sendKeys(fname);
	}
	}
	public void enterLastName(String lname) {
		if(!lname.equals(" ")) {
			contactLastName.sendKeys(lname);
		}
	}
	public void enterBirthDate(String dob) {
		birthdate.sendKeys(dob);
	}
	public void enterEmail(String email) {
		contactEmail.sendKeys(email);
	}
	public void enterPhoneno(String phNo) {
		phoneNo.sendKeys(phNo);
	}
	public void enterStreetName1(String streetname1) {
		street1.sendKeys(streetname1);
	}
	public void enterStreetName2(String streetname2) {
		if(!streetname2.equals(" ")) {
		street2.sendKeys(streetname2);
	}
	}
	public void enterCityName(String city) {
		if(!city.equals(" ")) {
		cityName.sendKeys(city);
	}
	}
	public void enterStateName(String state) {
		stateName.sendKeys(state);
	}
	public void enterPostalCode(String postal) {
		postalCode.sendKeys(postal);
	}
	public void enterCountryName(String country) {
		countryName.sendKeys(country);
	}
	public void clickSubmitButton() {//contactList
		submit.click();
	}
	public void validateAddContact (String testCase, String result, String expected ) throws IOException {
		System.out.println("validation started: "+testCase);
		String actual;
		SoftAssert assertObj = new SoftAssert();
		contactListPage contact=new contactListPage(driver);
		contact.clickAddNewContactButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		switch(testCase) {
		case "TC_001":
			Boolean element = wait.until(ExpectedConditions.titleContains("My Contacts"));
			actual = driver.getTitle();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
			
		case "TC_002":
			
			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("error")));
			actual = driver.findElement(By.id("error")).getText();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
			
		case "TC_003":
			
			 element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("error")));
			actual = driver.findElement(By.id("error")).getText();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
			
			
		case "TC_004":
			element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("error")));
			actual = driver.findElement(By.id("error")).getText();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
			
		case "TC_005":
			 element =  wait.until(ExpectedConditions.titleContains("My Contacts"));
			actual = driver.getTitle();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
			
		case "TC_006":
			 element = wait.until(ExpectedConditions.titleContains("My Contacts"));
			actual =driver.getTitle();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
		case "TC_007":
			 element =  wait.until(ExpectedConditions.titleContains("My Contacts"));
			actual = driver.getTitle();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
		case "TC_008":
			element =  wait.until(ExpectedConditions.titleContains("My Contacts"));
			actual = driver.getTitle();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;
		case "TC_009":
			element =  wait.until(ExpectedConditions.titleContains("My Contacts"));
			actual = driver.getTitle();	
			System.out.println("actual:"+actual);
			System.out.println("expected:"+expected);
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot(testCase)).build());
			break;		
		
	}
}
}

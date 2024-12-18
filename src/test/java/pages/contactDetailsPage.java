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

public class contactDetailsPage extends projectSpecification {
WebDriver driver;
	
	public contactDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="edit-contact")WebElement editContact;
	@FindBy(id="delete")WebElement deleteContact;
	@FindBy(id="return")WebElement returnContact;
	@FindBy(xpath="/html/body/div[1]/header/h1")WebElement contactDetail;
	@FindBy(id="firstName")WebElement firstName;
	@FindBy(id="lastName")WebElement lastName;
	@FindBy(id="birthdate")WebElement birthdate;
	@FindBy(id="email")WebElement email;
	@FindBy(id="phone")WebElement phone;
	@FindBy(id="street1")WebElement street1;
	@FindBy(id="street2")WebElement street2;
	@FindBy(id="city")WebElement city;
	@FindBy(id="stateProvince")WebElement stateProvince;
	@FindBy(id="postalCode")WebElement postalCode;
	@FindBy(id="country")WebElement country;
	@FindBy(id="submit")WebElement submit;
	
	public void clickContact() {
		//WebElement element=driver.findElement(By.xpath("")).click();
	}
	public void clickEditContactButton() {
		editContact.click();
	}
	public void clickDeleleContactButton() {
		deleteContact.click();
	}
	public void clickReturnContactButton() {
		returnContact.click();
	}
	public void clickSubmitButton() {
		submit.click();
	}
	public void enterCity(String value) {
		try {
			city.sendKeys(value);
		} catch(java.lang.IllegalArgumentException e){
			System.out.println("Cannot pass empty value during edit");
			test.info("Cannot pass empty value during edit");
		}
	}
	public void checkContactDetailDisplay() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/header/h1")));
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(contactDetail.getText().contains("Contact Details"));
		assertObj.assertAll();
		if(contactDetail.getText().contains("Contact Details")) {
			System.out.println("Successfully redirected to Contacts Detail page");
			test.pass("Successfully redirected to Contacts Detail page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactDetail")).build());
		}else {
			System.out.println("Successfully redirected to Contacts Detail page");
			test.fail("Successfully redirected to Contacts Detail page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactDetail")).build());
		}		
	}
	public void editContact(String editValue) {
		lastName.sendKeys(lastName.getText()+editValue);
		street2.sendKeys(street2.getText()+' '+editValue);
	}
	public void checkContactEdit(String editValue) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("lastName")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("birthdate")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phone")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("street1")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("street2")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("stateProvince")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("postalCode")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertFalse(firstName.getText().contains(editValue));
		assertObj.assertTrue(lastName.getText().contains(editValue));
		assertObj.assertFalse(birthdate.getText().contains(editValue));
		assertObj.assertFalse(email.getText().contains(editValue));
		assertObj.assertFalse(phone.getText().contains(editValue));
		assertObj.assertFalse(street1.getText().contains(editValue));
		assertObj.assertTrue(street2.getText().contains(editValue));
		assertObj.assertFalse(city.getText().contains(editValue));
		assertObj.assertFalse(stateProvince.getText().contains(editValue));
		assertObj.assertFalse(postalCode.getText().contains(editValue));
		assertObj.assertFalse(country.getText().contains(editValue));
		if(!(firstName.getText().contains(editValue) ||
		     birthdate.getText().contains(editValue) ||
		     email.getText().contains(editValue) ||
		     phone.getText().contains(editValue) ||
		     street1.getText().contains(editValue) ||
		     city.getText().contains(editValue) ||
		     stateProvince.getText().contains(editValue) ||
		     postalCode.getText().contains(editValue) ||
		     country.getText().contains(editValue) ) ) {
			System.out.println("Contact edit has not affected other fields");
			test.pass("Contact edit has not affected other fields",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactEdit")).build());
		}else {
			System.out.println("Contact edit has affected other fields");
			test.pass("Contact edit has affected other fields",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactEdit")).build());
		}
	}
	public void checkEmptyField() throws IOException {
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(city.getText().isBlank());
		assertObj.assertAll();
		if(city.getText().isBlank()) {
			System.out.println("City saved with empty fields");
			test.pass("City saved with empty fields",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactEmptyfield")).build());
		}else {
			System.out.println("Contact edit doesn't allow empty field");
			test.pass("Contact edit doesn't allow empty field",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactEmptyfield")).build());
		
		}
	}
	public void checkDeleteAlert() throws IOException {
		System.out.println("Alert text: "+driver.switchTo().alert().getText());
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(driver.switchTo().alert().getText().contains("Are you sure you want to delete this contact?"));
		assertObj.assertAll();
		if(driver.switchTo().alert().getText().contains("Are you sure you want to delete this contact?")) {
			System.out.println("Delete Alert displayed");
			test.info("Delete Alert displayed");
		}else {
			System.out.println("Delete Alert not displayed");
			test.info("Delete Alert not displayed");
		
		}
	}
}

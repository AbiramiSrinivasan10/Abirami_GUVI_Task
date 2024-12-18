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

public class loginPage extends projectSpecification {
WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Log In:']")WebElement login;
	@FindBy(id="email")WebElement lemail;
	@FindBy(id="password")WebElement lpassword;
	@FindBy(id="submit")WebElement loginSubmit;
	@FindBy(id="error")WebElement errorMessage;
	
	public void enterEmailId() {
		lemail.sendKeys("abirami@gmail.com");
	}
	public void enterPassword() {
		lpassword.sendKeys("hero@2024");
	}
	public void clickLoginSubmitButton() {
		loginSubmit.click();
	}
	public void enterInvalidEmailId() {
		lemail.sendKeys("abirami10@gmail.com");
	}

	public void validateLoginSubmitVisible() throws IOException {
		System.out.println("Expected: Log In");
		System.out.println("Actual: "+login.getText());
		
		if(loginSubmit.getText().contains("Submit")) {
			System.out.println("Log in button is visible");
			test.info("Log in button is visible");
		} else {
			System.out.println("Log in button is not visible");
			test.info("Log in button is not visible");
		}
	}
	public void checkInvalidLogin() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("error")));
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(errorMessage.getText().contains("Incorrect username or password"));
		assertObj.assertAll();
		if(errorMessage.getText().contains("Incorrect username or password")) {
			System.out.println("Invalid login checked");
			test.pass("Invalid login checked", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("InvalidLogin")).build());
		}else {
			System.out.println("Invalid login check not working");
			test.fail("Invalid login check not working", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("InvalidLogin")).build());
		}
	}
	public void checkLogout() throws IOException {
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(driver.getTitle().contains("Contact List App"));
		assertObj.assertAll();
		if(driver.getTitle().contains("Contact List App")) {
			System.out.println("Logged out Successfully");
			test.pass("Logged out Successfully", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Logout")).build());
		}else {
			System.out.println("Logout not working");
			test.fail("Logout not working", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Logout")).build());
		}
	}
}

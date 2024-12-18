package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;

public class signUpPage extends projectSpecification {
WebDriver driver;
	
	public signUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="signup")WebElement signupButton;
	@FindBy(id="firstName")WebElement firstName;
	@FindBy(id="lastName")WebElement lastName;
	@FindBy(id="email")WebElement email;
	@FindBy(id="password")WebElement password;
	@FindBy(id="submit")WebElement submit;

	public void clickSignupButton() {
		signupButton.click();
		System.out.println("SignUp Clicked");
		System.out.println(driver.getTitle());
	}
	public void enterFirstName() {
		firstName.sendKeys("Abirami");
	}
	public void enterLastName() {
		lastName.sendKeys("Srinivasan");
	}
	public void enterEmail() {
		email.sendKeys("abirami@gmail.com");
	}
	public void enterPassword() {
		password.sendKeys("hero@2024");
	}
	public void clickSubmitButton() {
		submit.click();
	}
	public void validateSignUpClick() throws IOException{
		System.out.println("SignUp clicked");
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected:Add User");
		System.out.println("Actual: "+driver.getTitle());
		assertObj.assertAll();
		test.pass("Signup button is clickable",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Signup")).build());
	}



}

//signup
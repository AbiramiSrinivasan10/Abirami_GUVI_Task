package pages;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;
import base.Utility;


//import base.projectSpecification;

public class signupPage extends projectSpecification {
WebDriver driver;
	
	public signupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	//SignUp page
	@FindBy(id="signin2") WebElement signUp;	
	@FindBy(id="sign-username")WebElement username;
	@FindBy(id="sign-password")WebElement password;
	@FindBy(id="signin2")WebElement signup;
	@FindBy(id="signInModalLabel")WebElement afterclick;
	@FindBy(id="sign-username")WebElement signUserName;
	@FindBy(xpath="//*[@id=\"signInModalLabel\"]")WebElement signUpWindowTitle;
	//@FindBy(className="btn btn-secondary")WebElement close;
	
	

		public void clickSignup() {
			signUp.click();
			System.out.println("SignUp clicked");
		}
		
		public void enterUsername(String uname) {
			username.sendKeys(uname);
		}
		public void enterPassword(String pword) {
			username.sendKeys(pword);
		}
		public void click() {
			signup.click();
			System.out.println("Successfully Signup");
		}
		
		public void validateSignUpButton() throws IOException {
			SoftAssert assertObj = new SoftAssert();
			System.out.println("Expected: Sign up");
			System.out.println("Actual: "+signup.getText());
			if(signup.getText().contains("Sign up") ) {
				System.out.println("Sign up button visible");
				test.pass("Sign up button visible", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("SignUpButton")).build());
			} else {
				System.out.println("Sign Up button not available");
			}
				
		}
		public void validateSignUpWindow() throws IOException{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signInModalLabel\"]")));
			SoftAssert assertObj = new SoftAssert();
			System.out.println("Expected Window Title: Sign up");
			System.out.println("Actual Window Title: "+signUpWindowTitle.getText());
			assertObj.assertTrue(signUpWindowTitle.getText().contains("Sign up"));
			assertObj.assertAll();
			test.pass("Sign up window validated", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("SignUpWindow")).build());
			
		}
		
		
}




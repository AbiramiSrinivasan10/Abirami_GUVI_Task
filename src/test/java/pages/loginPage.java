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

public class loginPage extends projectSpecification {
    WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login2")WebElement login;
	@FindBy(id="loginusername")WebElement lusername;
	@FindBy(id="loginpassword")WebElement lpassword;
	@FindBy(xpath="//button[text()='Log in']")WebElement popupLogin;
	@FindBy(xpath="//a[@id='nameofuser']")WebElement nameuser;

	public void clickLogin() {
		login.click();
		System.out.println("Log in clicked");
	}
	public void enterUsername() {
		lusername.sendKeys("AbiramiS");
	}
	public void enterPassword() {
		lpassword.sendKeys("1234s");
	}
	public void clickPopupLogin() {
		popupLogin.click();
	}
	
	/*public void welcomeuser() throws IOException {
		if(nameuser.isDisplayed()) {
			System.out.println("Welcome User Displayed");
			test.pass("Welcome User Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("WelcomeScreen")).build());
		}else {
			System.out.println("Welcome User not Displayed");
			test.fail("Welcome User not Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("WelcomeScreen")).build());
		}
		
	}
	/*public void logout() {
		logout.click();
	}*/
	public void validateLoginButton(String scenario) throws IOException {
		
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: Log in");
		System.out.println("Actual: "+login.getText());
				
		if(login.getText().contains("Log in") ) {
			System.out.println("Log in button visible");
			if(scenario.contains("Login")) {
				test.pass("Log in button visible", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LoginButton")).build());
			}else {
				test.pass("Loggedout Successfully", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Loggedout")).build());
			}
		} else {
			System.out.println("Log in button not available");
			if(scenario.contains("Login")) {
				test.fail("Log in button not available", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LoginButton")).build());
			}else {
				test.fail("Logout failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Loggedout")).build());
			}
		}
	}
}


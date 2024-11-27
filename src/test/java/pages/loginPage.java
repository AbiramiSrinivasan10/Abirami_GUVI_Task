package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.projectSpecification;
import pages.searchHotelPage;
import base.projectSpecification;
import base.utility;

public class loginPage extends projectSpecification {
WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login")WebElement login;
	
	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}
	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}
	public void clickLogin() {
		login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		System.out.println("Login clicked");
	}
	public void validateLogin (	String testCase, 
								String result, 
								String expected) throws IOException {
		if(testCase.contains("TC_001")) {
			searchHotelPage searchPage = new searchHotelPage(driver);
			searchPage.validateSuccessfulLogin(expected);
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
		} else if(testCase.contains("TC_002")){
			String actual = driver.findElement(By.xpath("//b[contains(text(),'Invalid Login details or Your Password might have ')]")).getText();	
			SoftAssert assertObj = new SoftAssert();
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
			test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
		}
	}
}

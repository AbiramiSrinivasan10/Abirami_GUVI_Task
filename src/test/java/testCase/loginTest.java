package testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.homePage;
import pages.loginPage;

public class loginTest extends projectSpecification{
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void validateLoginTest () throws IOException{

		testName="Login Test";
		testDescription="Test Login functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.validateLoginButton("Login");
		login.clickLogin();
		login.enterUsername();
		login.enterPassword();
		login.clickPopupLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
		
		homePage home=new homePage(driver);
		home.checklogoutbutton();
		
	}
	@Test
	public void validateLogoutTest () throws IOException{
		testName="Logout Test";
		testDescription="Test Logout functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.clickLogin();
		login.enterUsername();
		login.enterPassword();
		login.clickPopupLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
		
		homePage home=new homePage(driver);
		home.checklogoutbutton();
		home.logoutclick();
		login.validateLoginButton("Logout");
		
	}
	 
}

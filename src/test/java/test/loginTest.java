package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.contactListPage;
import pages.loginPage;

public class loginTest extends projectSpecification{
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void validateLoginTest() throws IOException   {
		testName="Valid Login test";
		testDescription="Test Login functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.validateLoginSubmitVisible();
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		
		contactListPage contact=new contactListPage(driver);
		contact.validateLogin();
		System.out.println("Validate LoginTest Successfully finished");
		
	}
	@Test
	public void invalidLoginTest() throws IOException   {
		testName="InValid Login test";
		testDescription="Test Invalid Login functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.enterInvalidEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();
		login.checkInvalidLogin();
		System.out.println("Invalid LoginTest Successfully finished");
		
	}

}

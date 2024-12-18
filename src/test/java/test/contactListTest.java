package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.contactListPage;
import pages.loginPage;

public class contactListTest extends projectSpecification {
	
	@BeforeTest
	public void config() {
		sheetName ="Addcontact";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void validateContactDisplayTest() throws IOException {
		
		testName="Contact Display Test";
		testDescription="Test Contact list display";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		//LoginPage Test
		loginPage login=new loginPage(driver);
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();
		System.out.println("Successfully Logged In"); 
		
		//ContactList Test
		contactListPage contact=new contactListPage(driver);
		contact.checkLastNameOrder();
	}
	
	@Test
	public void logoutTest() throws IOException {
		testName="Logout test";
		testDescription="Test Logout functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		//Login
		loginPage login=new loginPage(driver);
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();
		System.out.println("Successfully Logged In"); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		
		//ContactList Test
		contactListPage contact=new contactListPage(driver);
		contact.clicklogoutButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		login.checkLogout();
		
	}

}

package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;
import pages.contactDetailsPage;
import pages.contactListPage;
import pages.loginPage;

public class contactDetailTest extends projectSpecification {
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void checkContactDetail() throws IOException   {
		testName="Contact Detail test";
		testDescription="Test Contact Detail redirection functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		
		contactListPage contact=new contactListPage(driver);
		contact.clickContact(1);
		
		contactDetailsPage contactDetail=new contactDetailsPage(driver);
		contactDetail.checkContactDetailDisplay();
				
	}
	@Test
	public void editContactDetailTest() throws IOException   {
		testName="Contact Detail Edit";
		testDescription="Test Contact Detail edit functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		
		contactListPage contact=new contactListPage(driver);
		String[] contactListData = contact.getContactListDetail(1);
		contact.clickContact(1);
		
		contactDetailsPage contactDetail=new contactDetailsPage(driver);
		contactDetail.clickEditContactButton();
		contactDetail.editContact("v1");
		contactDetail.clickSubmitButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("edit-contact")));
		contactDetail.checkContactEdit("v1");

		contactDetail.clickEditContactButton();
		contactDetail.enterCity(null);
				
	}
	@Test
	public void deleteContactTest() throws IOException   {
		testName="Contact Deletion test";
		testDescription="Test Contact Deletion functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		
		contactListPage contact=new contactListPage(driver);
		int countBefore = contact.getContactCount();
		contact.clickContact(1);
		
		contactDetailsPage contactDetail=new contactDetailsPage(driver);
		contactDetail.clickDeleleContactButton();
		contactDetail.checkDeleteAlert();
		driver.switchTo().alert().accept();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		int countAfter = contact.getContactCount();

		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(countBefore-1,countAfter);
		assertObj.assertAll();
		if(countBefore-countAfter == 1) {
			System.out.println("Contact deletion has not affected other contacts");
			test.pass("Contact deletion has not affected other contacts",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactDeletion")).build());
		}else {
			System.out.println("Contact deletion has affected other contacts");
			test.pass("Contact deletion has not affected other contacts",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ContactDeletion")).build());
		
		}
				
	}
	
}

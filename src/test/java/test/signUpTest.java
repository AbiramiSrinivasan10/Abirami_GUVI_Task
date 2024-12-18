package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.projectSpecification;
import pages.signUpPage;

public class signUpTest extends projectSpecification{
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	
	@Test
	public void validateSignupTest () throws IOException{
		testName="Signup test";
		testDescription="Test Signup functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		signUpPage signUp = new signUpPage(driver);
		signUp.clickSignupButton();
		signUp.validateSignUpClick();
		signUp.enterFirstName();
		signUp.enterLastName();
		signUp.enterEmail();
		signUp.enterPassword();
		signUp.clickSubmitButton();
		System.out.println("Successfully SignedUp");
	
	}
	
	

}

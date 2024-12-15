package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
//import pages.loginPage;
import pages.signupPage;

public class signupTest extends projectSpecification{
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void validateSignupTest () throws IOException{

		testName="SignUp Test";
		testDescription="Test SignUp button functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		signupPage signUp = new signupPage(driver);
		signUp.validateSignUpButton();
		signUp.clickSignup();
		signUp.validateSignUpWindow();
	
	}	
}


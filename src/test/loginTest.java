package test;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.loginPage;

public class loginTest extends projectSpecification{

	@BeforeTest
	public void setup() throws IOException {
		
		readFromPropFile("Logintest");
		sheetName ="Login";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	
	@Test(dataProvider = "excelRead")
	public void loginTestCase (	String testCase, 
								String testDesc, 
								String userName, 
								String password, 
								String result, 
								String expectedMessage) throws IOException{
		
		// TODO Auto-generated method stub

		testName=testCase;
		testDescription=testDesc;
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		//Login page
		loginPage login = new loginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickLogin();
		
		//Validate test results
		login.validateLogin(testCase, result, expectedMessage);
	}

}
package test;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.addContactPage;
import pages.contactListPage;
import pages.loginPage;

public class addContactTest  extends projectSpecification {
	
	@BeforeTest
	public void config() {
		sheetName ="Addcontact";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void validateAddContactTest(	String testCase,
							String testDesc,
							String firstname,
							String lastname,
							String dateofbirth,
							String email,
							String phone,
							String streetAdd1,
							String streetAdd2,
							String city,
							String state,
							String pincode,
							String country,
							String result,
							String expectedMessage) throws IOException {
		
		testName="Contact Addition "+testCase;
		testDescription=testDesc;
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	
		//login test
		loginPage login=new loginPage(driver);
		login.enterEmailId();
		login.enterPassword();
		login.clickLoginSubmitButton();
		System.out.println("Successfully Logged In"); 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("My Contacts"));
		
		//ContactList Test
		contactListPage contact=new contactListPage(driver);
		int beforeCount = contact.getContactCount();
		contact.clickAddNewContactButton();
			
		//AddContact Test
		addContactPage addcontact=new addContactPage(driver);
		addcontact.enterFirstName(firstname);
		addcontact.enterLastName(lastname);
		addcontact.enterBirthDate(dateofbirth);
		addcontact.enterEmail(email);
		addcontact.enterPhoneno(phone);
		addcontact.enterStreetName1(streetAdd1);
		addcontact.enterStreetName2(streetAdd2);
		addcontact.enterCityName(city);
		addcontact.enterStateName(state);
		addcontact.enterPostalCode(pincode);
		addcontact.enterCountryName(country);
		addcontact.clickSubmitButton();
		
		addcontact.validateAddContact(testCase, result, expectedMessage);
		
		Set<String> positiveTestCases = Set.of("TC_001", "TC_005", "TC_006", "TC_007", "TC_008", "TC_009"); 
		if(positiveTestCases.contains(testCase) ) {
			contact.checkAllcontactsAdded(beforeCount+1);
			contact.validateContactData(firstname,
										lastname,
										dateofbirth,
										email,
										phone,
										streetAdd1,
										streetAdd2,
										city,
										state,
										pincode,
										country );
			if(phone.contains("+91")) {
				contact.validatePhoneExtensionDisplay(firstname,lastname,phone);
			}
		}
	}
}

package testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.bookaHotelPage;
import pages.bookingConfirmationPage;
import base.projectSpecification;
import base.utility;
import pages.loginPage;
import pages.searchHotelPage;
import pages.selectHotelPage;

public class bookaHotelTest extends projectSpecification {
	
	@BeforeTest
	public void config() {
		sheetName ="Book";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}

	
	@Test(dataProvider = "excelRead")
	public void bookTest (	String testCase,
							String testDesc,
							String userName,
							String password,
							String location,
							String firstName,
							String lastName,
							String address,
							String creditCardNumber,
							String creditCardType,
							String expiryMonth,
							String expiryYear,
							String cvvNumber,
							String result,
							String expectedMessage) throws IOException {

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
		
		//Search Page
		searchHotelPage searchPage=new searchHotelPage(driver);
		searchPage.enterLocation(location);
		searchPage.clickSubmit();
		
		//Select Hotel
		selectHotelPage selectpage= new selectHotelPage(driver);
		selectpage.selecthotel();
		selectpage.clickcontinue();
		
		//Book Hotel
		bookaHotelPage bookpage=new bookaHotelPage(driver);
		bookpage.EnterFirstname(firstName);
		bookpage.EnterLastname(lastName);
		bookpage.EnterAddress(address);
		bookpage.EntercardNo(creditCardNumber);
		bookpage.Selectcardtype(creditCardType);
		bookpage.Selectexpmonth(expiryMonth);
		bookpage.Selectexpyear(expiryYear);
		bookpage.Entercvvno(cvvNumber);
		bookpage.book();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		bookpage.validateBookhotel(testCase, result, expectedMessage);

		bookingConfirmationPage confirmPage=new bookingConfirmationPage(driver);
		switch(testCase) {
		  case "TC_023":
				confirmPage.validateBookingResult();
				test.pass(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;   
		  case "TC_024":
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
				confirmPage.validateBookingName(expectedMessage);
				test.fail(result, MediaEntityBuilder.createScreenCaptureFromPath(utility.screenshot(testCase)).build());
				break;
		}
		
	}
}


package testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.searchHotelPage;
import base.projectSpecification;
import pages.bookedItineraryPage;
import pages.loginPage;

public class otherTest extends projectSpecification {
	
	@BeforeTest
	public void config() {
		sheetName ="Other";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void otherScenarioTest (String testCase, 
							String testDesc, 
							String userName,
							String password,
							String orderId,
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
		
		//Search page
		bookedItineraryPage bookedPage=new bookedItineraryPage(driver);
		bookedPage.executeTestCase(testCase,result,expectedMessage,orderId);
	}
}

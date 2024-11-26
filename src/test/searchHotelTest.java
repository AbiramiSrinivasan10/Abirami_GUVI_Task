package test;

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
import pages.loginPage;
//import base.Utility;

public class searchHotelTest extends projectSpecification {
	
	@BeforeTest
	public void config() {
		sheetName ="Search";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}

	@Test(dataProvider = "excelRead")
	public void searchTest (String testCase, 
							String testDesc, 
							String userName,
							String password,
							String location, 
							String hotel, 
							String roomType,
							String numberOfRooms,
							String checkInDate,
							String checkOutDate,
							String adult,
							String children,
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
		searchHotelPage searchPage=new searchHotelPage(driver);
		searchPage.enterLocation(location);
		searchPage.enterHotel(hotel);
		searchPage.selectRoomtype(roomType);
		searchPage.enterNumberofRooms(numberOfRooms);
		searchPage.enterCheckindate(checkInDate);
		searchPage.enterCheckoutdate(checkOutDate);
		searchPage.enterNoofAdult(adult);
		searchPage.enterNoofChild(children);
		searchPage.clickSubmit();
		
		//Validate search results
		searchPage.validateSearch(testCase, result, expectedMessage);
	}
}

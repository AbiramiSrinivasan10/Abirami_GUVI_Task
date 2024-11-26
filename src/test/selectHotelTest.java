package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.loginPage;
import pages.searchHotelPage;
import pages.selectHotelPage;
import pages.bookaHotelPage;

public class selectHotelTest extends projectSpecification {
	
	@BeforeTest
	public void config() {
		sheetName ="Select";
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	
	@Test(dataProvider="excelRead")
	public void selectTest( String testCase,
							String testDesc,
							String userName,
							String password,
							String location,
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
	
	//validate Search
		bookaHotelPage bookPage=new bookaHotelPage(driver);
		bookPage.validateHotelSelection(testCase, result, expectedMessage);
	}
}
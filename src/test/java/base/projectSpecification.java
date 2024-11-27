package base;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class projectSpecification extends utility {

	@BeforeSuite
	public void reportInitilization() {
		
		String path="C:\\Users\\girit\\workspace\\adactHotel\\reports\\AdactinTestReport.html";
		// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Adactinhotel Report");
		
		// To capture test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void testDetails() {
		//test = extent.createTest(testName,testDescription);
		//test.assignCategory(testCategory);
		//test.assignAuthor(testAuthor);
	}
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void launchAndLoadURL(@Optional("browser")String browser, @Optional("url")String url) {

		browserLaunch("edge", "https://adactinhotelapp.com/index.php");
		
	}
	
	@DataProvider(name ="excelRead")
	public String[][] excelRead() throws IOException {
		return readExcel(sheetName);
		
	}
	
	@AfterMethod
	public void browserClose() {

		closeBrowser();
	}
	
	@AfterSuite
	public void reportClose() {
		
		extent.flush();
		
	}
	
}
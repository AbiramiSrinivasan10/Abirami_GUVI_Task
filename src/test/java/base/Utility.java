package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {
	
	public static WebDriver driver;
	public static Properties prop;
	public String sheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;
	
	
	
	public void browserLaunch(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("headless-Chrome")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			driver = new ChromeDriver(option);
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
	}
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
	public void visibilityOfElement(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void sendKeysMethod(WebElement ele, String input) {
		
		ele.sendKeys(input);
	}
	
	
	
	public static String[][] readExcel(String sheetName) throws IOException {
		//FileInputStream fis=new FileInputStream("C:\\Users\\girit\\workspace\\adactHotel\\src\\test\\java\\Utils\\AdactinTestData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\girit\\workspace\\herokuapp\\utility\\heroappData.xlsx");
		//XSSFWorkbook book = new XSSFWorkbook(fis);
		System.out.println("SN:"+sheetName);
		XSSFSheet sheet = book.getSheet(sheetName);	
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for(int i =1 ; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j =0 ; j<columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				//System.out.println(cell);
				if (!cell.equals(null)) {
					CellType cellType = cell.getCellType();
					if(cellType == CellType.STRING) {
						data[i-1][j] = cell.getStringCellValue();
					}else if(cellType == CellType.NUMERIC) {
						//Double numericValue = cell.getNumericCellValue();
						data[i-1][j] = Double.toString(cell.getNumericCellValue());
					}else if(cellType == CellType.BLANK) {
						data[i-1][j] = " ";
					}
					
				}
			}
		}
		book.close();	
		return data;
	}
	
	public static String screenshot(String name) throws IOException {
		
		String path="C:\\Users\\girit\\workspace\\herokuapp\\Snap\\"+name+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}
}
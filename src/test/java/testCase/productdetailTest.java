package testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.homePage;
import pages.loginPage;
import pages.productdetailsPage;

public class productdetailTest extends projectSpecification{
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void clickproduct() throws IOException {
		testName="Product Detail Test";
		testDescription="Test Product Detail functionality";
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
		loginPage login=new loginPage(driver);
		login.clickLogin();
		login.enterUsername();
		login.enterPassword();
		login.clickPopupLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));

		homePage home=new homePage(driver);
		String expectedPrice = home.getHomepagePrice();
		String expectedDescription = home.getHomepageDescription();
		home.clickProductlink();
		
		productdetailsPage product=new productdetailsPage(driver);
		product.checkProductDetailPageRedirection();
		product.checkProductDetails(expectedPrice, expectedDescription);
	}

}

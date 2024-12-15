package testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.projectSpecification;
import pages.cartPage;
import pages.homePage;
import pages.loginPage;
import pages.paymentPage;
import pages.productdetailsPage;

public class paymentTest extends projectSpecification{	
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void validatePaymentTest() throws IOException {
		testName="Payment Test";
		testDescription="Test Payment functionality";
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
		home.clickProductlink();
		
		productdetailsPage product=new productdetailsPage(driver);
		product.clickaddtoCartButton();
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		product.clickcartbutton();
		
		cartPage cart=new cartPage(driver);
		cart.clickplaceorderbutton();

		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Name:']")));
		
		paymentPage payment=new paymentPage(driver);
		payment.validateName();
		payment.validateCountry();
		payment.validateCity();
		payment.enterBuyerName();
		payment.enterCountryName();
		payment.enterCityName();
		payment.enterCreditCardNo();
		payment.enterMonth();
		payment.enterYear();
		payment.clickPurchaseButton();
		payment.validateOrderConfirmation();
		payment.clickOkButton();
		
	}

}

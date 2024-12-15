package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;

public class paymentPage extends projectSpecification {
    WebDriver driver;
	
	public paymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[text()='Name:']")WebElement buyerName;
	@FindBy(xpath="//label[text()='Country:']")WebElement country;
	@FindBy(xpath="//label[text()='City:']")WebElement city;
	@FindBy(xpath="//label[text()='Credit card:']")WebElement creditcard;
	@FindBy(xpath="//label[text()='Month:']")WebElement month;
	@FindBy(xpath="//label[text()='Year:']")WebElement year;
	@FindBy(xpath="//button[text()='Purchase']")WebElement purchase;
	@FindBy(id="name")WebElement entername;
	@FindBy(id="country")WebElement entercountry;
	@FindBy(id="city")WebElement entercity;
	@FindBy(id="card")WebElement entercreditcard;
	@FindBy(id="month")WebElement entermonth;
	@FindBy(id="year")WebElement enteryear;
	@FindBy(xpath="/html/body/div[10]/div[7]/div/button")WebElement okButton;
	@FindBy(xpath="/html/body/div[10]/h2")WebElement orderConfirmation;
	public void enterBuyerName() {
		entername.sendKeys("Abirami Srinivasan");
	}
	public void enterCountryName() {
		entercountry.sendKeys("India");
	}
	public void enterCityName() {
		entercity.sendKeys("Hydrabad");
	}
	public void enterCreditCardNo() {
		entercreditcard.sendKeys("2345654322345678");
	}
	public void enterMonth() {
		entermonth.sendKeys("12");
	}
	public void enterYear() {
		enteryear.sendKeys("2024");
	}
	public void clickPurchaseButton() {
		purchase.click();
		System.out.println("Purchase button clicked");
	}
	public void clickOkButton() {
		okButton.click();
		System.out.println("OK button clicked");
	}
	public void validateOrderConfirmation() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[10]/h2")));
		if(orderConfirmation.getText().contains("Thank you for your purchase!")) {
			System.out.println("Order placed successfully");
			test.pass("Order placed successfully", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("OrderScreen")).build());
		}else {
			System.out.println("Error in purchase");
			test.fail("Error in purchase", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("OrderScreen")).build());
		}
	}
	
	public void validateName() throws IOException {
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: Name:");
		System.out.println("Actual: "+buyerName.getText());
		
		if(buyerName.getText().contains("Name:") ) {
			System.out.println("Name field present");
			test.pass("Name field present");
		} else {
			System.out.println("Name field not present");
			test.fail("Name field not present");
		}
	
	}	
	public void validateCountry() throws IOException {
		
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: Country:");
		System.out.println("Actual: "+country.getText());
		
		if(country.getText().contains("Country:") ) {
			System.out.println("Country field present");
			test.pass("Country field present");
		} else {
			System.out.println("Country field not present");
			test.fail("Country field not present");
		}
	
	}	
	public void validateCity() throws IOException {
		
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: City:");
		System.out.println("Actual: "+city.getText());
		
		if(city.getText().contains("City:") ) {
			System.out.println("City field present");
			test.pass("City field present");
		} else {
			System.out.println("City field not present");
			test.pass("City field not present");
		}
	
	}	
}

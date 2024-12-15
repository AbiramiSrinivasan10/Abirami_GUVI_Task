package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;

public class productdetailsPage  extends projectSpecification {
    WebDriver driver;
	
	public productdetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Samsung galaxy s6']")WebElement product;
	@FindBy(xpath="//a[text()='Add to cart']")WebElement addtocartButton;
	@FindBy(xpath="(//h3[@class='price-container'])[1]")WebElement detailPagePrice;
	@FindBy(xpath="//p[contains(text(),'The Samsung Galaxy S6 is')]")WebElement detailPageDescription;
	@FindBy(id="cartur")WebElement cartbutton;
	
	
	public void clickaddtoCartButton() {
		addtocartButton.click();
		System.out.println("Cart Button Clicked");
	}
	public String getproductprice() {
		String[] priceArray = detailPagePrice.getText().split(" ");
		String price = priceArray[0].replaceAll("\\$", "");
		System.out.println("Product price: "+price);
		return price;
	}
	public void clickcartbutton() {
		cartbutton.click();
	}
	
	public void checkProductDetailPageRedirection() throws IOException {
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: Add to cart");
		System.out.println("Actual: "+addtocartButton.getText());
		
		if(addtocartButton.getText().contains("Add to cart") ) {
			System.out.println("Product link clicked and redirected to the product detail page");
			test.pass("Product link clicked and redirected to the product detail page");
		} else {
			System.out.println("Product link clicked and not redirected to the product detail page");
			test.fail("Product link clicked and not redirected to the product detail page");
		}
	}
	public void checkProductDetails(String expectedPrice, String expectedDescription) throws IOException {
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: "+expectedPrice);
		System.out.println("Actual: "+detailPagePrice.getText());
		assertObj.assertTrue(detailPagePrice.getText().contains(expectedPrice), "Price Validated");
		
		System.out.println("Expected: "+expectedDescription);
		System.out.println("Actual: "+detailPageDescription.getText());
		assertObj.assertEquals(expectedDescription, detailPageDescription.getText());
		assertObj.assertAll();
		test.pass("Validated price and description", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LoginButton")).build());
		
	}
	public void checkcartAddition() {
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals("Product added.", alertMessage);
		assertObj.assertAll();
	}

}

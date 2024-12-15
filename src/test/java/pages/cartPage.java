package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;
import base.projectSpecification;

public class cartPage extends projectSpecification {
    WebDriver driver;
	
	public cartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="totalp")WebElement cartTotalPrice;	
	@FindBy(xpath="//button[text()='Place Order']")WebElement placeorderbutton;
	
	
	public void deleteProduct(int productPosition) {
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr["+productPosition+"]/td[4]/a")).click();
	}	
	
	public void clickplaceorderbutton() {
		placeorderbutton.click();
		System.out.println("PlaceOrder Button Clicked`");
	}
	
	public void checkCartQuantity(int expectedQuantity) {
		int actualQuantity = driver.findElements(By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/div/table/tbody/tr")).size();
		System.out.println("Expected Quantity: "+expectedQuantity);
		System.out.println("Actual Quatity: "+actualQuantity);
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actualQuantity, expectedQuantity);
		assertObj.assertAll();
		System.out.println("Cart Quantity validated");
		test.pass("Cart Quantity validated");
	}
	
	public void checkTotalCartPrice(int expectedTotalPrice, int expectedQuantity) throws IOException {
		System.out.println("Expected Total Price: "+expectedTotalPrice);
		System.out.println("Actual Total Price: "+cartTotalPrice.getText());
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(String.valueOf(expectedTotalPrice), cartTotalPrice.getText());
		assertObj.assertAll();
		System.out.println("Cart Total Price validated");
		test.pass("Cart Total Price validated", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Cart"+expectedQuantity)).build());
		
	}

}

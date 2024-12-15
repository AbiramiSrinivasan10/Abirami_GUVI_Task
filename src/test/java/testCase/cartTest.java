package testCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
import pages.productdetailsPage;

public class cartTest  extends projectSpecification{
	
	@BeforeTest
	public void setup() throws IOException {
		testAuthor="Abirami";
		testCategory="Smoke Testing";
	}
	@Test
	public void addCartTest() throws IOException {
		testName="Cart Functionality Test";
		testDescription="Test Cart functionality";
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
		String productprice1=product.getproductprice();
		product.clickaddtoCartButton();
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		
		product.checkcartAddition();
		driver.switchTo().alert().accept();
		String productprice2=product.getproductprice();
		product.clickaddtoCartButton();
		alert1 = wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		int expectedTotalPrice=Integer.parseInt(productprice1)+Integer.parseInt(productprice2);
		product.clickcartbutton();
		
		cartPage cart=new cartPage(driver);
		cart.checkCartQuantity(2);
		cart.checkTotalCartPrice(expectedTotalPrice,2);
		
		System.out.println("Validation cart deletion:");
		test.info("Validation cart deletion:");
		cart.deleteProduct(1);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> cartList = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/div/table/tbody/tr"),1));
		cart.checkCartQuantity(1);
		cart.checkTotalCartPrice(Integer.parseInt(productprice2),1);
		cart.deleteProduct(1);
		
	}

}

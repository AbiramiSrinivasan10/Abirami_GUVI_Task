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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Utility;

//import com.aventstack.extentreports.util.Assert;

import base.projectSpecification;
//import junit.framework.Assert;

public class homePage extends projectSpecification {
    WebDriver driver;
	
	public homePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="nameofuser")WebElement nameuser;
	@FindBy(id="navbarExample")WebElement menu;
	@FindBy(xpath="//div[@class='list-group']")WebElement categories;
	@FindBy(xpath="//a[@id='nava']")WebElement logo;
	@FindBy(id="logout2")WebElement logout;
	@FindBy(xpath="//a[text()='Samsung galaxy s6']")WebElement product;
	@FindBy(xpath="//h5[contains(text(),'$360')]")WebElement price;	
	@FindBy(id="article")WebElement productdescription;

	
	public void welcomeuser() throws IOException {
		if(nameuser.isDisplayed()) {
			System.out.println("Welcome User Displayed");
			test.pass("Welcome User Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("WelcomePage")).build());
		}else {
			System.out.println("Welcome User not Displayed");
			test.fail("Welcome User not Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("WelcomePage")).build());
		}
		
	}
	public void menubar() throws IOException {
		System.out.println("Menu Items : "+menu.getText());
		test.pass("Menu items Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("MenuItem")).build());
	}
	public void categorylist() throws IOException {
		System.out.println("Categories list : "+categories.getText());
		test.pass("Categories list Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Categorylist")).build());
	}
	public void displaylogo() throws IOException {
		
		if(logo.isDisplayed()) {
			System.out.println("Logo is Displayed");
			test.pass("Logo Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LogoScreen")).build());
		}else {
			System.out.println("Logo is not Displayed");
			test.fail("Logo not Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LogoScreen")).build());
		}
	}
	public void checklogoutbutton() throws IOException{
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: Log out");
		System.out.println("Actual: "+logout.getText());
		
		if(logout.getText().contains("Log out") ) {
			System.out.println("Log out button available");
			test.pass("User logged in Successfully", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LogoutButton")).build());
		} else {
			System.out.println("Log out button not available");
			test.fail("User login failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("LogoutButton")).build());
		}
	}
	public void logoutclick() {
		logout.click();
		System.out.println("Log out clicked");
	}
	public void clickProductlink() {
		product.click();
		System.out.println("Product link clicked");
	}
	public String getHomepagePrice() {
		System.out.println("Product homepage price: "+price.getText());
		return price.getText();
	}
	public String getHomepageDescription() {
		System.out.println("Product description: "+productdescription.getText());
		return productdescription.getText();
		
	}
}

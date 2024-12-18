package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.collect.Ordering;

import base.Utility;
import base.projectSpecification;

public class contactListPage extends projectSpecification {
WebDriver driver;
	
	public contactListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-contact")WebElement addNewContactButton;
	@FindBy(id="logout")WebElement logoutButton;

	public void clickAddNewContactButton() {
		addNewContactButton.click();
	}
	public  void clicklogoutButton() {
		logoutButton.click();
	}
	public void checkAllcontactsAdded(int noOfContact) {
		int actualContact = driver.findElements(By.xpath("//table[@id='myTable']/tr")).size();
		System.out.println("Expected Quantity: "+noOfContact);
		System.out.println("Actual Quatity: "+actualContact);////table[@id='myTable']
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actualContact, noOfContact);
		assertObj.assertAll();
		System.out.println("No of Contact List validated");
		test.info("Contact added successfully");
	}
	public void clickContact(int contactPosition) {
		driver.findElement(By.xpath("//*[@id='myTable']/tr["+contactPosition+"]/td[5]")).click();
	}
	public void validateLogoutButtonAvailable() {
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Expected: Log In");
		System.out.println("Actual: "+logoutButton.getText());
		assertObj.assertTrue(logoutButton.getText().contains("Log In"));
		assertObj.assertAll();
		if(logoutButton.getText().contains("Log In") ) {
			System.out.println("Logout  button available");
		} else {
			System.out.println("Logout  button not available");
		}
	}
	public void validateLogoutClick() throws IOException{
		System.out.println("Logout clicked");
		System.out.println("Expected:Contact List App");
		System.out.println("Actual: "+driver.getTitle());
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(driver.getTitle().contains("Expected:Contact List App"));
		assertObj.assertAll();

	}
	public void validateLogin() throws IOException{
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(driver.getTitle().contains("My Contacts"));
		assertObj.assertAll();
		if(driver.getTitle().contains("My Contacts")) {
			System.out.println("Login Successful");
			test.pass("Login Successful", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ValidLogin")).build());
		}else {
			System.out.println("Login failed");
			test.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("ValidLogin")).build());
		}
	}
	public void checkLastNameOrder() throws IOException {
		int contactSize = driver.findElements(By.xpath("//table[@id='myTable']/tr")).size();
		List<String> list = new ArrayList<String>();
		for(int i=1; i <= contactSize; i++) {
			String fullName = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[2]")).getText();
			String[] name = fullName.split(" ");
			list.add(name[1]);			
		}
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(Ordering.natural().isOrdered(list));
		assertObj.assertAll();
		if(Ordering.natural().isOrdered(list)) {
			System.out.println("Contact Second name in alphabetical order");
			test.pass("Contact Second name in alphabetical order", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Contactlist")).build());
		}else {
			System.out.println("Contact Second name is not in alphabetical order");
			test.fail("Contact Second name is not in alphabetical order",MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenshot("Contactlist")).build());
		}
	}
	public void validatePhoneExtensionDisplay(String firstname,
									 String lastname,
									 String phone) {
		int contactSize = driver.findElements(By.xpath("//table[@id='myTable']/tr")).size();
		String fullName = firstname+' '+lastname;
		for(int i=1; i <= contactSize; i++) {
			if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[2]")).getText().contains(fullName)) {
				//Validate Phone
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[5]")).getText().contains("+91")) {
					System.out.println("Phone number displayed with +91 extenstion");
					test.pass("Phone number displayed with +91 extenstion");
				}else {
					System.out.println("Phone number is not displayed with +91 extenstion");
					test.pass("Phone number is not displayed with +91 extenstion");
				}
			}
		}
	}
	public int getContactCount() {
		return driver.findElements(By.xpath("//table[@id='myTable']/tr")).size();
	}
	public String[] getContactListDetail(int i) {
		String[] contactListData = new String[7];	
		contactListData[0] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[2]")).getText();
		contactListData[1] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[3]")).getText();
		contactListData[2] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[4]")).getText();
		contactListData[3] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[5]")).getText();
		contactListData[4] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[6]")).getText();
		contactListData[5] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[7]")).getText();
		contactListData[6] = driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[8]")).getText();
		return contactListData;
	}
	public void checkContactEdit(String editValue, int i) {
		String[] contactListUpdated = getContactListDetail(i);
		System.out.println("Expected Editvalue: "+editValue);
		System.out.println("Actual Editvalue: "+contactListUpdated[0].substring(contactListUpdated[0].length() - 2));
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(contactListUpdated[0].substring(contactListUpdated[0].length() - 2), editValue);
		assertObj.assertEquals(contactListUpdated[4].substring(contactListUpdated[4].length() - 2), editValue);
		assertObj.assertAll();
		if (contactListUpdated[0].substring(contactListUpdated[0].length() - 2) == editValue) {
			System.out.println("Contact updated successfully");
			//test.pass
		}
			
	}
	
	public void validateContactData(String firstname,
									String lastname,
									String dateofbirth,
									String email,
									String phone,
									String streetAdd1,
									String streetAdd2,
									String city,
									String state,
									String pincode,
									String country ) throws IOException {
		int contactSize = driver.findElements(By.xpath("//table[@id='myTable']/tr")).size();
		String fullName = firstname+' '+lastname;
		for(int i=1; i <= contactSize; i++) {
			if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[2]")).getText().contains(fullName)) {
				//Validate Birth date
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[3]")).getText().contains(dateofbirth)) {
					System.out.println("BirthDate validated");
					test.pass("BirthDate validated");
				}else {
					System.out.println("BirthDate is incorrect");
					test.pass("BirthDate is incorrect");
				}

				//Validate Email
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[4]")).getText().contains(email)) {
					System.out.println("Email validated");
					test.pass("Email validated");
				}else {
					System.out.println("Email is incorrect");
					test.pass("Email is incorrect");
				}
				
				//Validate Phone
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[5]")).getText().contains(phone)) {
					System.out.println("Phone validated");
					test.pass("Phone validated");
				}else {
					System.out.println("Phone is incorrect");
					test.pass("Phone is incorrect");
				}

				//Validate Address
				String address = streetAdd1+' '+streetAdd2;
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[6]")).getText().contains(address)) {
					System.out.println("Address validated");
					test.pass("Address validated");
				}else {
					System.out.println("Address is incorrect");
					test.pass("Address is incorrect");
				}

				//Validate City Address
				String cityAddress = city+' '+state+' '+pincode;
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[7]")).getText().contains(cityAddress)) {
					System.out.println("City Address validated");
					test.pass("City Address validated");
				}else {
					System.out.println("City Address is incorrect");
					test.pass("City Address is incorrect");
				}

				//Validate Country
				if(driver.findElement(By.xpath("//*[@id='myTable']/tr["+i+"]/td[8]")).getText().contains(country)) {
					System.out.println("Country validated");
					test.pass("Country validated");
				}else {
					System.out.println("Country is incorrect");
					test.pass("Country is incorrect");
				}
			}
		}
	}
}
	

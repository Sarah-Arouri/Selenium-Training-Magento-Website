package smokeTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pageObjects.Actions;
import pageObjects.Assertions;



@Listeners
public class magentoWebsiteFunctionality extends Actions {
	Actions actions;
	Assertions assertions;
	String currentURL = "https://magento.softwaretestingboard.com/catalogsearch/result/?q=Shirt";
	String message = "Click “Write for us” link in the footer to submit a guest postt";
	String product = "Shirt";

	
//	@BeforeTest
	@BeforeSuite
	public void myInitData() throws InterruptedException {
		actions = new Actions();
		assertions = new Assertions();
		actions.maximaizeBrowser();
		actions.visitWebsite();
		Thread.sleep(2000);
	}

	@Test(description = "Testing Magento Website")
	public void myWebsiteTest() throws InterruptedException {
		extentTest = extentReport.createTest("Testing Magento Website");
		extentTest.log(Status.INFO, "magento testing started");
		
		actions.typedInSearchFeild(product);
		extentTest.log(Status.INFO, "Search for Shirt");

		assertions.checkCurrentUrlIsContains(currentURL);
		Thread.sleep(12000);
		assertions.checkHeaderIsContains(message);

		actions.clickOnRandomProduct();
		extentTest.log(Status.INFO, "Choosing Random Product");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("option-label-size-143-item-168")));

		actions.clickOnProductSize();
		extentTest.log(Status.INFO, "Choosing size for product");

		actions.clickOnProductColor();
		extentTest.log(Status.INFO, "Choosing colore for product");

		actions.clickOnAddToCartButton();
		extentTest.log(Status.INFO, "Clicking on Cart Button");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("shopping cart")));

		actions.clickOnShoppingCartLink();
		extentTest.log(Status.INFO, "Clicking in Cart Link ");

		actions.clickOnCheckoutButton();
		Thread.sleep(12000);
		actions.typedINEmailField();
		extentTest.log(Status.INFO, "Continuing to fill the requirement ");

		extentTest.log(Status.INFO, "Start fill the requirement like the name , address, etc ");
		actions.typedInFirstNameField();

		actions.typedInLastNameField();

		actions.typeInStreetAddress();

		actions.typeInCityField();

		actions.selectState();

		actions.typeInPostalCode();

		actions.selectCountry();

		actions.typeInPhone();

		extentTest.log(Status.PASS, "All The Reqs Done");
		actions.checkOnShippingMethod();

		actions.clickOnNextButton();

		Thread.sleep(12000);

		actions.shippingAddressButton();
		extentTest.log(Status.INFO, "Clicking To Confirm Button");

		Thread.sleep(12000);

		actions.clickOnPlaceOrderButton();
		Thread.sleep(9000);

		actions.orderShoppingNumber();
		extentTest.log(Status.INFO, "The Shopping Is Done");

	}

	// @AfterTest
	@AfterSuite
	public void myAfterTest() {
		actions.closeBrowser();
	}
}

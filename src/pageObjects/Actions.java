package pageObjects;

//import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import supports.Constants;
import supports.extentReportsClass;

public class Actions extends extentReportsClass implements Constants {
	public void maximaizeBrowser() {
		driver.manage().window().maximize();
	}

	public void visitWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");

	}

	public void typedInSearchFeild(String product) {
		driver.findElement(By.id("search")).sendKeys(product + Keys.ENTER);
	}

	public void clickOnRandomProduct() {
		List<WebElement> allProducts = driver.findElements(By.className("product-item"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(allProducts.size());
		allProducts.get(randomProduct).click();
	}

	public void clickOnProductSize() {
		driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]")).click();
	}

	public void clickOnProductColor() {
		// driver.findElement(By.cssSelector(".swatch-option.color")).click();
		List<WebElement> elements = driver.findElements(By.cssSelector(".swatch-option.color"));
		elements.get(0).click();

	}

	public void clickOnAddToCartButton() {
		driver.findElement(By.id("product-addtocart-button")).click();
	}

	public void clickOnShoppingCartLink() {
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")).click();
	}

	public void clickOnCheckoutButton() {
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/ul/li[1]/button")).click();
	}

	public void typedINEmailField() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(1000);
		String email = "SeleniumUser" + randomNumber + "@gmail.com";
		WebElement emailInput = driver.findElement(By.id("customer-email"));
		emailInput.sendKeys(email);
	}

	public void typedInFirstNameField() {
		driver.findElement(By.name("firstname")).sendKeys("Arouri");
	}

	public void typedInLastNameField() {
		driver.findElement(By.name("lastname")).sendKeys("Sarah");
	}

	public void typeInStreetAddress() {
		driver.findElement(By.name("street[0]")).sendKeys("pal12");
	}

	public void typeInCityField() {
		driver.findElement(By.name("city")).sendKeys("pal12");
	}

	public void selectState() {
		Select dropdown = new Select(driver.findElement(By.name("region_id")));
		dropdown.selectByVisibleText("Florida");
	}

	public void typeInPostalCode() {
		driver.findElement(By.name("postcode")).sendKeys("12345-6789");
	}

	public void selectCountry() {
		Select dropdown = new Select(driver.findElement(By.name("country_id")));
		dropdown.selectByVisibleText("Maldives");
	}

	public void typeInPhone() {
		driver.findElement(By.name("telephone")).sendKeys("0595478652");
	}

	public void checkOnShippingMethod() {
		driver.findElement(By.cssSelector("input[type='radio']:first-child")).click();

	}

	public void clickOnNextButton() {
		driver.findElement(By.cssSelector(".continue.primary")).click();

	}

	public void shippingAddressButton() {
		driver.findElement(By.xpath("//*[@id=\"billing-address-same-as-shipping-checkmo\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"billing-address-same-as-shipping-checkmo\"]")).click();

	}

	public void clickOnPlaceOrderButton() {
		// driver.findElement(By.cssSelector(".primary.checkout")).click();
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
	}

	public void orderShoppingNumber() {
		// System.out.println(driver.findElement(By.cssSelector(".checkout-success >p span")).getText());
		System.out.println(
				driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/p[1]/span")).getText());
	}

	public void closeBrowser() {
		driver.close();
	}

}

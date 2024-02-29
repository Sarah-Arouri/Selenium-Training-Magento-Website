package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import supports.Constants;

public class Assertions implements Constants {
	public void checkCurrentUrlIsContains(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}

	public void checkHeaderIsContains(String message) {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"))
				.getText(),message);
	}
//	public void checkProductAssertion() {
//		Assert.assertEquals(driver.findElements(By.className(".page-title")), email);
//	}


}

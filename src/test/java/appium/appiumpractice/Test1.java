package appium.appiumpractice;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class Test1 extends TestBase {

	@Test
	public void SubmitText() throws MalformedURLException, InterruptedException {
		setUp();
		driver.findElementById("Alert Views").click(); // use 'findElementById' for 'accessibilityId' locators
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]").click();
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello"); // use 'findElementByClassName' for 'type' locators
		driver.findElementByName("OK").click();
		tearDown();
	}
	
}

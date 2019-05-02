package appium.appiumpractice.nativeIOs;

import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class Test1 extends TestBaseNativeIOs {

	@Test
	public void TapOnTwoTabsThenSubmitTextAndNavigateBackToHomePage() throws MalformedURLException, InterruptedException {
		setUp();
		
		System.out.println("tap on 'Alert Views'");
		driver.findElementById("Alert Views").click(); // use 'findElementById' for 'accessibilityId' locators
		
		System.out.println("tap on 'Text Entry'");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]").click();
		
		System.out.println("type 'hello' on the text field that appears");
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello"); // use 'findElementByClassName' for 'type' locators
		
		System.out.println("tap on 'OK' button to submit form");
		driver.findElementByName("OK").click();
		
		System.out.println("go back to home page");
		driver.navigate().back();
		
		tearDown();
	}
	
}

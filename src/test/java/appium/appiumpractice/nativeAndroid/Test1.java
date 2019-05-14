package appium.appiumpractice.nativeAndroid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class Test1 extends TestBaseNativeAndroid {

	@Test
	public void testUsingXpath() throws MalformedURLException, InterruptedException {
		/*
		 * xpath syntax = "//tagname[@attribute='value']"
		 * 
		 * use the 'class' value on the UIAutomatorViewer as the tag name
		 * use any other unique value as the attribute, in this case the 'text' attribute has a unique value of 'Preference'
		 */
		
		this.setUp();
		System.out.println("1. click on 'Preference' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		System.out.println("2. on the next page, click on '3. Preference dependencies' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		this.tearDown();
	}
	
	@Test
	public void testUsingId() throws MalformedURLException, InterruptedException {
		/*
		 * use findElementById for 'resource-id' attributes that are unique
		 */
		
		this.setUp();
		System.out.println("1. click on 'Preference' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		System.out.println("2. on the next page, click on '3. Preference dependencies' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		System.out.println("3. on the next page, click on the 'Wifi' checkbox");
		this.driver.findElementById("android:id/checkbox").click();
		
		this.tearDown();
	}
}

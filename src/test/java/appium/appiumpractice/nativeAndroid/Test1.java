package appium.appiumpractice.nativeAndroid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Test1 extends TestBaseNativeAndroid {

	@Test
	public void testUsingXpathAndTextAttributes() throws MalformedURLException, InterruptedException {
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
	
	@Test
	public void testUsingXpathWithIndexes() throws MalformedURLException, InterruptedException {
		/*
		 * xpath syntax with indexing = driver.findElement("(//tagname)[2]")) - note: not zero indexed unlike arrays/lists
		 * 
		 * if two elements can't be differentiated by a unique attribute, use the shared 'class' name as the tagname in the xpath and select the one you want via indexing 
		 */
		
		this.setUp();
		System.out.println("1. click on 'Preference' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		System.out.println("2. on the next page, click on '3. Preference dependencies' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		System.out.println("3. on the next page, click on the 'Wifi' checkbox");
		this.driver.findElementById("android:id/checkbox").click();
		
		System.out.println("4. click on the 'Wifi settings' tab");
		this.driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		this.tearDown();
	}
	
	@Test
	public void testUsingClassNameAndSendKeys() throws MalformedURLException, InterruptedException {
		/*
		 * use findElementByClassName for 'class' attribute
		 * use .sendKeys("") to enter text into text field
		 */
		
		this.setUp();
		System.out.println("1. click on 'Preference' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		System.out.println("2. on the next page, click on '3. Preference dependencies' tab");
		this.driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		System.out.println("3. on the next page, click on the 'Wifi' checkbox");
		this.driver.findElementById("android:id/checkbox").click();
		System.out.println("4. click on the 'Wifi settings' tab");
		this.driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		System.out.println("5. on the popup dialog that appears, enter 'Starbucks' to text field");
		this.driver.findElementByClassName("android.widget.EditText").sendKeys("Starbucks");
		this.tearDown();
	}
	
	@Test
	public void testUsingAndroidUIAutomator() throws MalformedURLException, InterruptedException {
		/*
		 * syntax: driver.findElementByAndroidUIAutomator("attribute(\"value\")");
		 */
		this.setUp();
		
		System.out.println("1. click on 'Views' tab");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		this.tearDown();
	}
	
	@Test
	public void testUsingTappingTouchActions() throws MalformedURLException, InterruptedException {
		/*
		 * tap an element
		 */
		this.setUp();
		System.out.println("1. click on 'Views' tab");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println("2. click on 'Expandable Lists' tab");
		driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		System.out.println("3. Tap on 'people names' tab to expand list");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions()
				.withElement(element(driver.findElementByAndroidUIAutomator("text(\"People Names\")"))))
				.perform();
		
		this.tearDown();
	}
	
	@Test
	public void testUsingLongPressTouchActions() throws MalformedURLException, InterruptedException {
		/*
		 * long press the same element as the previous test for a different result
		 */
		this.setUp();
		System.out.println("1. click on 'Views' tab");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println("2. click on 'Expandable Lists' tab");
		driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		System.out.println("3. Long Press on 'people names' tab to display popup");
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions()
				.withElement(element(driver.findElementByAndroidUIAutomator("text(\"People Names\")")))
				.withDuration(ofSeconds(2)))
				.release()
				.perform();
		
		this.tearDown();
	}
	
	@Test
	public void testSwiping() throws MalformedURLException, InterruptedException {
		/*
		 * practice swiping (moving from one element to another) on a clock
		 * 
		 * swiping involves the following 3 actions:
		 * 1. long press on first element for 2 seconds
		 * 2. move to second element
		 * 3. release
		 */
		this.setUp();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		System.out.println("on the clock, swipe from 15min element to 45min element");
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions()
				.withElement(element(driver.findElementByXPath("//*[@content-desc='15']")))
				.withDuration(ofSeconds(2)))
				.moveTo(element(driver.findElementByXPath("//*[@content-desc='45']")))
				.release()
				.perform();
		
		this.tearDown();
	}
	
	@Test
	public void testScrollingDownUntilAnElementIsVisible() throws MalformedURLException, InterruptedException {
		/*
		 * scroll down until an element is visible
		 * 
		 * we can leverage Android functionality (classes and their instance methods) 
		 * such as UiScrollable and scrollIntoView(), respectively, 
		 * inside driver.findElementByAndroidUIAutomator() to achieve scrolling down
		 * much like how we can execute javascript code with the javascript executor
		 * 
		 * p.s. UiSelector() is also Android code that can be used to locate elements by 
		 * their properties (i.e 'clickable') not just their attributes (i.e 'text'). 
		 * ex: driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		 * 
		 */
		this.setUp();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		System.out.println("scroll down until 'WebView' element is visible");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		
		this.tearDown();
	}
	
}

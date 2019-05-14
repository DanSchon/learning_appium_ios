package appium.appiumpractice.nativeAndroid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;



public class TestBaseNativeAndroid {
	
	public AndroidDriver<AndroidElement> driver;
	
	public void setUp() throws MalformedURLException, InterruptedException {
		/* setup:
		 * 1. make sure appium server is running
		 * 2. make sure android emulator is running on command line: emulator -avd MyVirtualDevice1
		 */
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MyVirtualDevice1");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/danielschonfeld/Desktop/ApiDemos-debug.apk");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void tearDown() {
		driver.quit(); // closes the app, not the emulator
	}
	
}

package appium.appiumpractice.safariBrowserOnIOs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestBaseSafari {
	public IOSDriver<IOSElement> driver;
	
	public void setUp() throws MalformedURLException {
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");

		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void tearDown() {
		driver.quit();
	}
}

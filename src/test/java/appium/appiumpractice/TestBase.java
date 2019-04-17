package appium.appiumpractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
		public IOSDriver<IOSElement> driver;

		
		public void setUp() throws MalformedURLException {
			DesiredCapabilities d = new DesiredCapabilities();
			d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
			d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
			d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			d.setCapability(MobileCapabilityType.APP, "/Users/danielschonfeld/Desktop/UICatalog.app");
			driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), d);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void tearDown() {
			driver.quit();
		}
}

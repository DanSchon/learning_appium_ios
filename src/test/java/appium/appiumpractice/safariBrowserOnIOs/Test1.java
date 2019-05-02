package appium.appiumpractice.safariBrowserOnIOs;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test1 extends TestBaseSafari {

	@Test
	public void test() throws InterruptedException, MalformedURLException {
		super.setUp();
		driver.get("https://www.aaa.com/stop/");
		Thread.sleep(30000);
		super.tearDown();
	}
}

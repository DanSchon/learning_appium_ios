package appium.appiumpractice;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class Test1 extends TestBase {

	@Test
	public void VerifyAppLaunches() throws MalformedURLException {
		setUp();
		System.out.println("App is open on simulator");
		tearDown();
	}
	
}

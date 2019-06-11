package appium.appiumpractice.chromeBrowserOnAndroid;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test1 extends TestBaseWebAndroid {

	@Test
	public void test() throws InterruptedException, MalformedURLException {
		super.setUp();
		driver.get("https://www.aaa.com/stop/");
		driver.findElement(By.id("zipCode")).sendKeys("90094");
		driver.findElement(By.id("goButton")).click();
		super.tearDown();
	}
}

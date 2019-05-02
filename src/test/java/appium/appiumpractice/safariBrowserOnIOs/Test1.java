package appium.appiumpractice.safariBrowserOnIOs;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test1 extends TestBaseSafari {

	@Test
	public void test() throws InterruptedException, MalformedURLException {
		super.setUp();
		driver.get("https://www.aaa.com/stop/");
		driver.findElement(By.id("zipCode")).sendKeys("90094");
		driver.findElement(By.id("goButton")).click();
		Thread.sleep(30000);
		super.tearDown();
	}
}

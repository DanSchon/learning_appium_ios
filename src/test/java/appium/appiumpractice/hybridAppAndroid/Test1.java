package appium.appiumpractice.hybridAppAndroid;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test1 extends TestBaseHybridAndroid {

	@Test
	public void test() throws InterruptedException, MalformedURLException {
		super.setUp();
		
		driver.findElement(By.id("button1")).click();
		
		// switch to web view context
		Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
          System.out.println(contextName);
          if (contextName.contains("WEBVIEW")){
            driver.context(contextName);
          }
        }
        
        driver.findElement(By.cssSelector("div[data-index='1']")).click();	      
        
        // switch back to native context
        contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
          System.out.println(contextName);
          if (contextName.contains("NATIVEVIEW")){
            driver.context(contextName);
          }
        }
        
		super.tearDown();
	}
}

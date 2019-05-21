package BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewTest {
	public static AppiumDriver driver;
	public static BaseDriver base;
  @Test(priority=1)
  public void f() throws MalformedURLException {
	  
		
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "4e4e90b7");
			caps.setCapability("automationName","Appium");
			caps.setCapability("app","/Users/sivaranjani/Downloads/eBay.apk");
			driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			//System.out.println("driver value"+driver);
		}
  @Test(priority=2)
  public void checkk() throws InterruptedException
  {
	  Thread.sleep(30000);
	  WebDriverWait wait = new WebDriverWait(driver,90);
	  List<MobileElement> bb = driver.findElementsByClassName("android.widget.TextView");
	  System.out.println("Size"+bb.size());
	  for(MobileElement b :bb)
	  {
		  if(b.getText().equalsIgnoreCase("SAVED"))
		  {
//			  b.click();
//			  break;
		  }
		  System.out.println("element"+b.getText());
		  
	  }
	  //driver.findElementByXPath("//android.widget.TextView[@index=2]").click();
	 
	  driver.findElementById("com.ebay.mobile:id/capsule_selling").click();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  driver.findElementById("com.ebay.mobile:id/capsule_deals").click();

  }
  }


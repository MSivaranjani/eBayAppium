package BaseClass;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logHelper.LoggerHelper;

public class BaseDriver {
	public static AppiumDriver driver;
	public static BaseDriver base;
	public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	FileReader reader=new FileReader("src/main/resources/Capabilities.properties");  
    
    Properties p=new Properties();  
   

	private BaseDriver() throws InterruptedException, IOException {
		 p.load(reader); 
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName",p.getProperty("platformName"));
		caps.setCapability("deviceName",p.getProperty("deviceName"));
		caps.setCapability("automationName",p.getProperty("automationName"));
		caps.setCapability("app", p.getProperty("app"));
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static AppiumDriver getDriver() {
		return driver;
	}

	public static void setDriver() throws InterruptedException, IOException {
		System.out.println("base value" + base);
		if (base == null) {
			try {
				base = new BaseDriver();
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		}
	}

}

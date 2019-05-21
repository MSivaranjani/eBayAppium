package APIDemos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class apidemos {
	public AppiumDriver driver;
	String Indianprice;
	String DollarPrice;
  @BeforeTest
  public void setup() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "ZY22286VFF");
		caps.setCapability("automationName","Appium");
		caps.setCapability("app","/Users/sivaranjani/Downloads/eBay.apk");
		driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

  }
  
  @Test(priority=1)
  public void rotationcheck()
  {
	  driver.findElementByAccessibilityId("Main navigation, open").click();
	  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
  }
  
  
  public void Signin() throws InterruptedException
  {
	  driver.findElementByAccessibilityId("Main navigation, open").click();
	  driver.findElementByAccessibilityId("Sign in,double tap to activate").click();
	  Thread.sleep(8000);
	 
	 List<MobileElement> tvs = driver.findElementsByClassName("android.widget.EditText");
//	  System.out.println("ttext"+tvs.size());
	 System.out.println(driver.findElementByXPath("//android.widget.Button['Sign in']").isEnabled());
		 for(MobileElement dd:tvs)
		 {
			 System.out.println("values"+dd.getText());
			if(dd.getText().equalsIgnoreCase("Email or username"))
			{
				dd.sendKeys("sivaranjanidx@gmail.com");
			}
			else if (dd.getText().equalsIgnoreCase("Password"))
			{
				dd.sendKeys("ranjani91");
			}
		 }
		  System.out.println(driver.findElementByXPath("//android.widget.Button['Sign in']").isEnabled());
		  driver.findElementByXPath("//android.widget.Button['Sign in']").click();
	  
  }

  public void f() throws InterruptedException
  {
	  Thread.sleep(8000);
	  driver.findElementById("search_box").click();
	  Thread.sleep(8000);
	  List<MobileElement> tvs = driver.findElementsByClassName("android.widget.EditText");
	  System.out.println("tvs"+tvs.size());
		 for(MobileElement dd:tvs)
		 {
			 if(dd.getText().contentEquals("Search for anything"))
			 {
				 break;
				// dd.sendKeys("65 inch tv");
			 }
			
			}
		 
		 
	 driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("65 inch tv");
Thread.sleep(4000);
	  List<MobileElement> tvs1 = driver.findElementsByClassName("android.widget.TextView");
	 for(MobileElement dd1:tvs1)
	 {
		if(dd1.getText().startsWith("65 inch tv"))
		{
			System.out.println("Element got");
			dd1.click();
			break;
		}
		System.out.println("Element "+dd1.getText());
	 }
	 Thread.sleep(4000);
	 
	 if(driver.findElementByAccessibilityId("When you save a search, we'll let you know when a new matching item is listed double-tap to dismiss").isDisplayed())
	 {
		 driver.findElementByAccessibilityId("When you save a search, we'll let you know when a new matching item is listed double-tap to dismiss").click(); 
	 }

	 List<MobileElement>  n = driver.findElementsByClassName("android.widget.TextView");
		System.out.println("size"+n.size());
		for(MobileElement dd1:tvs1)
		 {
			
				
				
			System.out.println("Elementww "+dd1.getText());
		 }
		
		
	 if(driver.findElementByAccessibilityId("Shop by Brand").isDisplayed())
	 {
		 System.out.println();
		 driver.findElementByXPath("//android.widget.TextView[@text='LG' and @index='1']").click();
		 List<MobileElement>  n1 = driver.findElementsByClassName("android.widget.TextView");
		
	Thread.sleep(3000);
	try{
	 if(driver.findElementByAccessibilityId("Save this search to get alerts when new items arrive double-tap to dismiss").isDisplayed())
	 {
		 driver.findElementByAccessibilityId("Save this search to get alerts when new items arrive double-tap to dismiss").click(); 
	 }
	}catch(Exception e)
	{
		System.out.println("Exception thrown");
	}

					
				
			
		 
		
		 
	 }
	 Thread.sleep(3000);
	 MobileElement scroll = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Related Searches\"))"));
	 
	 
	// MobileElement el =  (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Lock screen and security\"))"));
			 scroll.click();
			 System.out.println("Scrolled till bottom");
			 
			 MobileElement scroll1 = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"LG 49UK6090 49 inch 4K UHD LED Smart TV\"))"));
			 
			 scroll1.click();
			 Thread.sleep(3000);
			 Indianprice = driver.findElementByAccessibilityId("₹19,665").getText();			 
			 driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(text(),'LG 49UK6090 49 inch 4K UHD LED Smart TV')]")).click();

	  
	  
  }

  public void check()
  {
	  
	 DollarPrice = driver.findElementByAccessibilityId("US $279.99").getText();
	 driver.findElementByAccessibilityId("Buy it now").click();  
  }
}

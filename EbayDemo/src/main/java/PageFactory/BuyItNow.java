package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BuyItNow {

	public BuyItNow() {
		System.out.println("BuyItNowtPage called");

		PageFactory.initElements(new AppiumFieldDecorator(BaseDriver.getDriver()), this);

	}

	@FindBy(id = "com.ebay.mobile:id/take_action")
	public static MobileElement Review;

	@FindBy(id = "ccom.ebay.mobile:id/textview_item_name")
	public static MobileElement BuyProductName;

	@FindBy(id = "com.ebay.mobile:id/textview_item_price")
	public static MobileElement BuydollarPrice;

	@FindBy(id = "Buy it now")
	public static MobileElement BuyItNow;

}

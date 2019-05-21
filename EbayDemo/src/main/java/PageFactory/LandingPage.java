package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage {
	public LandingPage() {
		System.out.println("Landing Page called");

		PageFactory.initElements(new AppiumFieldDecorator(BaseDriver.getDriver()), this);
		System.out.println("Landing Page  done");
	}

	@FindBy(id = "search_box")
	public static MobileElement searchbox;

	@FindBy(xpath = "//android.widget.EditText[1]")
	public static MobileElement searchbox1;

	@FindBy(id = "When you save a search, we'll let you know when a new matching item is listed double-tap to dismiss")
	public static MobileElement wishMsg1;

	@FindBy(id = "Save this search to get alerts when new items arrive double-tap to dismiss")
	public static MobileElement wishMsg2;

	@FindBy(id = "Shop by Brand")
	public static MobileElement shopByBrand;

	@FindBy(xpath = "//android.widget.TextView[@text='LG' and @index='1']")
	public static MobileElement LG;

	@FindBy(id = "com.ebay.mobile:id/item_card_shipping_cost_converted")
	public static MobileElement convertedCost;

	@FindBy(id = "com.ebay.mobile:id/textview_item_price")
	public static MobileElement dollarprice;

	@FindBy(id = "LG 49UK6090 49 inch 4K UHD LED Smart TV")
	public static MobileElement prodName;

	@FindBy(id = "com.ebay.mobile:id/capsule_selling")
	public static MobileElement Selling;

	@FindBy(id = "com.ebay.mobile:id/capsule_deals")
	public static MobileElement Deals;

	@FindBy(id = "com.ebay.mobile:id/capsule_categories")
	public static MobileElement Categories;

	@FindBy(id = "com.ebay.mobile:id/capsule_following")
	public static MobileElement Saved;

}

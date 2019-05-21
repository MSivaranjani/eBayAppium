package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class checkout {
	public checkout() {
		System.out.println("checkoutPage called");

		PageFactory.initElements(new AppiumFieldDecorator(BaseDriver.getDriver()), this);

	}

	@FindBy(id = "com.ebay.mobile:id/item_title")
	public static MobileElement checkprodName;

	@FindBy(id = "com.ebay.mobile:id/item_price")
	public static MobileElement checkdollarprice;

	@FindBy(id = "com.ebay.mobile:id/converted_price_textview")
	public static MobileElement checkconvertedprice;

}

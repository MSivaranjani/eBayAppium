package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SiginPage {
	public SiginPage() {

		PageFactory.initElements(new AppiumFieldDecorator(BaseDriver.getDriver()), this);
		System.out.println("SigninPage called");
	}

	@FindBy(id = "com.ebay.mobile:id/home")
	public static MobileElement icon;

	@FindBy(id = "com.ebay.mobile:id/textview_sign_out_status")
	public static MobileElement Signin;

	@FindBy(xpath = "//android.widget.Button['Sign in']")
	public static MobileElement SignIn;

}

package BaseClass;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BaseActions {
	public BaseActions() throws MalformedURLException, InterruptedException {
		super();

	}

	public static void ExplicitWaittobeclickable(MobileElement element) {
		System.out.println("Explicit wait called");
		WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), 120);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void click(MobileElement element) {
		element.click();

	}

	public static void scrollable(String strin) {

		MobileElement scroll = (MobileElement) BaseDriver.getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(strin))"));
		scroll.click();
	}

	public static boolean displayed(MobileElement element) {
		return element.isDisplayed();

	}

	public static boolean ischecked(MobileElement element) {
		return element.isSelected();

	}

	public static void Selectbyvalue(MobileElement element, String k) {
		Select option = new Select(element);
		option.selectByValue(k);

	}

	public static void Selectbyindex(MobileElement element, int k) {
		Select option = new Select(element);
		option.selectByIndex(k);

	}

	public static void SelectbyVisibleText(MobileElement element, String k) {
		Select option = new Select(element);
		option.selectByVisibleText(k);

	}

	public static void sendKeys(MobileElement element, String keys) {
		element.sendKeys(keys);
	}

}

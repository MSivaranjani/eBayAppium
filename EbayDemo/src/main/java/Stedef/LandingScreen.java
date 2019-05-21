package Stedef;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;

import BaseClass.BaseActions;
import BaseClass.BaseDriver;
import BaseClass.Log;
import PageFactory.BuyItNow;
import PageFactory.LandingPage;
import PageFactory.checkout;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import logHelper.LoggerHelper;

public class LandingScreen {

	LandingPage screen1;
	BuyItNow buy;
	checkout check;
	String IndianPrice;
	String DollarPrice;
	String productName;
	int count;

	@Given("^User should be on the login screen$")
	public void user_should_be_on_the_login_screen() throws Throwable {
		BaseDriver.log.info("User should be on the login screen-given started");
		Thread.sleep(10000);
		BaseDriver.log.info("User should be on the login screen-given ended");

	}

	@When("^Tap on the search icon$")
	public void tap_on_the_search_icon() throws Throwable {
		BaseDriver.log.info("User should be on the login screen-given started");

		screen1.searchbox.click();
		BaseDriver.log.info("User should be on the login screen-given ended");

	}

	@Then("^Enter the \"([^\"]*)\" in the search bar$")
	public void enter_the_value_in_the_search_bar(String searchbar) throws Throwable {
		BaseDriver.log.info("Enter value in the search box  started");
		screen1.searchbox1.sendKeys(searchbar);
		BaseDriver.log.info("Enter value in the search box  Ended");

	}

	@Then("^Select first value from the search list$")
	public void select_first_value_from_the_search_list() throws Throwable {

		List<MobileElement> tvs1 = BaseDriver.getDriver().findElementsByClassName("android.widget.TextView");
		for (MobileElement dd1 : tvs1) {
			if (dd1.getText().startsWith("65 inch tv")) {
				dd1.click();

				break;
			}

		}

	}

	@When("^User check the message over wishlist$")
	public void user_check_the_message_over_wishlist() throws Throwable {
		BaseDriver.log.info("Echeck any message over wishlist");
		if (BaseActions.displayed(LandingPage.wishMsg1)) {

			LandingPage.wishMsg1.click();
		}

	}

	@Then("^Checks Shop by brand is displayed$")
	public void checks_Shop_by_brand_is_displayed() throws Throwable {
		BaseDriver.log.info("Check shop by brand displayed");
		Assert.assertTrue(BaseActions.displayed(LandingPage.shopByBrand));
	}

	@Then("^Selects LG Brand$")
	public void selects_LG_Brand() throws Throwable {
		BaseDriver.log.info("Selects LG brand");
		BaseActions.ExplicitWaittobeclickable(LandingPage.LG);
		LandingPage.LG.click();
		if (BaseActions.displayed(LandingPage.wishMsg2)) {
			LandingPage.wishMsg2.click();
		}

	}

	@When("^Swipe  down till the end of the screen$")
	public void swipe_down_till_the_end_of_the_screen(DataTable data1) throws Throwable {
		BaseDriver.log.info("swips down till the end of the screen");
		List<List<String>> data = data1.raw();
		MobileElement scroll1 = (MobileElement) BaseDriver.getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"LG 49UK6090 49 inch 4K UHD LED Smart TV\"))"));
		
		
		MobileElement scroll = (MobileElement) BaseDriver.getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Related Searches\"))"));
		scroll.click();

		//BaseActions.scrollable(data.get(0).get(0));
	}

	@Then("^Swipe up  to find the product$")
	public void swipe_up_to_find_the_product(DataTable data2) throws Throwable {
		BaseDriver.log.info("swips up to find the product");
		List<List<String>> data = data2.raw();
		String che="LG 49UK6090 49 inch 4K UHD LED Smart TV";
		MobileElement scroll1 = (MobileElement) BaseDriver.getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"LG 49UK6090 49 inch 4K UHD LED Smart TV\"))"));
        List<MobileElement> n = BaseDriver.getDriver().findElementsByClassName("android.widget.TextView");
		System.out.println("size" + n.size());
		for (MobileElement dd1 : n) {
			if (dd1.getText().startsWith(data.get(0).get(0))) {
				productName = dd1.getText();
				System.out.println("Product name" + productName);
				count = 1;
			} else if (count == 1) {
				IndianPrice = dd1.getText();
				System.out.println("indianprice" + IndianPrice);
				break;
			}

		}

		scroll1.click();

		// BaseActions.scrollable(data.get(0).get(0));

	}

	@Then("^Storing the  text value of price and name of the product$")
	public void storing_the_text_value_of_price_and_name_of_the_product() throws Throwable {
		BaseDriver.log.info("comparing the value and name of the product in search screen and checkout screen");
		BaseActions.ExplicitWaittobeclickable(buy.BuyItNow);
		DollarPrice = buy.BuydollarPrice.getText();
		System.out.println("dollarprice" + DollarPrice);
		
		buy.BuyItNow.click();
		buy.Review.click();
		Thread.sleep(4000);
		System.out.println("ProdName" + check.checkprodName.getText());
		System.out.println("Dollarpriceprice" + check.checkdollarprice.getText());

		
		//ValidatingProduct Name in search screen and Checkout Screen
		Assert.assertEquals(productName, check.checkprodName.getText());
		// Assert.assertEquals(DollarPrice, check.checkdollarprice.getText());
		//Validating Dollar price in product s screen and Checkout Screen
		if(DollarPrice.contentEquals(check.checkdollarprice.getText()))
		{
			System.out.println("Dollar price in product  and checkout screen are same");
			
		}
		

		BaseDriver.log
				.info("compared the value and name of the product in search screen and checkout screen successfully");

	}

}

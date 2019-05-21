package Stedef;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.testng.Assert;

import BaseClass.BaseActions;
import BaseClass.BaseDriver;
import PageFactory.SiginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class Signin {

	SiginPage sign;

	@Given("^User should be in the Landing screen$")
	public void user_should_be_in_the_Landing_screen() throws Throwable {
		System.out.println("SigninPage driver" + BaseDriver.getDriver());
		BaseDriver.log.info("User should be in the landing screen");
	}

	@When("^Tap icon$")
	public void tap_icon() throws Throwable {
		Thread.sleep(10000);
		BaseDriver.log.info("Tap icon");
		BaseActions.ExplicitWaittobeclickable(sign.icon);
		System.out.println("Text " + sign.icon.getText());

		sign.icon.click();
		BaseDriver.getDriver().rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);

	}

	@Then("^Tap sign in button$")
	public void tap_sign_in() throws Throwable {
		BaseDriver.log.info("tap sign in");
		BaseActions.ExplicitWaittobeclickable(sign.Signin);

		sign.Signin.click();

		BaseDriver.getDriver().rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		Thread.sleep(4000);
	}

	@Then("^Enter \"([^\"]*)\",\"([^\"]*)\" credentials$")
	public void enter_credentials(String username, String password) throws Throwable {
		BaseDriver.log.info("enter credentials");
		List<MobileElement> tvs = BaseDriver.getDriver().findElementsByClassName("android.widget.EditText");

		System.out.println(BaseDriver.getDriver().findElementByXPath("//android.widget.Button['Sign in']").isEnabled());
		for (MobileElement dd : tvs) {
			System.out.println("values" + dd.getText());
			if (dd.getText().equalsIgnoreCase("Email or username")) {
				dd.clear();
				dd.sendKeys(username);
			} else if (dd.getText().equalsIgnoreCase("Password")) {
				dd.clear();
				dd.sendKeys(password);
			}
		}
	}

	@Then("^Tap Signin$")
	public void tap_Signin() throws Throwable {
		BaseDriver.log.info("Tap Signin");
		Assert.assertTrue(BaseDriver.getDriver().findElementByXPath("//android.widget.Button['Sign in']").isEnabled());
		sign.SignIn.click();

	}

}

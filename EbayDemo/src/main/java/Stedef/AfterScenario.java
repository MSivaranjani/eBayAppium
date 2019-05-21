package Stedef;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;

import BaseClass.BaseDriver;
import PageFactory.BuyItNow;
import PageFactory.LandingPage;
import PageFactory.SiginPage;
import PageFactory.checkout;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AfterScenario {
	
	
	@After
	public void addScreenshotOnfailure(Scenario scenario) throws IOException
	{
		Reporter.addScenarioLog(scenario.getName()+scenario.getStatus());
		if(scenario.isFailed())
		{
			File source = ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.FILE);
			 String screenshotName= scenario.getName();
			 String destination = System.getProperty("user.dir") + "/target/Reports/FailedScreenshots/" + screenshotName + ".png";
			 FileUtils.copyFile(source,new File(destination));
			 Reporter.addScreenCaptureFromPath(destination);
		}
		
	}
	
	
}

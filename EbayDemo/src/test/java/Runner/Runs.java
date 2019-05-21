package Runner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import BaseClass.BaseDriver;
import PageFactory.BuyItNow;
import PageFactory.LandingPage;
import PageFactory.SiginPage;
import PageFactory.checkout;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features="src/test/java/Features",glue="Stedef",tags={"@first"},plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/Reports/report.html"})

public class Runs extends AbstractTestNGCucumberTests {
	@BeforeClass
	public void before() throws InterruptedException, IOException
	{
		BaseDriver.setDriver();
		LandingPage screen1 = new LandingPage();
		SiginPage sign = new SiginPage();
		BuyItNow buy = new BuyItNow();
		checkout check = new checkout();
		
		System.out.println("BeforeClass is implemented");
	}
	
	@AfterClass
	public void after()
	{
		System.out.println("AfterClass is implemented");
		
	}
}
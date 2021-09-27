package com.mindtree.StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.runner.TestRunner;
import com.mindtree.uistore.HomePageUI;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
public class iOS_app {
	
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(TestRunner.class.getName());
	WebDriver driver;
	
    @Given("^Initialize the browser with chrome$")
    public void Initialize_the_browser_with_chrome() {
    	driver = ReusableComponents.loadDriver();
    }
    
    @And("^navigate to website url$")
    public void navigate_to_website_url() throws Throwable {
    	ReusableMethods.loadURL(driver);
    } 
	
    @When("^clicked on download in google play$")
    public void clicked_on_download_in_google_play() throws Throwable {
        ReusableMethods.click(HomePageUI.iOSapp, driver);
    }

    @Then("^should open the app in app store website$")
    public void should_open_the_app_in_google_playstore_website() throws Throwable {
        //
        String title = driver.getTitle().toLowerCase();
        boolean a = title.contains("urban factory");
        assertTrue(a);
    }
}

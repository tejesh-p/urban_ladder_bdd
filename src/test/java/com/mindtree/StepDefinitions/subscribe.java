package com.mindtree.StepDefinitions;

import static org.testng.Assert.assertEquals;

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
public class subscribe {
	
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(TestRunner.class.getName());
	WebDriver driver;
	
    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver = ReusableComponents.loadDriver();
    }
    
    @And("^navigate to website url$")
    public void navigate_to_website_url() throws Throwable {
    	ReusableMethods.loadURL(driver);
    }

    @When("^given a mailid and clicked on subscribe$")
    public void given_a_mailid_and_clicked_on_subscribe() throws Throwable {
        ReusableMethods.sendKeys(HomePageUI.subscribe_input, "random@gmail.com", driver);
        ReusableMethods.click(HomePageUI.subscribe_btn, driver);
    }

    @Then("^should reply saying it successful$")
    public void should_reply_saying_it_successful() throws Throwable {
        String text = ReusableMethods.getText(HomePageUI.subscribe_success, driver);
        assertEquals(text, "THANKS FOR SUBSCRIBING!");
    }

}

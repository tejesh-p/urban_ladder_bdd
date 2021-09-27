package com.mindtree.StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.runner.TestRunner;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

public class Check_Title {
	
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(TestRunner.class.getName());
	WebDriver driver;
	
	@Given("^Initialize the browser with chrome_123$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver = ReusableComponents.loadDriver();
    }
    
    @And("^navigate to website url$")
    public void navigate_to_website_url() throws Throwable {
    	ReusableMethods.loadURL(driver);
    }

    @When("^when the page loads$")
    public void when_the_page_loads() throws Throwable {
    	//wait
    }

    @Then("^check the title has \"([^\"]*)\" in it$")
    public void check_the_title_has_something_in_it(String arg) throws Throwable {
        String s = driver.getTitle();
        s = s.toLowerCase();
        arg = arg.toLowerCase();
        assertTrue(s.contains(arg));
    }
}

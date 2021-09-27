package com.mindtree.StepDefinitions;

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
public class Homepage_Login {

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

    @When("^click on login link $")
    public void click_on_login_link() throws Throwable {
    	ReusableMethods.hover(HomePageUI.header_profile, driver);
    	ReusableMethods.click(HomePageUI.Login, driver);
    }

    @Then("^navigate to login page$")
    public void navigate_to_login_page() throws Throwable {
        System.out.print("DONE");
        log.info("opened log page");
    }
}
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
public class Search {

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

    @When("^enter an (.+) in search bar and clicked on search$")
    public void enter_an_in_search_bar_and_clicked_on_search(String item) throws Throwable {
        ReusableMethods.sendKeys(HomePageUI.search_bar, item, driver);
        ReusableMethods.click(HomePageUI.search_button, driver);
    }

    @Then("^should navigate to results page$")
    public void should_navigate_to_results_page() throws Throwable {
        //pending
    }



}

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
public class Check_Instagram {
	
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

    @When("^clicked on instagram icon$")
    public void clicked_on_instagram_icon() throws Throwable {
        ReusableMethods.click(HomePageUI.insta, driver);
    }

    @Then("^should open instagram profile in new tab$")
    public void should_open_instagram_profile_in_new_tab() throws Throwable {
        String title = driver.getTitle().toLowerCase();
        boolean a = title.contains("urban factory");
        assertTrue(a);
    }


}

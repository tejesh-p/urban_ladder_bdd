package com.mindtree.StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
public class Check_Payment_methods {
	
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

    @When("^the site opens$")
    public void the_site_opens() throws Throwable {
        //wait
    }

    @Then("^check if the (.+) payment option is available$")
    public void check_if_the_payment_option_is_available(String method) throws Throwable {
        List<WebElement> pay = ReusableMethods.getElements(HomePageUI.payment_method, driver);
        boolean found = false;
        for(int i=0;i<pay.size();i++) {
        	if(pay.get(i).getAttribute("alt").toLowerCase().contains(method)) {
        		found = true;
        		break;
        	}
        }
        assertTrue(found);
    }
}

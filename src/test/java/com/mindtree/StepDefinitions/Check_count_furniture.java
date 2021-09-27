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
public class Check_count_furniture {
	
	
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

    @When("^the webpage opens$")
    public void the_webpage_opens() throws Throwable {
        //wait
    }

    @Then("^Count the number of items in furniture range is \"([^\"]*)\"$")
    public void count_the_number_of_items_in_furniture_range_is_something(String str) throws Throwable {
    	String size =new Integer(ReusableMethods.getElements(HomePageUI.n_item_furniture, driver).size()).toString();
    	assertEquals(size,str);
    }


}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",  // locate feature files in the project folder
        glue = {"stepDefinitions"},                // locate the step definitions files (step for corresponding step definition)
        dryRun = false,                            // if set true it checks every step has a corresponding code in the step definition file
        monochrome = true,                         // cleaner console output
        plugin = {
                "pretty",                               // prints Gherkin source with additional colors (readable format)
                "html:target/cucumber-reports.html",    // generate HTML report
                "json:target/cucumber.json",            // generate JSON report for integration with reporting tools
                "rerun:target/failed_scenarios.txt"     // logs failed scenarios
        },
        publish = false                                 // disable public report sharing
)

public class TestRunner extends AbstractTestNGCucumberTests {}  // essential to run Cucumber with TestNG

/*
* Cucumber common tags:
*  @smoke:          Sanity check to verify main features
*  @regression:     Full suite for regression testing
*  @wip:            Work in progress scenarios (excluded from CI runs)
*  @critical:       High-priority tests for production
*  @mobile / @web:  Environment-based tests
*  @api:            API-specific test scenarios  */
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (features = {"src/test/resources/SalesforceLoginFeature.feature"},
                  glue= {"salesforce.stepdefintion"},
                  monochrome = true,
          		  dryRun = false)
public class SalesforceRunner extends AbstractTestNGCucumberTests{

}

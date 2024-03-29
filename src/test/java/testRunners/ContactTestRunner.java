package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\New folder\\Selenium_Workspace\\CrmBDDFramework\\src\\test\\java\\features\\contacts.feature",
		glue = "stepDefinitions",
		plugin = {"pretty"},
		monochrome = true,
		strict = true,
		dryRun = false
		)
public class ContactTestRunner {

}

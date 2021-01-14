package test.app.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import test.app.utils.GenerateTestReport;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features",
		glue = { "test.app.stepdefs" },
		tags = "@apiTest",
		plugin = {"json:target/cucumber.json" },
		stepNotifications = true)

public class TestRunner {
	@AfterClass
	public static void generateReport() {
		GenerateTestReport.generateCucumberReport();
	}
}

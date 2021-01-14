package test.app.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.app.manage.BaseTestSteps;

public class Hooks {

    @Before
    public void beforeMethod() {
        BaseTestSteps.setUpMethod();
    }

    @After
    public void afterMethod(Scenario scenario) {
        // Capture screenshot on failure
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseTestSteps.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "Failure Page Screenshot");
        }
    }
}

package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.CommonMethods;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {
        // initialize browser before each scenario
        CommonMethods.getDriver();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        // attach screenshot on failure
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) CommonMethods.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
        } catch (Exception ignore) {
            // ignore any screenshot errors
        }

        CommonMethods.closeDriver();
    }
}
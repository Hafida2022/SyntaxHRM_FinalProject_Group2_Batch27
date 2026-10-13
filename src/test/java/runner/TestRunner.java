package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
<<<<<<< HEAD
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
=======
                "json:target/cucumber.json"
>>>>>>> origin/main
        }
)
public class TestRunner {
}
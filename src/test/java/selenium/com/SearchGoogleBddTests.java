package selenium.com;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/java/bdd/features", glue = "bdd.com.google.steps")
public class SearchGoogleBddTests extends AbstractTestNGCucumberTests {
}

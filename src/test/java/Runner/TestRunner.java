package Runner;

import StepDefinition.TestBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(features="src/test/java/Features/Search.feature",
glue = {"StepDefinition"},
plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase {

}

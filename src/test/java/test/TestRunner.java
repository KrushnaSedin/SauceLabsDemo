package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/SauceLabProductList.feature", glue = {"steps"},
monochrome = true,
plugin = {"pretty","html:target/HtmlReports"})
public class TestRunner {
}

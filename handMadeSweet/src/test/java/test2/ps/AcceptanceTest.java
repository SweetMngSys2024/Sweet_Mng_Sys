package test2.ps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith (Cucumber.class)
@CucumberOptions(
		features="user_case",
		plugin= {"summary","html:C:/Users/ThinkPad/git/repository/handMadeSweet/target/cucumber/report.html"},
		monochrome=true,
		snippets=SnippetType.CAMELCASE,
		glue="test2.ps"
		)

public class AcceptanceTest {

}

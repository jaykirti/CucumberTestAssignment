package runnerFiles;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		glue = { "stepdefinitions" }, 
		features = "src/main/resources/featureFiles",
		tags= {"@Registration, @CustInfo, @addProduct"}
		)

public class CucumberRun {
	@Test
	public void start() {
		
	}

}
